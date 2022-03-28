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
   
   public String lookupAllEntries (int d, int m, int y) {
	   ListIterator<Entry> iter = tr.listIterator(); // sets up an iterator for the entries
       String result = "";
       
       if (tr.isEmpty()) {
    	   result = "No entries found"; // if there are no entries in the list
       }
       
       while (iter.hasNext()) { // while the list has elements
    	   Entry current = iter.next();
    	   if (current.getDay()==d && current.getMonth()==m && current.getYear()==y) // if the entry matches the date specified by the user
             result = result + current.getEntry(); // creates a string of all matching records
       }
	   return result;
   }
   
   public void removeEntry (Entry entry) {
	   tr.remove(entry); // removes the entry from the record
   }
   
   // Count the number of entries
   public int getNumberOfEntries(){
       return tr.size();
   }
   // Clear all entries
   public void clearAllEntries(){
       tr.clear();
   }
   public List<Entry> getTrainingRecord() { // getter for the list of training records
	   return tr;
   }
   
} // TrainingRecord