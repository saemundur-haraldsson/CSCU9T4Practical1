package com.stir.cscu9t4practical1;

public class CycleEntry extends Entry {
	private String terrain;
	private String tempo;
	
	public CycleEntry(String n, int d, int m, int y, int h, int min, 
			int s, float dist,String terrain,String tempo) {
		super(n, d, m, y, h, min, s, dist);
		this.terrain=terrain;
		this.tempo=tempo;
	}
	
	public String getTerrain() {
		return terrain;
	}
	public String getTempo() {
		return tempo;
	}

	public String getEntry () {
		  //Alice cycled 3.0 km in 0:16:7 on 1/2/2003 on asphalt at moderate tempo\n
		   String result = getName()+" cycled "
		             +getDistance() + "km in "
		             +getHour()+":"+getMin()+":"+ getSec() 		             		             
		             +" on " +getDay()+"/"+getMonth()+"/"+getYear()
		             +" on " +getTerrain()+" at " +getTempo()+" tempo\n" ;
		   return result;
		  } //getEntry

}
