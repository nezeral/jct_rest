package com.example.models;

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

}
