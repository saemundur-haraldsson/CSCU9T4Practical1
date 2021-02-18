package com.stir.cscu9t4practical1;
import java.util.Calendar;

public class SprintEntry extends Entry{

    private int repetitions;
    private float recovery;

    public SprintEntry(String n, int d, int m, int y, int h, int min, int s, float dist, int reps, float recov) {

        super(n,d, m, y, h, min, s, dist);
        this.repetitions = reps;
        this.recovery = recov;

    }

    public int getRepetitions() { return repetitions; }

    public float getRecovery() { return recovery; }

    @Override
    public String getEntry() {
        return (getName() + " sprinted " + getRepetitions() + "x" + getDistance() + "m in " + getHour() + ":" + getMin() + ":" + getSec() + " with " + getRecovery() + " minutes recovery on " + getDay() + "/" + getMonth() + "/" + getYear() +"\n");
    }
}
