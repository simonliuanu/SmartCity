package com.example.smartcity.entity;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

public class Restaurant implements Serializable, Comparable<Restaurant>{
    private String name;
    private double rating;
    private String address;
    private String photoUrl;
    private double latitude;
    private double longitude;
    private String[] types;
    private String priceLevel;
    private String estimatedPrice;
    private int userRatingsTotal;

    public Restaurant() {
    }

    // test constructor
    public Restaurant(String name, double rating, String address, String photoUrl) {
        this.name = name;
        this.rating = rating;
        this.address = address;
        this.photoUrl = photoUrl;
    }

    public Restaurant(String name, double rating, String address, String photoUrl,
                      double latitude, double longitude, String[] types,
                      String priceLevel, String estimatedPrice, int userRatingsTotal) {
        this.name = name;
        this.rating = rating;
        this.address = address;
        this.photoUrl = photoUrl;
        this.latitude = latitude;
        this.longitude = longitude;
        this.types = types;
        this.priceLevel = priceLevel;
        this.estimatedPrice = estimatedPrice;
        this.userRatingsTotal = userRatingsTotal;
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

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
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

    public String getPriceLevel() {
        return priceLevel;
    }

    public void setPriceLevel(String priceLevel) {
        this.priceLevel = priceLevel;
    }

    public String getEstimatedPrice() {
        return estimatedPrice;
    }

    public void setEstimatedPrice(String estimatedPrice) {
        this.estimatedPrice = estimatedPrice;
    }

    public int getUserRatingsTotal() {
        return userRatingsTotal;
    }

    public void setUserRatingsTotal(int userRatingsTotal) {
        this.userRatingsTotal = userRatingsTotal;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "name='" + name + '\'' +
                ", rating=" + rating +
                ", address='" + address + '\'' +
                ", photoUrl='" + photoUrl + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", types=" + String.join(", ", types) +
                ", priceLevel='" + priceLevel + '\'' +
                ", estimatedPrice='" + estimatedPrice + '\'' +
                ", userRatingsTotal=" + userRatingsTotal +
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

        // 如果 rating 相同，比较 userRatingsTotal
        if (this.userRatingsTotal != other.userRatingsTotal) {
            // 将空值视为最小值（负无穷大），空值排在前面
            Integer thisUserRatingsTotal = this.userRatingsTotal == 0 ? Integer.MIN_VALUE : this.userRatingsTotal;
            Integer otherUserRatingsTotal = other.userRatingsTotal == 0 ? Integer.MIN_VALUE : other.userRatingsTotal;
            return Integer.compare(thisUserRatingsTotal, otherUserRatingsTotal);
        }

        // 如果 userRatingsTotal 也相同，比较 priceLevel
        if (this.priceLevel != null && other.priceLevel != null) {
            int priceLevelComparison = this.priceLevel.compareTo(other.priceLevel);
            if (priceLevelComparison != 0) {
                return priceLevelComparison;
            }
        } else if (this.priceLevel != null) {
            return 1; // this.priceLevel 非空，other.priceLevel 为空
        } else if (other.priceLevel != null) {
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
                userRatingsTotal == that.userRatingsTotal &&
                Objects.equals(name, that.name) &&
                Objects.equals(address, that.address) &&
                Objects.equals(photoUrl, that.photoUrl) &&
                Arrays.equals(types, that.types) &&
                Objects.equals(priceLevel, that.priceLevel) &&
                Objects.equals(estimatedPrice, that.estimatedPrice);
    }



}
