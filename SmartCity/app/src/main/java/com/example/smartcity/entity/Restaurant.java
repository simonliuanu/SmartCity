package com.example.smartcity.entity;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

public class Restaurant implements Serializable, Comparable<Restaurant>{
    private int id;
    private String name;
    private double rating;
    private String address;
    private String photo_url;
    private double latitude;
    private double longitude;
    private String[] types;
    private String price_level;
    private String estimated_price;
    private int user_ratings_total;

    public Restaurant() {
    }

    // test constructor
    public Restaurant(String name, double rating, String address, String photo_url) {
        this.name = name;
        this.rating = rating;
        this.address = address;
        this.photo_url = photo_url;
    }

    public Restaurant(int id, String name, double rating, String address, String photo_url,
                      double latitude, double longitude, String[] types,
                      String price_level, String estimated_price, int user_ratings_total) {
        this.id = id;
        this.name = name;
        this.rating = rating;
        this.address = address;
        this.photo_url = photo_url;
        this.latitude = latitude;
        this.longitude = longitude;
        this.types = types;
        this.price_level = price_level;
        this.estimated_price = estimated_price;
        this.user_ratings_total = user_ratings_total;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoto_url() {
        return photo_url;
    }

    public void setPhoto_url(String photoUrl) {
        this.photo_url = photoUrl;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String[] getTypes() {
        return types;
    }

    public void setTypes(String[] types) {
        this.types = types;
    }

    public String getPrice_level() {
        return price_level;
    }

    public void setPrice_level(String priceLevel) {
        this.price_level = price_level;
    }

    public String getEstimated_price() {
        return estimated_price;
    }

    public void setEstimated_price(String estimated_price) {
        this.estimated_price = estimated_price;
    }

    public int getUser_ratings_total() {
        return user_ratings_total;
    }

    public void setUser_ratings_total(int user_ratings_total) {
        this.user_ratings_total = user_ratings_total;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "id=" + id +
                "name='" + name + '\'' +
                ", rating=" + rating +
                ", address='" + address + '\'' +
                ", photo_url='" + photo_url + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", types=" + String.join(", ", types) +
                ", price_level='" + price_level + '\'' +
                ", estimated_price='" + estimated_price + '\'' +
                ", user_ratings_total=" + user_ratings_total +
                '}';
    }


    @Override
//    public int compareTo(Restaurant other) {
//        return Double.compare(this.rating, other.rating);
//    }

    public int compareTo(Restaurant other) {
        // 首先比较 rating
        int ratingComparison = Double.compare(this.rating, other.rating);
        if (ratingComparison != 0) {
            return ratingComparison;
        }

        // 如果 rating 相同，比较 user_ratings_total
        if (this.user_ratings_total != other.user_ratings_total) {
            // 将空值视为最小值（负无穷大），空值排在前面
            Integer thisUserRatingsTotal = this.user_ratings_total == 0 ? Integer.MIN_VALUE : this.user_ratings_total;
            Integer otherUserRatingsTotal = other.user_ratings_total == 0 ? Integer.MIN_VALUE : other.user_ratings_total;
            return Integer.compare(thisUserRatingsTotal, otherUserRatingsTotal);
        }

        // 如果 user_ratings_total 也相同，比较 priceLevel
        if (this.price_level != null && other.price_level != null) {
            int priceLevelComparison = this.price_level.compareTo(other.price_level);
            if (priceLevelComparison != 0) {
                return priceLevelComparison;
            }
        } else if (this.price_level != null) {
            return 1; // this.priceLevel 非空，other.priceLevel 为空
        } else if (other.price_level != null) {
            return -1; // this.priceLevel 为空，other.priceLevel 非空
        }

        // 如果 priceLevel 也相同，比较 name
        return this.name.compareTo(other.name);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Restaurant)) return false;
        Restaurant that = (Restaurant) o;
        return Double.compare(that.rating, rating) == 0 &&
                Double.compare(that.latitude, latitude) == 0 &&
                Double.compare(that.longitude, longitude) == 0 &&
                user_ratings_total == that.user_ratings_total &&
                Objects.equals(name, that.name) &&
                Objects.equals(address, that.address) &&
                Objects.equals(photo_url, that.photo_url) &&
                Arrays.equals(types, that.types) &&
                Objects.equals(price_level, that.price_level) &&
                Objects.equals(estimated_price, that.estimated_price);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, name, rating, address, photo_url, latitude, longitude, price_level, estimated_price, user_ratings_total);
        result = 31 * result + Arrays.hashCode(types);
        return result;
    }
}
