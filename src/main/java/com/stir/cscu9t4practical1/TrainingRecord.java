//import necessary packages
package com.stir.cscu9t4practical1;

import java.util.*;


public class TrainingRecord {
    private List<Entry> tr;
    
    public TrainingRecord() {
        tr = new ArrayList<Entry>();
    } //constructor
    
    // add a record to the list
   public void addEntry(Entry e){
       tr.add(e);    
   } // addClass
   
   // look up the entry of a given day and month
   public String lookupEntry (int d, int m, int y) {
       ListIterator<Entry> iter = tr.listIterator();
       String result = "No entries found";
       while (iter.hasNext()) {
          Entry current = iter.next();
          if (current.getDay() == d && current.getMonth() == m && current.getYear() == y) 
             result = current.getEntry();
            }
       return result;
   } // lookupEntry
   
   // Count the number of entries
   public int getNumberOfEntries(){
       return tr.size();
   }
   
   // Clear all entries
   public void clearAllEntries(){
       tr.clear();
   }
   
   // Calculate the total distance run for a given athlete
   public double getTotalDistanceRun(String name) {
       double totalDistance = 0.0;
       for (Entry e : tr) {
           if (e instanceof RunEntry && e.getName().equals(name)) {
               totalDistance += ((RunEntry) e).getDistance();
           }
       }
       return totalDistance;
   }
   
   // Calculate the total time taken to run for a given athlete
   public int getTotalTimeRun(String name) {
       int totalTime = 0;
       for (Entry e : tr) {
           if (e instanceof RunEntry && e.getName().equals(name)) {
               totalTime += ((RunEntry) e).getDuration();
           }
       }
       return totalTime;
   }
   
} // TrainingRecord
