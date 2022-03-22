// This class holds information about a single training session
package com.stir.cscu9t4practical1;

import java.util.Calendar;

public class Entry {

    private String name;
    private Calendar dateAndTime;
    private float distance;

    /**
     * Constructor for Entry.
     *
     * @param n    The name of the athlete.
     * @param d    The day the activity took place on.
     * @param m    The month the activity took place during.
     * @param y    The year the activity took place during.
     * @param h    The number of hours the athlete completed the activity in.
     * @param min  The number of minutes the athlete completed the activity in.
     * @param s    The number of seconds the athlete completed the activity in.
     * @param dist The distance the athlete travelled during the activity.
     */
    public Entry(String n, int d, int m, int y, int h, int min, int s, float dist) {
        name = n;
        Calendar inst = Calendar.getInstance();
        inst.set(y, m-1, d, h, min, s);
        dateAndTime = inst;
        distance = dist;
    }

    /**
     * Getter for the name.
     *
     * @return The name of the athlete associated with the entry.
     */
    public String getName() {
        return name;
    }

    /**
     * Getter for the day.
     *
     * @return The day the activity took place on.
     */
    public int getDay() {
        return dateAndTime.get(Calendar.DATE);
    }

    /**
     * Getter for the month.
     *
     * @return The month the activity took place during.
     */
    public int getMonth() {
        int month = dateAndTime.get(Calendar.MONTH) + 1;
        return month;
    }

    /**
     * Getter for the year.
     *
     * @return The year the activity took place during.
     */
    public int getYear() {
        return dateAndTime.get(Calendar.YEAR);
    }

    /**
     * Getter for the hours.
     *
     * @return The number of hours the athlete completed the activity in.
     */
    public int getHour() {
        return dateAndTime.get(Calendar.HOUR_OF_DAY);
    }

    /**
     * Getter for the minutes.
     *
     * @return The number of minutes the athlete completed the activity in.
     */
    public int getMin() {
        return dateAndTime.get(Calendar.MINUTE);
    }

    /**
     * Getter for the seconds.
     *
     * @return The number of seconds the athlete completed the activity in.
     */
    public int getSec() {
        return dateAndTime.get(Calendar.SECOND);
    }

    /**
     * Getter for the distance.
     *
     * @return The distance the athlete travelled during the activity.
     */
    public float getDistance() {
        return distance;
    }

    /**
     * Getter for the whole entry.
     *
     * @return A text summary of the details of the entry.
     */
    public String getEntry() {
        return getName() + " ran " + getDistance() + " km in "
                + getHour() + ":" + getMin() + ":" + getSec() + " on "
                + getDay() + "/" + getMonth() + "/" + getYear() + "\n";
    }
}