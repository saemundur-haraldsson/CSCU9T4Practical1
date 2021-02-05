
public class Cycle extends Entry{
	private String terrain;
	private String tempo;
    
	//overloading of Entry method*
	public Cycle(String n, int d, int m, int y, int h, int min, int s, float dist,String tr,String tp) {
		super(n, d, m, y, h, min, s, dist);
		terrain = tr;
		tempo = tp;
	}
	//Get method to get Tr
	public String getTerrain() {
		return terrain;
	}
	//Get method to get Temp 
	public String getTempo() {
		return tempo;
	}
	//redefinition of getEntry method 
	public String getEntry () {
		   String result = getName()+" cycled " + getDistance() + " km on the " +getTerrain() + " terrain at tempo of " + getTempo()+" in"
		             +getHour()+":"+getMin()+":"+ getSec() + " on "
		             +getDay()+"/"+getMonth()+"/"+getYear()+"\n";
		   return result;
		  }
}
