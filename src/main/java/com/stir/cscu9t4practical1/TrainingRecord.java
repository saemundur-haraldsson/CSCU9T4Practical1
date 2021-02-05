// An implementation of a Training Record as an ArrayList
package com.stir.cscu9t4practical1;




import java.util.*;


public class TrainingRecord
{
    private List<Entry> entryTr;
    private List<RunEntry> runTr;
    private List<SprintEntry> sprintTr;
    private List<CycleEntry> cycleTr;
    private List<SwimEntry> swimTr;
    
    public TrainingRecord()
    {
        entryTr = new ArrayList<Entry>();
        runTr = new ArrayList<RunEntry>();
        sprintTr = new ArrayList<SprintEntry>();
        cycleTr = new ArrayList<CycleEntry>();
        swimTr = new ArrayList<SwimEntry>();
    } //constructor
    
    // add a record to the list
   public void addRunEntry(RunEntry e)
   {
       entryTr.add(e);
       runTr.add(e);
   } // addClass
   
   public void addSprintEntry(SprintEntry e)
   {
	   entryTr.add(e);
       sprintTr.add(e);    
   } // addClass
   
   public void addCycleEntry(CycleEntry e)
   {
	   entryTr.add(e);
       cycleTr.add(e);    
   } // addClass
   
   public void addSwimEntry(SwimEntry e)
   {
	   entryTr.add(e);
       swimTr.add(e);
   } // addClass
   
   
   public String removeRunEntry(String n, int d, int m, int y)
   {
	   String result = "No entries match the name and date entered and sport selected";
	   ListIterator<RunEntry> runIter = runTr.listIterator();
	   
	   while(runIter.hasNext())
	   {
		   RunEntry current = runIter.next();
		   if(current.getName().toLowerCase().equals(n.toLowerCase()) && current.getDay() == d
				   && current.getMonth() == m && current.getYear() == y)
		   {
			   entryTr.remove(current);
			   runTr.remove(current);
			   return "Run entry has been removed";
		   }
	   }
	   
	   return result;
   }
   
   public String removeSprintEntry(String n, int d, int m, int y)
   {
	   String result = "No entries match the name and date entered and sport selected";
	   ListIterator<SprintEntry> sprintIter = sprintTr.listIterator();
	   
	   while(sprintIter.hasNext())
	   {
		   SprintEntry current = sprintIter.next();
		   if(current.getName().toLowerCase().equals(n.toLowerCase()) && current.getDay() == d
				   && current.getMonth() == m && current.getYear() == y)
		   {
			   entryTr.remove(current);
			   sprintTr.remove(current);
			   return "Sprint entry has been removed";
		   }
	   }
	   
	   return result;
   }
   
   public String removeCycleEntry(String n, int d, int m, int y)
   {
	   String result = "No entries match the name and date entered and sport selected";
	   ListIterator<CycleEntry> cycleIter = cycleTr.listIterator();
	   
	   while(cycleIter.hasNext())
	   {
		   CycleEntry current = cycleIter.next();
		   if(current.getName().toLowerCase().equals(n.toLowerCase()) && current.getDay() == d
				   && current.getMonth() == m && current.getYear() == y)
		   {
			   entryTr.remove(current);
			   cycleTr.remove(current);
			   return "Cycle entry has been removed";
		   }
	   }
	   
	   return result;
   }
   
   public String removeSwimEntry(String n, int d, int m, int y)
   {
	   String result = "No entries match the name and date entered and sport selected";
	   ListIterator<SwimEntry> swimIter = swimTr.listIterator();
	   
	   while(swimIter.hasNext())
	   {
		   SwimEntry current = swimIter.next();
		   if(current.getName().toLowerCase().equals(n.toLowerCase()) && current.getDay() == d
				   && current.getMonth() == m && current.getYear() == y)
		   {
			   entryTr.remove(current);
			   swimTr.remove(current);
			   return "Entry has been removed";
		   }
	   }
	   
	   return result;
   }
   
   //returns a list of all entries of the selected sport on a given date
   public String lookupAllEntriesForSelectedSport(int d, int m, int y, String sportSelected)
   {   
       String result = "No entries found";
       int counter = 0;
       
       if(sportSelected.equals("run"))
       {
    	   ListIterator<RunEntry> runIter = runTr.listIterator();
    	   
           while (runIter.hasNext())
           {
              RunEntry current = runIter.next();
              if (current.getDay() == d && current.getMonth() == m && current.getYear() == y)
              {
            	  counter++;
            	  if(counter == 1) //if this is the first entry that matches the given date
            	  {
            		  result = current.getEntry(); //assign getEntry to result
            	  }
            	  else //if there is already at least one entry assigned to result
            	  {
            		  result = result.concat(current.getEntry()); //add the current entry to the end of result
            	  }
              }
           }
       }
       else if(sportSelected.equals("sprint"))
       {
    	   ListIterator<SprintEntry> sprintIter = sprintTr.listIterator();
    	   
           while (sprintIter.hasNext())
           {
              SprintEntry current = sprintIter.next();
              if (current.getDay() == d && current.getMonth() == m && current.getYear() == y)
              {
            	  counter++;
            	  if(counter == 1) //if this is the first entry that matches the given date
            	  {
            		  result = current.getSprintEntry(); //assign getEntry to result
            	  }
            	  else //if there is already at least one entry assigned to result
            	  {
            		  result = result.concat(current.getSprintEntry()); //add the current entry to the end of result
            	  }
              }
           }
       }
       else if(sportSelected.equals("cycle"))
       {
    	   ListIterator<CycleEntry> cycleIter = cycleTr.listIterator();
    	   
           while (cycleIter.hasNext())
           {
              CycleEntry current = cycleIter.next();
              if (current.getDay() == d && current.getMonth() == m && current.getYear() == y)
              {
            	  counter++;
            	  if(counter == 1) //if this is the first entry that matches the given date
            	  {
            		  result = current.getCycleEntry(); //assign getEntry to result
            	  }
            	  else //if there is already at least one entry assigned to result
            	  {
            		  result = result.concat(current.getCycleEntry()); //add the current entry to the end of result
            	  }
              }
           }
       }
       else
       {
    	   ListIterator<SwimEntry> swimIter = swimTr.listIterator();
    	   
           while (swimIter.hasNext())
           {
              SwimEntry current = swimIter.next();
              if (current.getDay() == d && current.getMonth() == m && current.getYear() == y)
              {
            	  counter++;
            	  if(counter == 1) //if this is the first entry that matches the given date
            	  {
            		  result = current.getSwimEntry(); //assign getEntry to result
            	  }
            	  else //if there is already at least one entry assigned to result
            	  {
            		  result = result.concat(current.getSwimEntry()); //add the current entry to the end of result
            	  }
              }
           }
       }

       return result;
   }
   
   /*public String lookupAllEntriesForGivenName(String n)
   {
       ListIterator<Entry> iter = entryTr.listIterator();
       String result = "No entries found";
       int counter = 0;
       while (iter.hasNext())
       {
          Entry current = iter.next();

          if (current.getName().trim().toLowerCase().equals(n))
          {
        	  counter++;
        	  if(counter == 1)
        	  {
        		  if(current.getClass() == RunEntry.class)
        		  {
        			  result = current.getEntry();
        		  }
        		  else if(current.getClass() == SprintEntry.class)
        		  {
        			  result = current.getSprintEntry();
        		  }
        		  else if(current.getClass() == CycleEntry.class)
        		  {
        			  
        		  }
        		  else
        		  {
        			  
        		  }
        	  }
        	  else
        	  {
        		  result = result.concat(current.getEntry());
        	  }
          }            
       }
       return result;
   } // lookupEntry*/
   
   // look up the entry of a given day and month
   /*public String lookupEntry (int d, int m, int y)
   {
       ListIterator<Entry> iter = entryTr.listIterator();
       String result = "No entries found";
       while (iter.hasNext())
       {
          Entry current = iter.next();
          if (current.getDay() == d && current.getMonth() == m && current.getYear() == y) 
             result = current.getEntry();
       }
       return result;
   } // lookupEntry*/
   
   //checks if there are any other run entries with the exact same details
   public boolean isUniqueEntry(String n, int d, int m, int y, int h, int mm, int s, float dist)
   {
       ListIterator<RunEntry> iter = runTr.listIterator();
       
       while(iter.hasNext())
       {
    	   RunEntry current = iter.next();
    	   if(current.getName().equals(n) && current.getDay() == d && current.getMonth() == m && current.getYear() == y
    			   && current.getHour() == h && current.getMin() == mm && current.getSec() == s
    			   && current.getDistance() == dist)
    		   return false;
       }
	   return true;
   }
   
   //checks if there are any other sprint entries with the exact same details
   public boolean isUniqueEntry(String n, int d, int m, int y, int h, int mm, int s, float dist, int recov, int reps)
   {
       ListIterator<SprintEntry> iter = sprintTr.listIterator();
       
       while(iter.hasNext())
       {
    	   SprintEntry current = iter.next();
    	   if(current.getName().equals(n) && current.getDay() == d && current.getMonth() == m && current.getYear() == y
    			   && current.getHour() == h && current.getMin() == mm && current.getSec() == s
    			   && current.getDistance() == dist && current.getRecoveryTime() == recov && current.getRepetitions() == reps)
    		   return false;
       }
	   return true;
   }
   
   //checks if there are any other cycle entries with the exact same details
   public boolean isUniqueEntry(String n, int d, int m, int y, int h, int mm, int s, float dist, String ter, String tem)
   {
       ListIterator<CycleEntry> iter = cycleTr.listIterator();
       
       while(iter.hasNext())
       {
    	   CycleEntry current = iter.next();
    	   if(current.getName().equals(n) && current.getDay() == d && current.getMonth() == m && current.getYear() == y
    			   && current.getHour() == h && current.getMin() == mm && current.getSec() == s
    			   && current.getDistance() == dist && current.getTerrain().equals(ter) && current.getTempo().equals(tem))
    		   return false;
       }
	   return true;
   }
   
 //checks if there are any other swim entries with the exact same details
   public boolean isUniqueEntry(String n, int d, int m, int y, int h, int mm, int s, float dist, String wh)
   {
       ListIterator<SwimEntry> iter = swimTr.listIterator();
       
       while(iter.hasNext())
       {
    	   SwimEntry current = iter.next();
    	   if(current.getName().equals(n) && current.getDay() == d && current.getMonth() == m && current.getYear() == y
    			   && current.getHour() == h && current.getMin() == mm && current.getSec() == s
    			   && current.getDistance() == dist && current.getWhere().equals(wh))
    		   return false;
       }
	   return true;
   }
   
   // Count the number of entries
   public int getNumberOfEntries()
   {
       return entryTr.size();
   }
   // Clear all entries
   public void clearAllEntries()
   {
       entryTr.clear();
   }
   
} // TrainingRecord