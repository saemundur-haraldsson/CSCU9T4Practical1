// An implementation of a Training Record as an ArrayList
package com.stir.cscu9t4practical1;


import java.util.*;


public class TrainingRecord {
    private List<Entry> tr;

    /*
     * Constructor for TrainingRecord; initialises the list of entries.
     */
    public TrainingRecord() {
        tr = new ArrayList<Entry>();
    }

    /*
     * Adds a new entry to the list.
     */
    public void addEntry(Entry e) {
        tr.add(e);
    }

    /*
     * Looks up and returns the final entry on a given day, month and year.
     */
    public String lookupEntry(int d, int m, int y) {
        ListIterator<Entry> iter = tr.listIterator();
        String result = "No entries found.";
        while (iter.hasNext()) {
            Entry current = iter.next();
            if (current.getDay() == d && current.getMonth() == m && current.getYear() == y) {
                result = current.getEntry();
            }
        }
        return result;
    }

    /*
     * Looks up and returns the all entries on a given day, month and year.
     */
    public String findAllByDate(int d, int m, int y) {
        ListIterator<Entry> iter = tr.listIterator();
        StringBuilder builder = new StringBuilder();
        String result = "No entries found.";
        while (iter.hasNext()) {
            Entry current = iter.next();
            if (current.getDay() == d && current.getMonth() == m && current.getYear() == y) {
                builder.append(current.getEntry());
            }
        }
        if (builder.length() > 0) {
            result = builder.toString();
        }
        return result;
    }

    /*
     * Counts and returns the number of entries.
     */
    public int getNumberOfEntries() {
        return tr.size();
    }

    /*
     * Clears all entries.
     */
    public void clearAllEntries() {
        tr.clear();
    }
}