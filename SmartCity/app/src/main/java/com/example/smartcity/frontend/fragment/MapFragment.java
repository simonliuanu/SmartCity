package com.example.smartcity.frontend.fragment;

import com.example.smartcity.backend.cache.MapRestaurantCache;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.Pair;

import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.Manifest;
import android.content.pm.PackageManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.smartcity.R;
import com.example.smartcity.util.FirebaseUtil;
import com.example.smartcity.backend.entity.Restaurant;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

public class MapFragment extends Fragment implements OnMapReadyCallback {

    private GoogleMap myMap;
    private View mapView;

    //Used for preloading restaurant images
    private Map<String, Bitmap> imageCacheMap = new HashMap<>();

    // To obtain the device's location
    private FusedLocationProviderClient fusedLocationClient;
    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mapView = inflater.inflate(R.layout.fragment_map, container, false);

        // Initialize the map
        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(this);
        }

        // Initialize location client
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(requireActivity());

        return mapView;
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        myMap = googleMap;

        // Check if location permission is granted
        if (ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            enableUserLocation();
        } else {
            // Request permission
            ActivityCompat.requestPermissions(requireActivity(),
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, LOCATION_PERMISSION_REQUEST_CODE);
        }

        // Set user interface options for the map
        myMap.getUiSettings().setZoomControlsEnabled(true);
        myMap.getUiSettings().setMyLocationButtonEnabled(true);

        // Customize the information window
        myMap.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {
            @Override
            public View getInfoWindow(Marker marker) {
                return null; // Use default window frame
            }

            @Override
            public View getInfoContents(Marker marker) {
                // Inflate custom layout
                View infoWindowView = getLayoutInflater().inflate(R.layout.restaurant_info_window, null);

                Restaurant restaurant = (Restaurant) marker.getTag();

                ImageView imageView = infoWindowView.findViewById(R.id.res_image);
                TextView title = infoWindowView.findViewById(R.id.res_title);
                TextView rating = infoWindowView.findViewById(R.id.res_rating);
                TextView price = infoWindowView.findViewById(R.id.res_price);
                TextView category = infoWindowView.findViewById(R.id.res_category);

                if (restaurant != null) {
                    title.setText(restaurant.getName());
                    rating.setText("Rate: " + restaurant.getRating());
                    price.setText("Price: " + restaurant.getEstimated_price());
                    category.setText("Type: " + String.join(", ", restaurant.getTypes()));


                    // Check if images are in the cache
                    Bitmap cachedImage = imageCacheMap.get(restaurant.getPhoto_url());
                    if (cachedImage != null) {
                        // If the image is found in the cache, set it to the ImageView
                        imageView.setImageBitmap(cachedImage);
                    } else {
                        // If not in the cache, use a placeholder image and start loading
                        imageView.setImageResource(R.drawable.placeholder_image);

                        // Use Glide to load the image asynchronously as a Bitmap
                        Glide.with(infoWindowView)
                                .asBitmap()
                                .load(restaurant.getPhoto_url()) // Load the image using the restaurant's photo URL
                                .into(new CustomTarget<Bitmap>() {
                                    @Override
                                    public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
                                        // When the image is successfully loaded, set it to the ImageView
                                        imageView.setImageBitmap(resource);
                                        // Cache the loaded image by putting it into the image cache map for future reloading
                                        imageCacheMap.put(restaurant.getPhoto_url(), resource);
                                        // If the marker's info window is currently displayed, refresh it to show the new image
                                        if (marker.isInfoWindowShown()) {
                                            marker.showInfoWindow();
                                        }
                                    }

                                    @Override
                                    public void onLoadCleared(@Nullable Drawable placeholder) {
                                    }
                                });
                    }
                }

                return infoWindowView;
            }
        });

        // Use a custom layout when clicked
        myMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                LatLng markerPosition = marker.getPosition();
                googleMap.animateCamera(CameraUpdateFactory.newLatLng(markerPosition));
                marker.showInfoWindow();
                return true;
            }
        });
    }

    private void enableUserLocation() {
        if (ActivityCompat.checkSelfPermission(requireContext(), Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            myMap.setMyLocationEnabled(true);
            myMap.getUiSettings().setMyLocationButtonEnabled(true);

            // Get user's last known location
            fusedLocationClient.getLastLocation()
                    .addOnSuccessListener(requireActivity(), location -> {
                        if (location != null) {
                            LatLng userLocation = new LatLng(location.getLatitude(), location.getLongitude());
                            myMap.moveCamera(CameraUpdateFactory.newLatLngZoom(userLocation, 15));

                            // Show nearby restaurants (this will be implemented in the next steps)
                            showNearbyRestaurants(userLocation);
                        }
                    });
        }
    }

    // Show nearby restaurants by querying Firebase
    private void showNearbyRestaurants(LatLng userLocation) {
        // Use the location string as the key to check the cache
        String locationKey = generateLocationKey(userLocation);

        List<Pair<MarkerOptions, Restaurant>> cachedRestaurants = MapRestaurantCache.getInstance().getCachedRestaurants().get(locationKey);

        // Check if restaurants near this location have already been cached
        // Used for loading nearby restaurants in the map for the second time
        if (cachedRestaurants != null) {
            for (Pair<MarkerOptions, Restaurant> markerPair : cachedRestaurants) {
                MarkerOptions markerOptions = markerPair.first;
                Restaurant restaurant = markerPair.second;

                Marker marker = myMap.addMarker(markerOptions);
                marker.setTag(restaurant);
            }
            Log.d("MapFragment", "Loaded restaurants from cache for location: " + locationKey);
            return;
        }

        DatabaseReference restaurantRef = FirebaseUtil.getRestaurantReference();

        // Set the radius for looking nearby restaurants
        double radiusInMeters = 2000;
        double latDelta = radiusInMeters / 111320;  // Calculate the change in latitude to determine the range of nearby latitudes
        double lngDelta = radiusInMeters / (111320 * Math.cos(Math.toRadians(userLocation.latitude)));  // Calculate the change in longitude to determine the range of nearby longitude

        // Determine the range of latitude and longitude near the current location
        double northEastLat = userLocation.latitude + latDelta;
        double northEastLng = userLocation.longitude + lngDelta;
        double southWestLat = userLocation.latitude - latDelta;
        double southWestLng = userLocation.longitude - lngDelta;

        // Query restaurants within the latitude and longitude range (first filter by latitude range, then filter by longitude).
        restaurantRef.orderByChild("latitude")
                .startAt(southWestLat).endAt(northEastLat)
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        int restaurantCount = 0;
                        List<Pair<MarkerOptions, Restaurant>> restaurantMarkers = new ArrayList<>(); // Store the currently loaded restaurants

                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            Restaurant restaurant = snapshot.getValue(Restaurant.class);
                            double lat = snapshot.child("latitude").getValue(Double.class);
                            double lng = snapshot.child("longitude").getValue(Double.class);
                            String name = snapshot.child("name").getValue(String.class);

                            if (lat != 0 && lng != 0 && name != null) {

                                // Further check if the longitude is within the range
                                if (lng >= southWestLng && lng <= northEastLng) {
                                    LatLng restaurantLocation = new LatLng(lat, lng);
                                    // Calculate the distance between the user and the restaurant
                                    float[] results = new float[1];
                                    Location.distanceBetween(userLocation.latitude, userLocation.longitude, lat, lng, results);
                                    float distanceInMeters = results[0];

                                    // Ensure the restaurant is within radius kilometers
                                    if (distanceInMeters <= radiusInMeters) {
                                        restaurantCount++;
                                        Log.d("MapFragment", "Nearby Restaurant: " + name + " at (" + lat + ", " + lng + ")");

                                        // Create MarkerOptions and add it to the cache list
                                        MarkerOptions markerOptions = new MarkerOptions()
                                                .position(restaurantLocation)
                                                .title(name);
                                        restaurantMarkers.add(new Pair<>(markerOptions, restaurant));

                                        myMap.addMarker(markerOptions);
                                        Marker marker = myMap.addMarker(markerOptions);
                                        marker.setTag(restaurant); // Add restaurant information to the map marker

                                        // Preloading restaurant images and caching them
                                        preloadAndCacheImage(restaurant.getPhoto_url());
                                    }
                                }
                            }
                        }

                        // Cache the currently loaded restaurant data for subsequent loading
                        MapRestaurantCache.getInstance().getCachedRestaurants().put(locationKey, restaurantMarkers);
                        Log.d("MapFragment", "Number of restaurants found: " + restaurantCount);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Log.w("MapFragment", "Error getting data from Realtime Database.", error.toException());
                    }
                });
    }

    // Generate a standardized value for caching or looking up the geographic location key for subsequent loading.
    private String generateLocationKey(LatLng userLocation) {
        double roundedLat = Math.round(userLocation.latitude * 10000.0) / 10000.0;
        double roundedLng = Math.round(userLocation.longitude * 10000.0) / 10000.0;
        return roundedLat + "," + roundedLng;
    }

    // Used for preloading restaurant images and caching them
    private void preloadAndCacheImage(String imageUrl) {
        Glide.with(this)
                .asBitmap()
                .load(imageUrl)
                .into(new CustomTarget<Bitmap>() {
                    @Override
                    public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
                        imageCacheMap.put(imageUrl, resource);
                    }

                    @Override
                    public void onLoadCleared(@Nullable Drawable placeholder) {
                    }
                });
    }
}
