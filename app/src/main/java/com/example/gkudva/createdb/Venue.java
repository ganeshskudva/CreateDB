package com.example.gkudva.createdb;

/**
 * Created by gkudva on 20/10/17.
 */

public class Venue {

    private String vId;
    private String vName;
    private String vAdd;
    private String lat;
    private String lng;

    public Venue(String vId, String vName, String vAdd, String lat, String lng) {
        this.vId = vId;
        this.vName = vName;
        this.vAdd = vAdd;
        this.lat = lat;
        this.lng = lng;
    }

    public void setvId(String vId) {
        this.vId = vId;
    }

    public void setvName(String vName) {
        this.vName = vName;
    }

    public void setvAdd(String vAdd) {
        this.vAdd = vAdd;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getvId() {

        return vId;
    }

    public String getvName() {
        return vName;
    }

    public String getvAdd() {
        return vAdd;
    }

    public String getLat() {
        return lat;
    }

    public String getLng() {
        return lng;
    }
}
