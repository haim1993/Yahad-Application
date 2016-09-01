package com.example.shlez.yachad;

/**
 * Created by Shlez on 9/1/16.
 */
public class Business {

    private int iconId;
    private String businessName;
    private String distance;

    public Business(int iconId, String businessName, String distance) {
        this.iconId = iconId;
        this.businessName = businessName;
        this.distance = distance;
    }

    public String getDistance() { return distance; }

    public String getBusinessName() { return businessName; }

    public int getIconId() { return iconId; }

}
