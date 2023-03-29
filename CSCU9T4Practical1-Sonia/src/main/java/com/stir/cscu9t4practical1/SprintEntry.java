package com.stir.cscu9t4practical1;

public class SprintEntry extends Entry {

	private int repetitions;
	
	//variable to determine the duration of the sprinters recovery time
	private int recovery; 
	
	//constructor is created which is the same as the Entry class constructor 
	public SprintEntry(String n, int d, int m, int y, int h, int min, int s, float dist, int reps, int recov) {
		super(n, d, m, y, h, min, s, dist);
		
		// This constructor has two extra parameters 
		repetitions = reps;
		recovery = recov;
	}

	public int getRepetitions() {
		return repetitions;
	}
	
	public int getRecovery() {
		return recovery;
	}
	
	//The getEntry() method in Entry class is overridden and returns "sprint" 
	@Override
	public String getEntry() {
		return "Sprint";
	}
	

}
