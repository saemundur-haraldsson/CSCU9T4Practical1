
public class Sprinting extends Entry {
	private int repetitions;
	private int recovery;

	public Sprinting(String n, int d, int m, int y, int h, int min, int s, float dist, int rep, int rec) {
		super(n, d, m, y, h, min, s, dist);
        repetitions = rep;
        recovery = rec;
}
	public int getRepetitions() {
		return repetitions;
	}
	public int getRecovery() {
		return recovery;
	}
	public String getEntry () {
		   String result = getName()+" sprinted " + getDistance() + " km with" +getRepetitions()+" repetitions with "+ getRecovery()+ 
		            " minutes of recovery in " +getHour()+":"+getMin()+":"+ getSec() + " on "
		             +getDay()+"/"+getMonth()+"/"+getYear()+"\n";
		   return result;
		  }
}