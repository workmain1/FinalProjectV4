package com.example.finalprojectv2;



import javafx.beans.property.SimpleStringProperty;

public class Satellite {
    private final SimpleStringProperty name;
    private final SimpleStringProperty country;
    private final SimpleStringProperty launchDate;
    private final SimpleStringProperty orbitType;
    private final SimpleStringProperty missionType;
    private final SimpleStringProperty operationalStatus;
    private final SimpleStringProperty associatedRocket;
    private final SimpleStringProperty mass;
    private final SimpleStringProperty dimensions;
    private final SimpleStringProperty powerSource;
    private final SimpleStringProperty communicationFrequency;
    private final SimpleStringProperty orbitPeriod;
    private final SimpleStringProperty orbitAltitude;
    private final SimpleStringProperty instrumentsPayloads;

    public Satellite(String name, String country, String launchDate, String orbitType, String missionType,
                     String operationalStatus, String associatedRocket, String mass, String dimensions,
                     String powerSource, String communicationFrequency, String orbitPeriod, String orbitAltitude,
                     String instrumentsPayloads) {
        this.name = new SimpleStringProperty(name);
        this.country = new SimpleStringProperty(country);
        this.launchDate = new SimpleStringProperty(launchDate);
        this.orbitType = new SimpleStringProperty(orbitType);
        this.missionType = new SimpleStringProperty(missionType);
        this.operationalStatus = new SimpleStringProperty(operationalStatus);
        this.associatedRocket = new SimpleStringProperty(associatedRocket);
        this.mass = new SimpleStringProperty(mass);
        this.dimensions = new SimpleStringProperty(dimensions);
        this.powerSource = new SimpleStringProperty(powerSource);
        this.communicationFrequency = new SimpleStringProperty(communicationFrequency);
        this.orbitPeriod = new SimpleStringProperty(orbitPeriod);
        this.orbitAltitude = new SimpleStringProperty(orbitAltitude);
        this.instrumentsPayloads = new SimpleStringProperty(instrumentsPayloads);
    }

    public String getName() { return name.get(); }
    public String getCountry() { return country.get(); }
    public String getLaunchDate() { return launchDate.get(); }
    public String getOrbitType() { return orbitType.get(); }
    public String getMissionType() { return missionType.get(); }
    public String getOperationalStatus() { return operationalStatus.get(); }
    public String getAssociatedRocket() { return associatedRocket.get(); }
    public String getMass() { return mass.get(); }
    public String getDimensions() { return dimensions.get(); }
    public String getPowerSource() { return powerSource.get(); }
    public String getCommunicationFrequency() { return communicationFrequency.get(); }
    public String getOrbitPeriod() { return orbitPeriod.get(); }
    public String getOrbitAltitude() { return orbitAltitude.get(); }
    public String getInstrumentsPayloads() { return instrumentsPayloads.get(); }
}
