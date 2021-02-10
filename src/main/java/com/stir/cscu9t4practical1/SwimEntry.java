package com.stir.cscu9t4practical1;

import java.util.Calendar;

public class SwimEntry extends Entry{
    private String where;

    public SwimEntry (String n, int d, int m, int y, int h, int min, int s, float dist, String where)
    {
        super(n,d,m,y,h,min,s,dist);
        this.where = where;
    }//constructor

    public String getWhere()
    {
        return where;
    } //getWhere

    @Override
    public String getEntry () {
        String result = getName()+" swam " + getDistance() + " km "
        +getWhere() + " in " +getHour()+":"+getMin()+":" + getSec()
        + " on " +getDay()+"/"+getMonth()+"/"+getYear()+"\n";
        return result;
    } //overridden getEntry method
}
