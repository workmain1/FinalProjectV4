package com.example.finalprojectv2;


import java.util.ArrayList;
import java.util.List;

public class Mission {
    private String name;
    private String agency;
    private String launchDate;
    private List<Satellite> satellites;

    public Mission(String name, String agency, String launchDate) {
        this.name = name;
        this.agency = agency;
        this.launchDate = launchDate;
        this.satellites = new ArrayList<>();
    }



    public void addSatellite(Satellite satellite) {
        satellites.add(satellite);
    }

    public void removeSatellite(Satellite satellite) {
        satellites.remove(satellite);
    }

    public List<Satellite> getSatellites() {
        return satellites;
    }


}

