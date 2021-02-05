
public class Swimming extends Entry {
private String poolLocation;

    //overloading of Entry method
	public Swimming(String n, int d, int m, int y, int h, int min, int s, float dist, String poolLoc) {
		super(n, d, m, y, h, min, s, dist);
		poolLocation = poolLoc;
	}
	//Get method for Pool Location
	public String getPoolLocation() {
		return poolLocation;
	}
	//redefinition of getEntry method
	public String getEntry () {
		   String result = getName()+" swam " + getDistance() + " km in an " +getPoolLocation()+" pool in"
		             +getHour()+":"+getMin()+":"+ getSec() + " on "
		             +getDay()+"/"+getMonth()+"/"+getYear()+"\n";
		   return result;
		  }
}
