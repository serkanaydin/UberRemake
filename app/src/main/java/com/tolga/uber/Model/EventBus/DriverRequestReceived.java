package com.tolga.uber.Model.EventBus;

public class DriverRequestReceived {
    private String key;
    private String pickupLocation;
    private String getPickupLocationString;
    private String destinationLocation, destinationLocationString;

    public DriverRequestReceived() {
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getPickupLocation() {
        return pickupLocation;
    }

    public void setPickupLocation(String pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public String getGetPickupLocationString() {
        return getPickupLocationString;
    }

    public void setGetPickupLocationString(String getPickupLocationString) {
        this.getPickupLocationString = getPickupLocationString;
    }

    public String getDestinationLocation() {
        return destinationLocation;
    }

    public void setDestinationLocation(String destinationLocation) {
        this.destinationLocation = destinationLocation;
    }

    public String getDestinationLocationString() {
        return destinationLocationString;
    }

    public void setDestinationLocationString(String destinationLocationString) {
        this.destinationLocationString = destinationLocationString;
    }
}
