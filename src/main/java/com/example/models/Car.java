package com.example.models;
public class Car {

    private final String licensePlate;
    private final int entryHour;
    private final int entryMinute;
    private final int entrySecond;
    private final int entryMillisecond;
    private final int exitHour;
    private final int exitMinute;
    private final int exitSecond;
    private final int exitMillisecond;
    private final double entryAllSeconds;
    private final double exitAllSeconds;
    private final double speed; // Speed in [km/h]

    public Car(
            String licensePlate,
            int entryHour,
            int entryMinute,
            int entrySecond,
            int entryMillisecond,
            int exitHour,
            int exitMinute,
            int exitSecond,
            int exitMillisecond) {
        this.licensePlate = licensePlate;
        this.entryHour = entryHour;
        this.entryMinute = entryMinute;
        this.entrySecond = entrySecond;
        this.entryMillisecond = entryMillisecond;
        this.exitHour = exitHour;
        this.exitMinute = exitMinute;
        this.exitSecond = exitSecond;
        this.exitMillisecond = exitMillisecond;

        this.entryAllSeconds = entryHour*3600 + entryMinute*60 + entrySecond + entryMillisecond/1000.0;
        this.exitAllSeconds = exitHour*3600 + exitMinute*60 + exitSecond + exitMillisecond/1000.0;

        double duration = this.exitAllSeconds - this.entryAllSeconds;
        this.speed =  3600/(duration/10.0);
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public int getEntryHour() {
        return entryHour;
    }

    public int getEntryMinute() {
        return entryMinute;
    }

    public int getEntrySecond() {
        return entrySecond;
    }

    public int getEntryMillisecond() {
        return entryMillisecond;
    }

    public int getExitHour() {
        return exitHour;
    }

    public int getExitMinute() {
        return exitMinute;
    }

    public int getExitSecond() {
        return exitSecond;
    }

    public int getExitMillisecond() {
        return exitMillisecond;
    }

    public double getEntryAllSeconds() {
        return entryAllSeconds;
    }

    public double getExitAllSeconds() {
        return exitAllSeconds;
    }

    public double getSpeed() {
        return speed;
    }
}
