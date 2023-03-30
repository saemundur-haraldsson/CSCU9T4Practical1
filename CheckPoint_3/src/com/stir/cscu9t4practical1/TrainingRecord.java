package com.stir.cscu9t4practical1;

import java.util.*;

public class TrainingRecord {
    private List<Entry> tr;

    public TrainingRecord() {
        tr = new ArrayList<Entry>();
    } // constructor

    // add a record to the list
    public void addEntry(Entry e) {
        tr.add(e);
    } // addEntry

    // look up the entry of a given day and month
    public String lookupEntry(int d, int m, int y) {
        List<Entry> matches = new ArrayList<>();
        for (Entry entry : tr) {
            if (entry.getDay() == d && entry.getMonth() == m && entry.getYear() == y) {
                matches.add(entry);
            }
        }
        if (matches.isEmpty()) {
            return "No entries found";
        } else {
            StringBuilder sb = new StringBuilder();
            for (Entry entry : matches) {
                sb.append(entry.getEntry()).append("\n");
            }
            return sb.toString();
        }
    } // lookupEntry

    // count the number of entries
    public int getNumberOfEntries() {
        return tr.size();
    }

    // clear all entries
    public void clearAllEntries() {
        tr.clear();
    }

    // get all entries on a given date
    public String getAllEntriesOnDate(int d, int m, int y) {
        List<Entry> matches = new ArrayList<>();
        for (Entry entry : tr) {
            if (entry.getDay() == d && entry.getMonth() == m && entry.getYear() == y) {
                matches.add(entry);
            }
        }
        if (matches.isEmpty()) {
            return "No entries found";
        } else {
            StringBuilder sb = new StringBuilder();
            for (Entry entry : matches) {
                sb.append(entry.getEntry()).append("\n");
            }
            return sb.toString();
        }
    } // getAllEntriesOnDate
    
    public void remove(String s, int d, int m, int y) {
        ListIterator<Entry> iter = tr.listIterator();
        while (iter.hasNext()) {
            Entry current = iter.next();
            if (current.getName().equals(s) && current.getDay() == d && current.getMonth() == m && current.getYear() == y) {
                System.out.println("Removing one record");
                iter.remove();
            }
        }
    }
 // TrainingRecord
}