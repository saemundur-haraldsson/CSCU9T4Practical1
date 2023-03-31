package com.stir.cscu9t4practical1;

import java.util.Calendar;

public class CycleEntry extends Entry {
	
	  private String Terrain;
	  private String Tempo;

	public CycleEntry(String n, int d, int m, int y, int h, int min, int s, float dist, 
			String Tem, String Ter) {
		super(n, d, m, y, h, min, s, dist);
		    Calendar inst = Calendar.getInstance();
		    inst.set(y,m-1,d,h,min,s);
			 Tempo = Tem;
			 Terrain = Ter;

	}
	
	 public String getTerrain () {
		    return Terrain;
		  } //getTerrain
	 
	 public String getTempo () {
		    return Tempo;
		  } //getTempo
		  

		  public String getCycleEntry () {
		   String result = getName()+" ran " + getDistance() + " km in "
		             +getHour()+":"+getMin()+":"+ getSec() + " on "
		             +getDay()+"/"+getMonth()+"/"+getYear()+ "on" + getTerrain() + "at" + 
		             getTempo() + "Tempo"+ "\n";
		   return result;
		  } //getCycleEntry
		   
		} // CycleEntry