/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stir.cscu9t4practical1;

import java.util.Calendar;

/**
 *
 * @author 44752
 */
public class SprintEntry extends Entry {
    private String name;
  private Calendar dateAndTime;
  private float distance;

      public SprintEntry (String n, int d, int m, int y, int h, int min, int s, float dist, int rep, int rec) {
    super(n, d, m, y, h, min, s, dist);
    recovery = rec;
    repetitions = rep;
    Calendar inst = Calendar.getInstance();
    inst.set(y,m-1,d,h,min,s);
    distance = dist;
    dateAndTime = inst;
    name = n;
  } //constructor
  @Override
  public String getName () {
    return name;
  } //getName
  @Override
  public int getDay () {
    return dateAndTime.get(Calendar.DATE);
  } //getDay
  @Override
  public int getMonth () {
    int month =  dateAndTime.get(Calendar.MONTH) + 1;
    return month;
  } //getMonth
  @Override
  public int getYear () {
    return dateAndTime.get(Calendar.YEAR);
  } //getYear
@Override
  public int getHour () {
    return dateAndTime.get(Calendar.HOUR);
  } //getHour
@Override
  public int getMin () {
    return dateAndTime.get(Calendar.MINUTE);
  } //getMin
@Override
  public int getSec () {
    return dateAndTime.get(Calendar.SECOND);
  } //getSec
@Override
  public float getDistance () {
    return distance;
  } //getYear
  @Override
  public int getRepetitions(){
      return this.repetitions;
  }
  @Override
  public int getRecovery(){
      return this.recovery;
  }
  
@Override
  public String getEntry () {
   String result = getName()+" sprinted " + getDistance() + " km in "
             +getHour()+":"+getMin()+":"+ getSec() + " on "
             +getDay()+"/"+getMonth()+"/"+getYear()+" with " + getRecovery() + " minutes recovery \n";
   return result;
  } //getEntry 
    
}
