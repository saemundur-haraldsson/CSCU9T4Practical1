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
public class CycleEntry extends Entry {
      private String name;
  private Calendar dateAndTime;
  private float distance;

  public CycleEntry (String n, int d, int m, int y, int h, int min, int s, float dist, String ter, String temp) {
    super(n, d, m, y, h, min, s,dist);
    Calendar inst = Calendar.getInstance();
    inst.set(y,m-1,d,h,min,s);
    distance = dist;
    dateAndTime = inst;
    name = n;
    
            
    tempo = temp;
    terrain = ter;
  } //constructor
  @Override
  public String getName () {
    return this.name;
  } //getName
  @Override
  public int getDay () {
    return this.dateAndTime.get(Calendar.DATE);
  } //getDay
  @Override
  public int getMonth () {
    int month =  this.dateAndTime.get(Calendar.MONTH) + 1;
    return month;
  } //getMonth
  @Override
  public int getYear () {
    return this.dateAndTime.get(Calendar.YEAR);
  } //getYear
@Override
  public int getHour () {
    return this.dateAndTime.get(Calendar.HOUR);
  } //getHour
@Override
  public int getMin () {
    return this.dateAndTime.get(Calendar.MINUTE);
  } //getMin
@Override
  public int getSec () {
    return this.dateAndTime.get(Calendar.SECOND);
  } //getSec
@Override
  public float getDistance () {
    return this.distance;
  } //getYear
 @Override
  public String getTerrain(){
      return this.terrain;
      }
    @Override
  public String getTempo(){
      return this.tempo;
      }

 
@Override
  public String getEntry () {
   String result = getName()+" cycled " + getDistance() + " km in "
             +getHour()+":"+getMin()+":"+ getSec() + " on "
             +getDay()+"/"+getMonth()+"/"+getYear()+" on "+getTerrain()+" at "+getTempo()+" tempo\n";
   return result;
  } //getEntry 
    
    
}
