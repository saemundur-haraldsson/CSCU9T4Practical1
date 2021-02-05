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
   public String lookupEntry (int d, int m, int y)
   {
       ListIterator<Entry> iter = tr.listIterator();
       String result = "No entries found.";

       while (iter.hasNext())
       {
           Entry current = iter.next();
           if (current.getDay() == d && current.getMonth() == m && current.getYear() == y)     //Check if entry matches search terms
           {
               result = current.getEntry();  //Add first found matching entry
           }
       }
       return result;
   } // lookupEntry

    public String findAllByDate (int day, int month, int year)
    {
        ListIterator<Entry> iter = tr.listIterator();
        String stringToReturnWhenNoEntriesFound = "No entries found.";
        String result = stringToReturnWhenNoEntriesFound;

        while (iter.hasNext())
        {
            Entry current = iter.next();
            if (current.getDay()==day && current.getMonth()==month && current.getYear()==year)     //Check if entry matches search terms
            {
                if (result.equals(stringToReturnWhenNoEntriesFound))  //Check if no result has yet been found
                {
                    result = current.getEntry();  //Add first found matching entry
                }
                else
                {
                    result += ("\r" + current.getEntry());  //Add any subsequent matching entries
                }
            }
        }

        return result;
    } //findAllByDate
   
   // Count the number of entries
   public int getNumberOfEntries(){
       return tr.size();
   }
   // Clear all entries
   public void clearAllEntries(){
       tr.clear();
   }
   
} // TrainingRecord