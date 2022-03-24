// An implementation of a Training Record as an ArrayList
package com.stir.cscu9t4practical1;


import java.util.*;
import java.util.regex.Pattern;


public class TrainingRecord {
    
    private final List<Entry> tr;

    /**
     * Constructor for TrainingRecord; initialises the list of entries.
     */
    public TrainingRecord() {
        tr = new ArrayList<>();
    }

    /**
     * Helper method to check if a given entry matches a given day, month and year, and optionally, a name if the name
     * passed is not an empty string.
     *
     * @param e The entry to check
     * @param n The name to check against; can be passed as empty string if only the date should be checked
     * @param d The day to check against
     * @param m The month to check against
     * @param y The year to check against
     *
     * @return Whether the given entry matches the given parameters.
     */
    private boolean matchEntries(Entry e, String n, int d, int m, int y) {
        return (
                n.equals("") ?
                    e.getDay() == d && e.getMonth() == m && e.getYear() == y :
                    e.getName().equals(n) && e.getDay() == d && e.getMonth() == m && e.getYear() == y
        );
    }

    /**
     * Adds a new entry to the list if it is not a duplicate.
     *
     * @param e The entry to be added
     *
     * @return True if the entry was added, false if it was a duplicate.
     */
    public boolean addEntry(Entry e) {
        // a loop would generally be more efficient here, but the instructions said to use iteration whenever
        // possible, so I've used a listIterator instead
        ListIterator<Entry> iter = tr.listIterator();
        boolean result = true;
        while (iter.hasNext()) {
            Entry current = iter.next();
            // if the name and date match those of an entry already in the record, reject the new entry
            if (matchEntries(current, e.getName(), e.getDay(), e.getMonth(), e.getYear())) {
                result = false;
            }
        }
        if (result) tr.add(e);
        return result;
    }

    /**
     * Finds an entry by associated name, day, month and year, and removes it from the list.
     *
     * @param n The name associated with the entry to be removed.
     * @param d The day associated with the entry to be removed.
     * @param m The month associated with the entry to be removed.
     * @param y The year associated with the entry to be removed.
     *
     * @return True if the entry was removed, false if not for any reason.
     */
    public boolean removeEntry(String n, int d, int m, int y) {
        // a for loop would generally be more efficient here, but the instructions said to use iteration
        // when possible, so I've used a listIterator instead
        ListIterator<Entry> iter = tr.listIterator();
        Entry toRemove = null;
        while (iter.hasNext()) {
            Entry current = iter.next();
            // if we find the entry, save it for removal and exit the loop
            if (matchEntries(current, n, d, m, y)) {
                toRemove = current;
                break;
            }
        }
        // removal must be done outside the while-loop to avoid a concurrent modification error
        if (toRemove != null) {
            return tr.remove(toRemove);
        }
        return false;
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
        // a for loop would generally be more efficient here, but the instructions said to use iteration
        // when possible, so I've used a listIterator instead
        ListIterator<Entry> iter = tr.listIterator();
        String result = "No entries found.";
        while (iter.hasNext()) {
            Entry current = iter.next();
            if (matchEntries(current, "", d, m, y)) {
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
        // a for loop would generally be more efficient here, but the instructions said to use iteration
        // when possible, so I've used a listIterator instead
        ListIterator<Entry> iter = tr.listIterator();
        StringBuilder builder = new StringBuilder();
        String result = "Could not find any entries for this date.";
        while (iter.hasNext()) {
            Entry current = iter.next();
            if (matchEntries(current, "", d, m, y)) {
                builder.append(current.getEntry());
            }
        }
        // if we've found any entries, use them as the result
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
        // a for loop would generally be more efficient here, but the instructions said to use iteration
        // when possible, so I've used a listIterator instead
        ListIterator<Entry> iter = tr.listIterator();
        StringBuilder builder = new StringBuilder();
        String result = "Could not find any entries for this name.";
        Pattern p = Pattern.compile(name, Pattern.CASE_INSENSITIVE);
        while (iter.hasNext()) {
            Entry current = iter.next();
            // check against the compiled regex
            if (p.matcher(current.getName()).find()) {
                builder.append(current.getEntry());
            }
        }
        // if we've found any entries, use them as the result
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