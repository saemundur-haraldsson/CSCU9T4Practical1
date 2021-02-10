package com.stir.cscu9t4practical1;

import javax.print.attribute.standard.PresentationDirection;

public class SprintEntry extends Entry
{
    private int repetitions;
    private int recovery;

    public SprintEntry(String n, int d, int m, int y, int h, int min, int s, float dist, int repetitions, int recovery)
    {
        super (n, d, m, y, h, min, s, dist);

        this.repetitions = repetitions;
        this.recovery = recovery;
    } //Constructor

    public int getRepetitions ()
    {
        return repetitions;
    } //getRepetitions

    public int getRecovery ()
    {
        return recovery;
    } //getRecovery


}
