package com.stir.cscu9t4practical1;

import java.util.Calendar;

public class SprintEntry extends Entry {

	  private int Repititions;
	  private int Recovery;

	public SprintEntry(String n, int d, int m, int y, int h, int min, int s, float dist, 
			int Rep, int Rec) {
		super(n, d, m, y, h, min, s, dist);
		    Calendar inst = Calendar.getInstance();
		    inst.set(y,m-1,d,h,min,s);
		    Repititions = Rep;
		    Recovery = Rec;
	}
	
	 public int getRepititions () {
		    return Repititions ;
		  } //getRepititions
	 
	 public int getRecovery () {
		    return Recovery;
		  } //getRecovery
		  

		  public String getSprintEntry () {
		   String result = getName()+" ran " + getDistance() + " km in "
		             +getHour()+":"+getMin()+":"+ getSec() + " on "
		             +getDay()+"/"+getMonth()+"/"+getYear()+"\n";
		   return result;
		  } //getSprintEntry
		   
		} // SprintEntry