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
       String result = "";
       
       int length = tr.size();
       for (int i = 0; i < length; i++ ){
           Entry current = iter.next();
           if (current.getDay()==d && current.getMonth()==m && current.getYear()==y){
               result = (result + " " + current.getEntry());
           }
           }
       if(result.isEmpty()){
           result = "No entries found";
       }
       
   
   
       return result;
   } // lookupEntry
   public String findAllByDate (int d, int m, int y) {
       ListIterator<Entry> iter = tr.listIterator();
       String result = "";
       
       int length = tr.size();
       for (int i = 0; i < length; i++ ){
           Entry current = iter.next();
           if (current.getDay()==d && current.getMonth()==m && current.getYear()==y){
               String output = ("\n Name: " + current.getName() + " Hours: " + current.getHour() +  " Mins: " + current.getMin() + " Secs: " + current.getSec());
               result = (result + " " + output);
           }
           }
       if(result.isEmpty()){
           result = "No entries found";
       }
       
   
   
       return result;
   }
   public String removeEntry(int d, int m, int y, String n){
       ListIterator<Entry> iter = tr.listIterator();
       
       String result = "Not found";
       int length = tr.size();
       for (int i = 0; i < length; i++ ){
           Entry current = iter.next();
           if (current.getName().equals(n) && current.getDay()==d && current.getMonth()==m && current.getYear()==y);{
               iter.remove();
               result = "Removed";
           }
           }
       return result;
       
       
   }
   public boolean duplicate(int d, int m, int y, String n){
       ListIterator<Entry> iter = tr.listIterator();
       
       boolean a = false;
       int length = tr.size();
       for (int i = 0; i < length; i++ ){
           Entry current = iter.next();
           if (current.getName().equals(n) && current.getDay()==d && current.getMonth()==m && current.getYear()==y);{
               
               a = true;
           }
           }
       return a;
       
       
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