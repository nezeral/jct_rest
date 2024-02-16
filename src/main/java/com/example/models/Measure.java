package com.example.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Measure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public String toString() {
        String id = "ID : " + this.id + "\n";
        String licensePlate = "License Plate : " + this.licensePlate + "\n";
        String entryTime = "Entry : " + this.entryHour + this.entryMinute + entrySecond + entryMillisecond + "\n";
        String exitTime = "Exit : " + this.exitHour + this.exitMinute + exitSecond + exitMillisecond + "\n";
        return id + licensePlate + entryTime + exitTime;
    }

}
