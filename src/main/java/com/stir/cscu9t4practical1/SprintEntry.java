package com.stir.cscu9t4practical1;

public class SprintEntry extends Entry {
    private int recovery;
    private int repetition;

    public SprintEntry(String n, int d, int m, int y, int h, int min, int s, float dist, int rec, int rep) {
        super(n, d, m, y, h, min, s, dist);
        recovery = rec;
        repetition = rep;
    }

    public int getRecovery() {
        return recovery;
    }

    public int getRepetition() {
        return repetition;
    }

    public String getEntry() {
        String result = getName()+ " sprinted " +getRepetition()+ "x" +getDistance()+ " m in " +getHour()+ ":" +getMin()+ ":" +getSec()+ " with " +getRecovery()+ " minutes recovery on " +getDay()+ "/" +getMonth()+ "/" +getYear()+ "/";
        return result;
    }
}
