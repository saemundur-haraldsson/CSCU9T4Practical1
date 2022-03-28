// An implementation of a Training Record as an ArrayList
package com.stir.cscu9t4practical1;




import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class TrainingRecord {
    private List<Entry> tr;
    
    public TrainingRecord() {
        tr = new ArrayList<Entry>();
    } //constructor
    
    // add a record to the list
   public void addEntry(Entry e){
       String message = checkForDuplicates(e.getName(),e.getDay(),e.getMonth(),e.getYear());
       if(message.contains("No entries found...")){
        tr.add(e);}
   } // addClass

    // deletes entry using name, day,month,year
    public String removeEntry(String n, int d, int m, int y){
ListIterator<Entry> iter = tr.listIterator();
String result = "No Entries found to delete...";
while(iter.hasNext()){
    Entry current = iter.next();
    if(current.getName().equals(n) && current.getDay()==d && current.getMonth()==m && current.getYear()==y){
iter.remove();
result = "Deletion Successful.";
    }
}
return result;
    } //removeClass


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

    //Find entries from the smae day,month,year
    public String lookUpAllEntries(int d, int m, int y){
        ListIterator<Entry> iter = tr.listIterator();
        String result = "No entries found...";
        while(iter.hasNext()){
            Entry current = iter.next();
            if(current.getDay()==d && current.getMonth()==m && current.getYear()==y){
                if(result.equals("No entries found...")){
                    result = "";
                }
                result += current.getEntry();
            }
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

   //find entries using a name
   public String findAllEntriesByName(String n){
        ListIterator<Entry> iter = tr.listIterator();
        String result = "No Entries found...";
        while(iter.hasNext()){
            Entry current = iter.next();
            if(current.getName().toLowerCase(Locale.ROOT).matches(".*"+n.toLowerCase(Locale.ROOT)+".*")){
            if(result.equals("No Entries found...")){
                result = "";
            }
            result += current.getEntry();
            }
        }
        //returns all the records if an empty string is passed
        if(n.equals("")){
            return "\n"+ "Empty String input, this is a list of all records available:\n" + "\n" + result;
        }
        return result;
   }

   //Checks for any existing record using name, day, month and year
   public String checkForDuplicates(String name, int day, int month, int year){
        ListIterator<Entry> iter = tr.listIterator();
        String result = "No Entries found...";
        while(iter.hasNext()){
            Entry current = iter.next();
            if(current.getName().equals(name) && current.getDay()==day && current.getMonth()==month && current.getYear()==year){
                if(result.equals("No Entries found...")){
                    result = "";
                }
                result += current.getEntry();
            }
        }
        return result;
   }

    //calculates weekly distance for a name given a certain date
    public String getWeeklyDistance(String name, int day, int month, int year) throws ParseException {
       DateFormat d = new SimpleDateFormat("dd/MM/yyyy");
       d.setLenient(false);
       Date date = d.parse(day + "/" + month + "/" + year);
       long millis = date.getTime();
       final long millisDay = 1000 * 60 * 60 * 24;

       Collections.sort(tr, new Comparator<Entry>() {
           @Override
           public int compare(Entry o1, Entry o2) {
               try {
                   Date compareDate1 = d.parse(o1.getDate());
                   Date compareDate2 = d.parse(o2.getDate());
                   if (compareDate1.before(compareDate2)) {
                       return -1;
                   }
                   if (compareDate1.after(compareDate2)) {
                       return 1;
                   }
                   return 0;
               } catch (ParseException e) {
                   e.printStackTrace();
                   return 0;
               }

           }
       });
       ListIterator<Entry> iter = tr.listIterator();
       String result = "No Entries found...";
       double sum = 0;
       int countDay = 0;

       while(iter.hasNext()){
           Entry current = iter.next();
           long currentMillis = d.parse(current.getDate()).getTime();
           if(current.getName().matches(".*"+ name + ".*") && current.getDay() == day+(countDay) && current.getMonth() == month && current.getYear() == year){
               if((currentMillis - millis) < millisDay * 7){
                   countDay++;
                   sum += current.getDistance();
                   result = name + " covered a total distance of "+ sum + "km in a week. \nStarting on " + date;
               }
           }
       }
       return result;
   }
   
} // TrainingRecord