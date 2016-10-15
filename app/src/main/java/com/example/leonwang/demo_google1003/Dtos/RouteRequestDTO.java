package com.example.leonwang.demo_google1003.Dtos;

/**
 * Created by Leon.wang on 2016/10/4.
 */

public class RouteRequestDTO  {
    private String locationName;//旅行地点
    private String travelTime;//旅行持续时间
    private String travelType;// 旅行类型

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getTravelTime() {
        return travelTime;
    }

    public void setTravelTime(String travelTime) {
        this.travelTime = travelTime;
    }

    public String getTravelType() {
        return travelType;
    }

    public void setTravelType(String travelType) {
        this.travelType = travelType;
    }
}
