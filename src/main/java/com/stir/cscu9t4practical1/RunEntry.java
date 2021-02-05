// This class holds information about a single training session
package com.stir.cscu9t4practical1;

import java.util.Calendar;

public class RunEntry extends Entry
{  
  public RunEntry()
  {
	  
  }
  
  public RunEntry (String n, int d, int m, int y, int h, int min, int s, float dist)
  {
      name = n;
      Calendar inst = Calendar.getInstance();
      inst.set(y,m-1,d,h,min,s);
      dateAndTime = inst;
      distance = dist; //km
  } //constructor
   
} // Entry