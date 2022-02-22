// An implementation of a Training Record as an ArrayList
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
          if (current.getDay()==d && current.getMonth()==m && current.getYear()==y) 
             result = current.getEntry();
            }
       return result;
   } // lookupEntry returns the last entry with the given date

    // look up all the entries of a given day and month
    public String lookupAllEntries (int d, int m, int y) {
        ListIterator<Entry> itr = tr.listIterator();
        //List<String> results = new ArrayList<>();
        String result = "";
        while (itr.hasNext()) {
            Entry current = itr.next();
            while (current.getDay()==d && current.getMonth()==m && current.getYear()==y){
                result = result + current.getEntry();
                //results.add(current.getEntry());
                //itr.next();
            }
        }
        if (result.equals("")){
            result = "There are no stored entries for this date";
        }
        return result;
    } // lookupAllEntries

    //remove an element
    public String removeElement(String n, int d, int m, int y){
        ListIterator<Entry> itr = tr.listIterator();
        String result = "Specified entry has been removed";
        boolean entryPresent = false;
        while (itr.hasNext()){
            Entry current = itr.next();
            if(current.getName()==n && current.getDay()==d && current.getMonth()==m
                    && current.getYear()==y) {
                entryPresent = true;
                itr.remove();
            }
        }
        if(!entryPresent){
            return "Specified entry has not been found\n";
        }
    return result;
    }//remove element

   // Count the number of entries
   public int getNumberOfEntries(){
       return tr.size();
   }
   // Clear all entries
   public void clearAllEntries(){
       tr.clear();
   }
   
} // TrainingRecord