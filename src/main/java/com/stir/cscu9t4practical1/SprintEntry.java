package com.stir.cscu9t4practical1;

import java.util.Calendar;

public class SprintEntry extends Entry{
    private int repetitions;
    private int recovery;

    public SprintEntry (String n, int d, int m, int y, int h, int min, int s, float dist, int repetitions, int recovery)
    {
        super(n,d,m,y,h,min,s,dist);
        this.repetitions = repetitions;
        this.recovery = recovery;
    }//constructor

    public int getRepetitions()
    {
        return repetitions;
    } //getRepetitions

    public int getRecovery()
    {
        return recovery;
    } //getRecovery

    @Override
    public String getEntry () {
        String result = getName()+" sprinted " + getRepetitions() + "x"
                + getDistance() + "m with "
                +getRecovery() + " minutes recovery on "
                +getDay()+"/"+getMonth()+"/"+getYear()+"\n";
        return result;
    } //overridden getEntry method
}
