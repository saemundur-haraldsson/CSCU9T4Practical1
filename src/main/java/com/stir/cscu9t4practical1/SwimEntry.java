package com.stir.cscu9t4practical1;

import java.util.Calendar;

public class SwimEntry extends Entry
{
	protected String where;
	
	public SwimEntry()
	{
		
	}
	
	public SwimEntry(String n, int d, int m, int y, int h, int min, int s, float dist, String wh)
	{
	      name = n;
	      Calendar inst = Calendar.getInstance();
	      inst.set(y,m-1,d,h,min,s);
	      dateAndTime = inst;
	      distance = dist;
	      where = wh;
	}
	
	public String getWhere()
	{
		return where;
	}
	
	public String getSwimEntry()
	{
		return getName() + " swam " + getDistance() + "km " + getWhere() + " in " + getHour() +":" + getMin() + ":" + getSec() +
				" on " + getDay() + "/" + getMonth() + "/" + getYear() + "\n";
	}
}
