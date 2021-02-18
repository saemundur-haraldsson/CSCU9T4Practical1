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

    // look up the entry of a given day and month
    public void RemoveEntry (int d, int m, int y, String n) {
        ListIterator<Entry> iter = tr.listIterator();
        String result = "No entries found";
        while (iter.hasNext()) {
            Entry current = iter.next();
            if (current.getDay()==d && current.getMonth()==m && current.getYear()==y && current.getName().equals(n))
                tr.remove(current.getEntry());
        }
    } // lookupEntry

    // look up the entry of a given day and month
    public LinkedList<String> lookUpEntries (int d, int m, int y) {
        ListIterator<Entry> iter = tr.listIterator();
        LinkedList<String> result = new LinkedList();
//        result.set(i, "No entries found");
        int i = 0;
        while (iter.hasNext()) {
            Entry current = iter.next();
            if (current.getDay()==d && current.getMonth()==m && current.getYear()==y)
                result.set(i, current.getEntry());
            else
                result.set(i, "No entries found.");
            i++;
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

   //public void RemoveEntry(Entry e) {tr.remove(e); }
   //public int RemoveEntry(String name, int d, int m, int y) {
   //        ListIterator<Entry> iter = tr.listIterator();
   //        LinkedList<String> result = new LinkedList();
//        result.set(i, "No entries found");
   //        int i = 0;
   //        while (iter.hasNext()) {
   //            Entry current = iter.next();
   //            if (current.getDay()==d && current.getMonth()==m && current.getYear()==y)
   //                result.set(i, current.getEntry());
   //            else
   //                result.set(i, "No entries found.");
   //            i++;
   //        }
   //        return result;
   //}

} // TrainingRecord