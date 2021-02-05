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
   } // lookupEntry

    // look up all the entries of a given day and month
    public String lookupAllEntries (int d, int m, int y) {
        ListIterator<Entry> iter = tr.listIterator();
        List<String> results = new LinkedList<>();
        String result = "No entries found";
        while (iter.hasNext()) {
            Entry current = iter.next();
            if (current.getDay()==d && current.getMonth()==m && current.getYear()==y)
                //result = current.getEntry();
                results.add(current.getEntry());
                current = iter.next();
        }
        return results.toString();
    } // lookupAllEntries

/*    //remove an element
    public void removeElement(String n, int d, int m, int y){
    ListIterator<Entry> iter = tr.listIterator();
    while (iter.hasNext()){
        Entry current = iter.hasNext();
        if(current.getName()==n && current.getDay()==d && current.getMonth()==m && current.getYear()==y){
            tr.remove(current);
        }
    }
    }//remove element
*/
   // Count the number of entries
   public int getNumberOfEntries(){
       return tr.size();
   }
   // Clear all entries
   public void clearAllEntries(){
       tr.clear();
   }
   
} // TrainingRecord