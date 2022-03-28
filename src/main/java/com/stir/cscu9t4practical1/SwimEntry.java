package com.stir.cscu9t4practical1;

public class SwimEntry extends Entry {
	private String where;
	
	public SwimEntry(String n, int d, int m, int y, int h, int min, 
			int s, float dist,String where) {
		super(n, d, m, y, h, min, s, dist);
		this.where=where;

	}

	public String getWhere() {
		return where;
	}

	public String getEntry () {
		  //Alice swam 3.0 km outdoors in 0:16:7 on 1/2/2003\n
		   String result = getName()+" swam "
		             +getDistance() + " km in "
		             +getWhere()+ " in "
		             +getHour()+":"+getMin()+":"+ getSec()        	             
		             +" on " +getDay()+"/"+getMonth()+"/"+getYear()+"\n";
		   return result;
		  } //getEntry

	

}