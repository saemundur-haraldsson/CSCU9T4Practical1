package com.stir.cscu9t4practical1;

import java.util.Calendar;

public class SwimEntry extends Entry {

	  private String Where;

	public SwimEntry(String n, int d, int m, int y, int h, int min, int s, float dist, 
			String whe ) {
		super(n, d, m, y, h, min, s, dist);
		    Calendar inst = Calendar.getInstance();
		    inst.set(y,m-1,d,h,min,s);
			 Where = whe;

	}
	
	 
	 public String getWhere () {
		    return Where;
		  } //getWhere

		  public String getSwimEntry () {
		   String result = getName()+" ran " + getDistance() + " km in "
		             +getHour()+":"+getMin()+":"+ getSec() + " on "
		             +getDay()+"/"+getMonth()+"/"+getYear()+"\n";
		   return result;
		  } //getSwimEntry
		   
		} // SwimEntry