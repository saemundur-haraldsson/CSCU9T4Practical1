package com.stir.cscu9t4practical1;

public class SprintEntry extends Entry {

    private int repetitions;
    private int recovery;

    /**
     * Constructor for SprintEntry.
     *
     * @param n    The name of the athlete.
     * @param d    The day the activity took place on.
     * @param m    The month the activity took place during.
     * @param y    The year the activity took place during.
     * @param h    The number of hours the athlete completed the activity in.
     * @param min  The number of minutes the athlete completed the activity in.
     * @param s    The number of seconds the athlete completed the activity in.
     * @param dist The distance the athlete travelled during the activity.
     * @param rep  The number of times the activity was repeated.
     * @param rec  The recovery time in-between repetitions.
     */
    public SprintEntry(String n, int d, int m, int y, int h, int min, int s, float dist, int rep, int rec) {
        super(n, d, m, y, h, min, s, dist);
        repetitions = rep;
        recovery = rec;
    }

    /**
     * Getter for the repetitions.
     *
     * @return The number of times the activity was repeated.
     */
    public int getRepetitions() {
        return repetitions;
    }

    /**
     * Getter for the recovery.
     *
     * @return The recovery time in-between repetitions.
     */
    public int getRecovery() {
        return recovery;
    }

    /**
     * Getter for the whole entry.
     *
     * @return A text summary of the details of the entry.
     */
    public String getEntry() {
        return getName() + " sprinted " + getRepetitions() + "x" + (int) getDistance() + "m in "
                + getHour() + ":" + getMin() + ":" + getSec() + " with "
                + getRecovery() + " minutes recovery on "
                + getDay()  + "/" + getMonth() + "/" + getYear() + "\n";
    }
}
