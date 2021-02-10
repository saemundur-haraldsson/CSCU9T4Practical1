// An implementation of a Training Record as an ArrayList
package com.stir.cscu9t4practical1;

import java.util.*;

public class TrainingRecord {
    private List<Entry> tr;
    private InputChecker inputChecker;
    
    public TrainingRecord()
    {
        tr = new ArrayList<Entry>();
        inputChecker = new InputChecker();
    } //constructor
    
    // add a record to the list
   public String addEntry(EnumExerciseType typeOfExerciseSelected, String name, String day, String month, String year, String hour, String minute, String second, String distance, String cyclingSurface, String cyclingRouteDifficulty, String sprintingRepetitions, String sprintingRecovery, String swimmingLocation)
   {
       String result;
       boolean isThisADuplicateEntry = false;
       result = "";

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
   public String lookupEntry (String day, String month, String year)
   {
       String result = inputChecker.isDateInputSafe(day, month, year);

       if (result.equals(""))   //check input is clean - no errors from input checker
       {
           ListIterator<Entry> iter = tr.listIterator();
           result = "No entries found.";

           while (iter.hasNext())
           {
               Entry current = iter.next();
               if (current.getDay() == Integer.getInteger(day) && current.getMonth() == Integer.getInteger(month) && current.getYear() == Integer.getInteger(year))     //Check if entry matches search terms
               {
                   result = current.getEntry();  //Add first found matching entry
               }
           }
       }

       return result;
   } // lookupEntry

    public String findAllByDate (String day, String month, String year)
    {
        String stringToReturnWhenNoEntriesFound = "No entries found.";
        String result = inputChecker.isDateInputSafe(day, month, year);

        if (result.equals(""))   //check input is clean - no errors from input checker
        {
            ListIterator<Entry> iter = tr.listIterator();
            result = stringToReturnWhenNoEntriesFound;

            while (iter.hasNext())
            {
                Entry current = iter.next();
                if (current.getDay()==Integer.getInteger(day) && current.getMonth()==Integer.getInteger(month) && current.getYear()==Integer.getInteger(year))     //Check if entry matches search terms
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

   private Entry createAppropriateEntryType(EnumExerciseType typeOfExerciseSelected, String name, String day, String month, String year, String hour, String minute, String second, String distance, String cyclingSurface, String cyclingRouteDifficulty, String sprintingRepetitions, String sprintingRecovery, String swimmingLocation)
    {
        Entry entryToReturn;

        if (typeOfExerciseSelected.equals(EnumExerciseType.Cycling))
        {
            entryToReturn = new CycleEntry(name, Integer.parseInt(day), Integer.parseInt(month), Integer.parseInt(year), Integer.parseInt(hour), Integer.parseInt(minute), Integer.parseInt(second), Float.parseFloat(distance), cyclingSurface, cyclingRouteDifficulty);
        }
        else if (typeOfExerciseSelected.equals(EnumExerciseType.Running))
        {
            entryToReturn = new SprintEntry(name, Integer.parseInt(day), Integer.parseInt(month), Integer.parseInt(year), Integer.parseInt(hour), Integer.parseInt(minute), Integer.parseInt(second), Float.parseFloat(distance), Integer.parseInt(sprintingRepetitions), Integer.parseInt(sprintingRecovery));
        }
        else    //Not checking against EnumExerciseType.Swimming because of compiler error regards possibly not assigning a value to entryToReturn
        {
            entryToReturn = new SwimEntry(name, Integer.parseInt(day), Integer.parseInt(month), Integer.parseInt(year), Integer.parseInt(hour), Integer.parseInt(minute), Integer.parseInt(second), Float.parseFloat(distance), swimmingLocation);
        }

        return entryToReturn;
    }



} // TrainingRecord