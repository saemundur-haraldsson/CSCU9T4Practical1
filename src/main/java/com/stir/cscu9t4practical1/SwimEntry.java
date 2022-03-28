package com.stir.cscu9t4practical1;

public class SwimEntry extends Entry {

    public String where;

    public SwimEntry(String n, int d, int m, int y, int h, int min, int s, float dist, String w) {
        super(n, d, m, y, h, min, s, dist);
        where = w;
    }

    // getter for where
    public String getWhere() {
        return where;
    }

    // setter for where
    public void setWhere(String where) {
        this.where = where;
    }

    @Override
    public String getEntry() {
        return getName() + "swam" + getDistance() + " km " + getWhere() + "in" + getHour() + ":" +
                getMin() + ":" + getSec() + "on" + getDate() + "\n";
    }
}
