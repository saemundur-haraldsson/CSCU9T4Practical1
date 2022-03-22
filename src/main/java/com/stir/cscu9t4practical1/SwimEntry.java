package com.stir.cscu9t4practical1;

public class SwimEntry extends Entry {

    private String location;

    /**
     * Constructor for SwimEntry.
     *
     * @param n    The name of the athlete.
     * @param d    The day the activity took place on.
     * @param m    The month the activity took place during.
     * @param y    The year the activity took place during.
     * @param h    The number of hours the athlete completed the activity in.
     * @param min  The number of minutes the athlete completed the activity in.
     * @param s    The number of seconds the athlete completed the activity in.
     * @param dist The distance the athlete travelled during the activity.
     * @param loc  The location of the activity.
     */
    public SwimEntry(String n, int d, int m, int y, int h, int min, int s, float dist, String loc) {
        super(n, d, m, y, h, min, s, dist);
        location = loc;
    }

    /**
     * Getter for the location.
     *
     * @return The location of the activity.
     */
    public String getWhere() {
        return location;
    }

    /**
     * Getter for the whole entry.
     *
     * @return A text summary of the details of the entry.
     */
    public String getEntry() {
        return getName() + " swam " + getDistance() + " km " + (
                    getWhere().equals("outdoors") ? getWhere() : "in a " + getWhere()
                ) + " in "
                + getHour() + ":" + getMin() + ":" + getSec() + " on "
                + getDay() + "/" + getMonth() + "/" + getYear() + "\n";
    }
}
