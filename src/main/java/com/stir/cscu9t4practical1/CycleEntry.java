package com.stir.cscu9t4practical1;

import java.util.Calendar;

public class CycleEntry extends Entry
{
	protected String terrain;
	protected String tempo;
	
	public CycleEntry()
	{
		
	}
	
	public CycleEntry(String n, int d, int m, int y, int h, int min, int s, float dist, String ter, String tem)
	{
	      name = n;
	      Calendar inst = Calendar.getInstance();
	      inst.set(y,m-1,d,h,min,s);
	      dateAndTime = inst;
	      distance = dist; //km
	      terrain = ter;
	      tempo = tem;
	}
	
	public String getTerrain()
	{
		return terrain;
	}
	
	public String getTempo()
	{
		return tempo;
	}
	
	public String getCycleEntry()
	{
		return getName() + " cycled " + getDistance() + "km in " + getHour() +":" + getMin() + ":" + getSec() +
				" on " + getDay() + "/" + getMonth() + "/" + getYear() + " on " + getTerrain() + " at " +
				getTempo() + " tempo\n";
	}
}
