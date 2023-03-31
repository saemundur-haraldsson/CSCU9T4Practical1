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
        while (iter.hasNext()) {
            Entry current = iter.next();
            if (current.getDay()==d && current.getMonth()==m && current.getYear()==y)
                result += current.getEntry();
        }
        return result;
    }
    public Boolean CheckIfEntryExists (int d, int m, int y,String name) {
        ListIterator<Entry> iter = tr.listIterator();
        Boolean result =  false;
        while (iter.hasNext()) {
            Entry current = iter.next();
            if (current.getDay()==d && current.getMonth()==m && current.getYear()==y && current.getName().equalsIgnoreCase(name))
                result = true;
        }
        return result;
    }
    public String lookupAllEntriesByName(String searchTerm){
        ListIterator<Entry> iter = tr.listIterator();
        String result = "";
        while (iter.hasNext()) {
            Entry current = iter.next();
            if (current.name.equalsIgnoreCase(searchTerm)){
                result += current.getEntry();
            }
        }
        return result;
    }
    public String removeAllEntries (int d, int m, int y,String n) {
        ListIterator<Entry> iter = tr.listIterator();
        String result = "No entries under that name and date";
        while (iter.hasNext()) {
            Entry current = iter.next();
            if (current.getDay()==d && current.getMonth()==m && current.getYear()==y && current.getName().equalsIgnoreCase(n))
                result = "Entry: "+n+ " on " +d+"/"+m+"/"+y+" was removed successfully";
                iter.remove();
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