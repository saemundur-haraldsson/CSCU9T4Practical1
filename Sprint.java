
public class Sprint extends Entry {
	private int repetitions;
	private int recovery;
    
	//overloading of Entry method*
	public Sprint(String n, int d, int m, int y, int h, int min, int s, float dist, int rp, int rc) {
		super(n, d, m, y, h, min, s, dist);
        repetitions = rp;
        recovery = rc;
}
	//Get method to get Reps
	public int getRepetitions() {
		return repetitions;
	}
	//Get method to get recovery
	public int getRecovery() {
		return recovery;
	}
	//redefinition of getEntry method*
	public String getEntry () {
		   String result = getName()+" sprinted " + getDistance() + " km and had " +getRepetitions()+" repetitions and had "+ getRecovery()+ 
		            " minutes of recovery in " +getHour()+":"+getMin()+":"+ getSec() + " on "
		             +getDay()+"/"+getMonth()+"/"+getYear()+"\n";
		   return result;
		  }
}