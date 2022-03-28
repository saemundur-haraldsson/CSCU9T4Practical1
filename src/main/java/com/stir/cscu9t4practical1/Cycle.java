package com.stir.cscu9t4practical1;

public class Cycle extends Entry {

    private String terrain;
    private String tempo;

    public Cycle(String n, int d, int m, int y, int h, int min, int s, float dist, String ter, String temp) {
        super(n, d, m, y, h, min, s, dist);
        terrain = ter;
        tempo = temp;
    }

    // getter for terrain
    public String getTerrain() {
        return terrain;
    }

    // setter for terrain
    public void setTerrain(String terrain) {
        this.terrain = terrain;
    }

    // getter for tempo
    public String getTempo() {
        return tempo;
    }

    // getter for tempo
    public void setTempo(String tempo) {
        this.tempo = tempo;
    }

    @Override
    public String getEntry() {
        return getName() + "has cycled" + getDistance() + "km in" + getHour() + ":" + getMin() + ":" + getSec() + "on date: "
                + getDay() + "/" + getMonth() + "/" + getYear() + " on " + getTerrain() + " at " + getTempo() + "tempo\n";
    }
}
