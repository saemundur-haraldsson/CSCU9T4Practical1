package com.stir.cscu9t4practical1;

public class Sprint extends Entry {

    private int repititions;
    private int recovery;


    public Sprint(String n, int d, int m, int y, int h, int min, int s, float dist, int reps, int reco) {
        super(n, d, m, y, h, min, s, dist);
        repititions = reps;
        recovery = reco;
    }

    // getter for repititions
    public int getRepititions() {
        return repititions;
    }

    // setter for repititions
    public void setRepititions(int repititions) {
        this.repititions = repititions;
    }

    // getter for recovery
    public int getRecovery() {
        return recovery;
    }

    // setter for recovery
    public void setRecovery(int recovery) {
        this.recovery = recovery;
    }

    @Override
    public String getEntry() {
        return getName() + "sprinted" + getRepititions() + "x" + (int) getDistance() + "m" + "in" + getHour()
                + ":" + getMin() + ":" + getSec() + "with" + getRecovery() + "minutes of recovery" + " on " +
                getDate() + "\n";
    }
}
