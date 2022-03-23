// An implementation of a Training Record as an ArrayList
package com.stir.cscu9t4practical1;


import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class TrainingRecord {
    
    private List<Entry> tr;

    /**
     * Constructor for TrainingRecord; initialises the list of entries.
     */
    public TrainingRecord() {
        tr = new ArrayList<>();
    }

    /**
     * Adds a new entry to the list.
     *
     * @param e The entry to be added
     *
     * @return True if the entry was added, false if it was a duplicate.
     */
    public boolean addEntry(Entry e) {
        // This looping is necessary as contains() returns false even if the object is already in
        // the list; apparently something to do with equals() is borked for complex objects
        for (Entry i : tr) {
            if (i.getEntry().equals(e.getEntry())) {
                return false;
            }
        }
        return tr.add(e);
    }

    /**
     * Looks up and returns the final entry on a given day, month and year.
     *
     * @param d The day of the entry.
     * @param m The month of the entry.
     * @param y The year of the entry.
     *
     * @return A text summary of the details of the entry.
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

    /**
     * Looks up and returns the all entries on a given day, month and year.
     *
     * @param d The day to search for.
     * @param m The month to search for.
     * @param y The month to search for.
     *
     * @return A string containing new-line-separated summaries of all entries found that match the date.
     */
    public String lookupEntries(int d, int m, int y) {
        ListIterator<Entry> iter = tr.listIterator();
        StringBuilder builder = new StringBuilder();
        String result = "Could not find any entries for this date.";
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

    /**
     * Looks up and returns the all entries matching a given name. The search is case-insensitive and will return a
     * match if the given name is anywhere in the String returned by the entry's getName().
     *
     * @param name The name to search for.
     *
     * @return A string containing new-line-separated summaries of all entries found that match the name.
     */
    public String lookupByName(String name) {
        ListIterator<Entry> iter = tr.listIterator();
        StringBuilder builder = new StringBuilder();
        String result = "Could not find any entries for this name.";
        Pattern p = Pattern.compile(name, Pattern.CASE_INSENSITIVE);
        while (iter.hasNext()) {
            Entry current = iter.next();
            if (p.matcher(current.getName()).find()) {
                builder.append(current.getEntry());
            }
        }
        if (builder.length() > 0) {
            result = builder.toString();
        }
        return result;
    }

    /**
     * Counts and returns the number of entries.
     *
     * @return The number of entries.
     */
    public int getNumberOfEntries() {
        return tr.size();
    }

    /**
     * Clears all entries.
     */
    public void clearAllEntries() {
        tr.clear();
    }
}