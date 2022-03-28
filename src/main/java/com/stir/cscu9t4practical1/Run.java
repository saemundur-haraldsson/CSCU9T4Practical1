package com.stir.cscu9t4practical1;

import java.time.LocalTime;

public class Run extends Entry {

    private String weather;
    private LocalTime startTime;
    private LocalTime endTime;

    public Run(String n, int d, int m, int y, int h, int min, int s, float dist, String w, LocalTime st, LocalTime et) {
        super(n, d, m, y, h, min, s, dist);
        weather = w;
        startTime = st;
        endTime = et;
    }

    // getter of weather
    public String getWeather() {
        return weather;
    }

    // setter of weather
    public void setWeather(String weather) {
        this.weather = weather;
    }

    // getter for start time of run
    public LocalTime getStartTime() {
        return startTime;
    }

    // setter for start time of run
    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    // getter for end time of run
    public LocalTime getEndTime() {
        return endTime;
    }

    // setter for end time of run
    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public String getRun() {
        return "The run was in" + weather + "weather.\n" +
                "which was through the distance of" + super.getDistance() + "km.\n"
                + "on: " + super.getDate() + "\nStart Time: " + startTime +
                "\nFinishing time: " + endTime;

    }
}
