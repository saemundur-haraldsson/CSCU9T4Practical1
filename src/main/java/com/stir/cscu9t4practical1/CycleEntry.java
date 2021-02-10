package com.stir.cscu9t4practical1;

public class CycleEntry extends Entry
{
    private String surfaceType;
    private String routeDifficulty;

    public CycleEntry(String n, int d, int m, int y, int h, int min, int s, float dist, String surfaceType, String routeDifficulty)
    {
        super (n, d, m, y, h, min, s, dist);

        this.routeDifficulty = routeDifficulty;
        this.surfaceType = surfaceType;
    }   //Constructor

    public String getTerrain ()
    {
        return surfaceType;
    } //getTerrain

    public String getRouteDifficulty () { return routeDifficulty; } //getRouteDifficulty
}
