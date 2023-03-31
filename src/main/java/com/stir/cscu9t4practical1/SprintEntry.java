package com.stir.cscu9t4practical1;

public class SprintEntry extends Entry{


    private int repetitions;


    private int recoveryIntervals;
   public SprintEntry(String n, int d, int m, int y, int h, int min, int s, float dist,int repetitions,int recoveryIntervals){
       super(n,d,m,y,h,min,s,dist);
       this.repetitions = repetitions;
       this.recoveryIntervals = recoveryIntervals;
   }public int getRepetitions() {
        return repetitions;
    }

    public int getRecovery() {
        return recoveryIntervals;
    }


    public String getEntry(){
        String result = getName()+ " Sprinted " + getRepetitions() +" repetitions of: " +
                getDistance()+ " km in With breaks of "+ getRecovery() +" mins in between "
                +getHour()+":"+getMin()+":"+ getSec() + " on "
                +getDay()+"/"+getMonth()+"/"+getYear()+"\n";
        return result;
    }
}
