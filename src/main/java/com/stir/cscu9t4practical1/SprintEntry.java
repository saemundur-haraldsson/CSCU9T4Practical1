package com.stir.cscu9t4practical1;

import java.util.Calendar;

public class SprintEntry extends Entry
{
	protected int recoveryTime;
	protected int repetitions;
	
	public SprintEntry()
	{
		
	}
	
	public SprintEntry(String n, int d, int m, int y, int h, int min, int s, float dist, int recov, int reps)
	{
	      name = n;
	      Calendar inst = Calendar.getInstance();
	      inst.set(y,m-1,d,h,min,s);
	      dateAndTime = inst;
	      distance = dist; //metres
	      recoveryTime = recov;
	      repetitions = reps;
	}
	
	public int getRecoveryTime()
	{
		return recoveryTime;
	}
	
	public int getRepetitions()
	{
		return repetitions;
	}
	
	public String getSprintEntry()
	{
		return getName() + " sprinted " + getRepetitions() + "x" + (int) getDistance() + "m in " + getHour() +":" + getMin() + ":" + getSec() +
				" with " + getRecoveryTime() + " minute(s) recovery " + "on " + getDay() + "/" + getMonth() + "/" + getYear() + "\n";
	}
}
