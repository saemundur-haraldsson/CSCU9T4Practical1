import java.util.*;


public class TrainingRecord {
    private List<Entry> tr;
    
    public TrainingRecord() {
        tr = new ArrayList<Entry>();
    } //constructor
    
    // add a record to the list
   public void addEntry(Entry e){
       tr.add(e);    
   } 
   // addClass
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
   } 
   // lookupEntry
   public Entry lookupEntry (String n,int d, int m, int y) {
       ListIterator<Entry> iter = tr.listIterator();
       while (iter.hasNext()) {
          Entry current = iter.next();
          if (current.getName().equals(n)&& current.getDay()==d && current.getMonth()==m && current.getYear()==y) 
             return current;
            }
       return null;
   } // lookupEntry
   
   //Checks if entry already exists
   public boolean ExistingEntry(Entry exists) {
	   ListIterator<Entry> iter = tr.listIterator();
	   boolean exist = false;
	   while(iter.hasNext()) {
		   Entry current = iter.next();
		   if(current.getName().equals(exists.getName())&& current.getDay()==exists.getDay() && 
				   current.getMonth()==exists.getMonth() && current.getYear()==exists.getYear()&&current.getClass()==exists.getClass()) {
			   exist = true;
			   break;
		   }
	   }
	   return exist;
   } 
   //removes entry
   public boolean removeEntry(Entry e) {
	   for(int i=0; i < tr.size(); i++) {
		   if (tr.get(i)==e) {
			   tr.remove(i);
			   return true;
		   }
	   }
	   return false;
   } 
   // Looks up all entries
   public String lookUpAllEntries(int d,int m,int y) {
	   ListIterator<Entry> iter = tr.listIterator();
	   String result = "No entries found";
	   while(iter.hasNext()) {
		   Entry current = iter.next();
		   if(current.getDay()==d && current.getMonth()==m && current.getYear()==y) {
			   if(result.equals("No entries found")) {
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
   
} // TrainingRecord