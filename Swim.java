
public class Swim extends Entry {
private String LocationOfPool;

    //overloading operation of Entry 
	public Swim(String n, int d, int m, int y, int h, int min, int s, float dist, String where) {
		super(n, d, m, y, h, min, s, dist);
		LocationOfPool = where;
	}
	//Get method for LocationOfPool
	public String getPoolLocation() {
		return LocationOfPool;
	}
	//redefinition of getEntry method 
	public String getEntry () {
		   String result = getName()+" swam " + getDistance() + " km in an " +getPoolLocation()+" pool in"
		             +getHour()+":"+getMin()+":"+ getSec() + " on "
		             +getDay()+"/"+getMonth()+"/"+getYear()+"\n";
		   return result;
		  }
}
