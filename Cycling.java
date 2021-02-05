
public class Cycling extends Entry{
	private String terrain;
	private String tempo;
    
	//overriding Entry method
	public Cycling(String n, int d, int m, int y, int h, int min, int s, float dist,String terr,String temp) {
		super(n, d, m, y, h, min, s, dist);
		terrain = terr;
		tempo = temp;
	}
	//Get method for terrain
	public String getTerrain() {
		return terrain;
	}
	//Get method for tempo
	public String getTempo() {
		return tempo;
	}
	//overriding getEntry method
	public String getEntry () {
		   String result = getName()+" cycled " + getDistance() + " km on " +getTerrain() + " terrain at " + getTempo()+" tempo in"
		             +getHour()+":"+getMin()+":"+ getSec() + " on "
		             +getDay()+"/"+getMonth()+"/"+getYear()+"\n";
		   return result;
		  }
}
