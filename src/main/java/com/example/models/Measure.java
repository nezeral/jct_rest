package com.example.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Measure {

    @Id
    @GeneratedValue
    private Long id;
    private String licensePlate;
    private int entryHour;
    private int entryMinute;
    private int entrySecond;
    private int entryMillisecond;
    private int exitHour;
    private int exitMinute;
    private int exitSecond;
    private int exitMillisecond;

    public String getLicensePlate() {
        return licensePlate;
    }

    public String toString() {
        String licensePlate = "License Plate : " + this.licensePlate + "\n";
        String entryTime = "Entry : " + this.entryHour + this.entryMinute + entrySecond + entryMillisecond + "\n";
        String exitTime = "Exit : " + this.exitHour + this.exitMinute + exitSecond + exitMillisecond + "\n";
        return licensePlate + entryTime + exitTime;
    }

}
