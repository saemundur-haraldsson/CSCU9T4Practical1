package com.stir.cscu9t4practical1;

public class SprintEntry extends Entry {
	 private int repetitions;
	 private int recovery;

	public SprintEntry(String n, int d, int m, int y, int h, int min, 
			int s, float dist,int repetitions,int recovery) {
		super(n, d, m, y, h, min, s, dist);
		this.repetitions=repetitions;
		this.recovery=recovery;
	}

	public int getRepetitions() {
		return repetitions;
	}

	public int getRecovery() {
		return recovery;
	}
	
	 public String getEntry () {
		  //Alice sprinted 4x300m in 0:16:7 with 2 minutes recovery on 1/2/2003\n
		   String result = getName()+" sprinted " + repetitions+"x"
		             +getDistance() + "m in "
		             +getHour()+":"+getMin()+":"+ getSec() 
		             +" with "+recovery+" minutes recovery"		             
		             +" on " +getDay()+"/"+getMonth()+"/"+getYear()+"\n";
		   return result;
		  } //getEntry
	

}
