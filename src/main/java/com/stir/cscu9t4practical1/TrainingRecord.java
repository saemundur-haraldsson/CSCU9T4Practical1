// An implementation of a Training Record as an ArrayList
package com.stir.cscu9t4practical1;




import java.util.*;


public class TrainingRecord {
    private List<Entry> tr;
    
    public TrainingRecord() {
        tr = new ArrayList<Entry>();
    } //constructor
    
    // add a record to the list
   public String addEntry(EnumExerciseType typeOfExerciseSelected, String name, String day, String month, String year, String hour, String minute, String second, String distance, String cyclingSurface, String cyclingRouteDifficulty, String sprintingRepetitions, String sprintingRecovery, String swimmingLocation)
   {
       String result;
       boolean isThisADuplicateEntry = false;
       InputChecker inputSanitiser = new InputChecker(typeOfExerciseSelected);
       result = inputSanitiser.

       Entry newEntry = createAppropriateEntryType(typeOfExerciseSelected, name, day, month, year, hour, minute, second, distance, cyclingSurface, cyclingRouteDifficulty, sprintingRepetitions, sprintingRecovery, swimmingLocation);

       String uniqueIdentifierOfNewEntry = newEntry.getUniqueIdentifier();

       for (Entry e : this.tr)  //Go through all existing entries and check if they match the new entry.
       {
           if (e.getUniqueIdentifier().equals(uniqueIdentifierOfNewEntry))
           {
               isThisADuplicateEntry = true;
           }
       }

       if (isThisADuplicateEntry)
       {
           result = "Duplicate entries are not permitted.\n";
       }
       else
       {
           tr.add(newEntry);
           result = "Record added\n";
       }

       return result;
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

   private Entry createAppropriateEntryType(EnumExerciseType typeOfExerciseSelected, String name, int day, int month, int year, int hour, int minute, int second, float distance, String cyclingSurface, String cyclingRouteDifficulty, int sprintingRepetitions, int sprintingRecovery, String swimmingLocation)
    {
        Entry entryToReturn;

        if (typeOfExerciseSelected.equals(EnumExerciseType.Cycling))
        {
            entryToReturn = new CycleEntry(name, day, month, year, hour, minute, second, distance, cyclingSurface, cyclingRouteDifficulty);
        }
        else if (typeOfExerciseSelected.equals(EnumExerciseType.Running))
        {
            entryToReturn = new SprintEntry(name, day, month, year, hour, minute, second, distance, sprintingRepetitions, sprintingRecovery);
        }
        else    //Not checking against EnumExerciseType.Swimming because of compiler error regards possibly not assigning a value to entryToReturn
        {
            entryToReturn = new SwimEntry(name, day, month, year, hour, minute, second, distance, swimmingLocation);
        }

        return entryToReturn;
    }



} // TrainingRecord