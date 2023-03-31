// An implementation of a Training Record as an ArrayList
package com.stir.cscu9t4practical1;
import java.util.*;

public class TrainingRecord {
    private List<Entry> tr;

    public TrainingRecord() {
        tr = new ArrayList<Entry>();
    } //constructor

    // add a record to the list
    public void addEntry(Entry e) {
        tr.add(e);
    } // addClass

    // look up the entry of a given day and month
    public String lookupEntry(int d, int m, int y) {
        ListIterator<Entry> iter = tr.listIterator();
        String Result = "NO ENTRIES FOUND YET";
        while (iter.hasNext()) {
            Entry current = iter.next();
            
            // For Swim Entry
            if (current.getClass() == SwimEntry.class) {
                if (current.getDay () == d && current.getMonth () == m && current.getYear () == y) {
                	Result = ((SwimEntry) current).getSwimEntry();
                    break;
                }
            }
            // For Sprint Entry
            if (current.getClass () == SprintEntry.class) {
                if (current.getDay () == d && current.getMonth () == m && current.getYear () == y) {
                	Result = ((SprintEntry) current).getSprintEntry();
                    break;
                }
            }
            // For CycleEntry
            if (current.getClass () == CycleEntry.class) {
                if (current.getDay () == d && current.getMonth () == m && current.getYear () == y) {
                	Result = ((CycleEntry) current).getCycleEntry();
                }
            }
        }
        return Result;
    } // lookupEntry

    public String getAllEntriesOnDate(int d, int m, int y) {
        ListIterator<Entry> iter = tr.listIterator();
        String Result = "";
        if (!iter.hasNext()) {
        	Result = "NO ENTRIES FOUND YET";
        }
        while (iter.hasNext()) {
            Entry current = iter.next();
            System.out.println(current);
            if (current.getDay () == d && current.getMonth () == m && current.getYear () == y) {
            	
                if (current.getClass () == Entry.class) {
                	Result = Result + current.getEntry();
                }
                
                if (current.getClass () == SwimEntry.class) {
                	Result = Result + ((SwimEntry) current).getSwimEntry ();
                }
                
                if (current.getClass () == SprintEntry.class) {
                	Result = Result + ((SprintEntry) current).getSprintEntry ();
                }
                
                if (current.getClass () == CycleEntry.class) {
                	Result = Result + ((CycleEntry) current).getCycleEntry ();
                }
                
            }
            else 
            {
            	Result = "NO ENTRIES OR RESULT FOUND YET";
            }
        }
        return Result;
    }

    public void Remove (String s, int d, int m, int y) {
        ListIterator<Entry> iter = tr.listIterator();
        while (iter.hasNext()) {
            Entry current = iter.next ();
            if (current.getName ().equals(s) && current.getDay () == d && current.getMonth () 
            		== m && current.getYear () == y) {
                System.out.println("REMOVING ONE RECORD");
                iter.remove ();
            }
        }
    }

    // Count the number of entries
    public int getNumberOfEntries() {
        return tr.size();
    }

    // Clear all entries
    public void clearAllEntries() {
        tr.clear();
    }

} // TrainingRecord