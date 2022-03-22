package com.stir.cscu9t4practical1;

public class CycleEntry extends Entry {

    private String terrain;
    private String tempo;

    /**
     * Constructor for CycleEntry.
     *
     * @param n    The name of the athlete.
     * @param d    The day the activity took place on.
     * @param m    The month the activity took place during.
     * @param y    The year the activity took place during.
     * @param h    The number of hours the athlete completed the activity in.
     * @param min  The number of minutes the athlete completed the activity in.
     * @param s    The number of seconds the athlete completed the activity in.
     * @param dist The distance the athlete travelled during the activity.
     * @param terr The terrain the activity took place on.
     * @param t    The tempo of the activity.
     */
    public CycleEntry(String n, int d, int m, int y, int h, int min, int s, float dist, String terr, String t) {
        super(n, d, m, y, h, min, s, dist);
        terrain = terr;
        tempo = t;
    }

    /**
     * Getter for the terrain.
     *
     * @return The terrain the activity took place on.
     */
    public String getTerrain() {
        return terrain;
    }

    /**
     * Getter for the tempo.
     *
     * @return The tempo of the activity.
     */
    public String getTempo() {
        return tempo;
    }

    /**
     * Getter for the whole entry.
     *
     * @return A text summary of the details of the entry.
     */
    public String getEntry() {
        return getName() + " cycled " + getDistance() + " km in "
                + getHour() + ":" + getMin() + ":" + getSec() + " on "
                + getDay() + "/" + getMonth() + "/" + getYear() + " on "
                + getTerrain() + " at " + getTempo() + " tempo\n";
    }
}
