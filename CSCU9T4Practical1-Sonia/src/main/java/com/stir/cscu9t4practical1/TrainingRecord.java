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
	   ListIterator<Entry> iter = tr.listIterator();
	   String result = "";
	   
	 //this loops through the list of entries to check if the date matches the input 
	  //it will return a single string with all the entries on the given date
	   while (iter.hasNext()) {
		   Entry current = iter.next();
		   
		   //if the entry matches, it adds the entries description to the variable result
		   if (current.getDay() == d && current.getMonth() ==m && current.getYear() ==y) {
			   result += current.getEntry() + "\n";
		   }
	   }
	   //if there are no entries for a given date, a message is given 
	   if (result.equals("")) {
		   result = "No entries found";
	   }
	   
	   return result;
   }
   
   // Count the number of entries
   public int getNumberOfEntries(){
       return tr.size();
   }
   // Clear all entries
   public void clearAllEntries(){
       tr.clear();
   }
   
} // TrainingRecord