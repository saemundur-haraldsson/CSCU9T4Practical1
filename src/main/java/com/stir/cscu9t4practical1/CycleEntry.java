package com.stir.cscu9t4practical1;

import java.lang.annotation.Retention;

public class CycleEntry  extends Entry {
    private String terrain;
    private String tempo;

    public CycleEntry(String n, int d, int m, int y, int h, int min, int s, float dist, String ter, String tem) {
        super(n, d, m, y, h, min, s, dist);
        terrain = ter;
        tempo = tem;
    }

    public String getTerrain() {
        return terrain;
    }
    public String getTempo() {
        return tempo;
    }

    public String getEntry() {
        String result = getName()+ " cycled " +getDistance()+ " km in " +getHour()+ ":" +getMin()+ ":" +getSec()+ " on " +getDay()+ "/" +getMonth()+ "/" +getYear()+ "/" +getTerrain()+ "/" +getTempo()+ "/";
        return result;
    }
}