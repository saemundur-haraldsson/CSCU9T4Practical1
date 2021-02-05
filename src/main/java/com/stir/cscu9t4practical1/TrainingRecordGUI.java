// GUI and main program for the Training Record
package com.stir.cscu9t4practical1;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.lang.Number;

public class TrainingRecordGUI extends JFrame implements ActionListener
{
	private String[] tempoOptions = {"slow", "moderate", "fast"}; //this is passed into the tempo combo box
	private String[] whereSwimOptions = {"outdoors", "in the pool"}; //this is passed into the where swim combo box
	private String selectedRadio = "run";
    private JTextField name = new JTextField(30);
    private JTextField day = new JTextField(2);
    private JTextField month = new JTextField(2);
    private JTextField year = new JTextField(4);
    private JTextField hours = new JTextField(2);
    private JTextField mins = new JTextField(2);
    private JTextField secs = new JTextField(2);
    private JTextField dist = new JTextField(4);
    private JTextField recoveryTime = new JTextField(2);
    private JTextField repetitions = new JTextField(4);
    private JTextField terrain = new JTextField(15);
    private JLabel labn = new JLabel(" Name:");
    private JLabel labd = new JLabel(" Day:");
    private JLabel labm = new JLabel(" Month:");
    private JLabel laby = new JLabel(" Year:");
    private JLabel labh = new JLabel(" Hours:");
    private JLabel labmm = new JLabel(" Mins:");
    private JLabel labs = new JLabel(" Secs:");
    private JLabel labdist = new JLabel(" Distance (km):");
    private JLabel labrecoveryTime = new JLabel("Recovery time:");
    private JLabel labrepetitions = new JLabel("Repetitions:");
    private JLabel labterrain = new JLabel("Terrain:");
    private JLabel labtempo = new JLabel("Tempo:");
    private JLabel labwhereSwim = new JLabel("Swimming location:");
    private JButton addR = new JButton("Add entry");
    private JButton removeEntry = new JButton("Remove entry");
    private JButton findAllByName = new JButton("Find all for given name");
    private JButton findAllByDateForSelectedSport = new JButton("Find all for selected sport");
    private JComboBox tempo = new JComboBox(tempoOptions);
    private JComboBox whereSwim = new JComboBox(whereSwimOptions);
    private JRadioButton runRadio = new JRadioButton("run");
    private JRadioButton sprintRadio = new JRadioButton("sprint");
    private JRadioButton cycleRadio = new JRadioButton("cycle");
    private JRadioButton swimRadio = new JRadioButton("swim");
    private ButtonGroup sportGroup = new ButtonGroup();

    private TrainingRecord myAthletes = new TrainingRecord();

    private JTextArea outputArea = new JTextArea(5, 50);

    public static void main(String[] args)
    {
        TrainingRecordGUI applic = new TrainingRecordGUI();
    } // main

    // set up the GUI 
    public TrainingRecordGUI()
    {
        super("Training Record");
        setLayout(new FlowLayout());
        add(labn);
        add(name);
        name.setEditable(true);
        add(labd);
        add(day);
        day.setEditable(true);
        add(labm);
        add(month);
        month.setEditable(true);
        add(laby);
        add(year);
        year.setEditable(true);
        add(labh);
        add(hours);
        hours.setEditable(true);
        add(labmm);
        add(mins);
        mins.setEditable(true);
        add(labs);
        add(secs);
        secs.setEditable(true);
        add(labdist);
        add(dist);
        dist.setEditable(true);
        add(labrecoveryTime);
        add(recoveryTime);
        recoveryTime.setEditable(false);
        add(labrepetitions);
        add(repetitions);
        repetitions.setEditable(false);
        add(labterrain);
        add(terrain);
        terrain.setEditable(false);
        add(labtempo);
        add(tempo);
        tempo.enable(false);
        add(labwhereSwim);
        add(whereSwim);
        whereSwim.enable(false);
        
        
        
        add(addR);
        addR.addActionListener(this);
        add(removeEntry);
        removeEntry.setEnabled(false);
        removeEntry.addActionListener(this);
        add(findAllByName);
        findAllByName.setEnabled(false);
        findAllByName.addActionListener(this);
        add(findAllByDateForSelectedSport);
        findAllByDateForSelectedSport.setEnabled(false);
        findAllByDateForSelectedSport.addActionListener(this);
        sportGroup.add(runRadio);
        sportGroup.add(sprintRadio);
        sportGroup.add(cycleRadio);
        sportGroup.add(swimRadio);
        add(runRadio);
        runRadio.addActionListener(this);
        add(sprintRadio);
        sprintRadio.addActionListener(this);
        add(cycleRadio);
        cycleRadio.addActionListener(this);
        add(swimRadio);
        swimRadio.addActionListener(this);
        runRadio.setSelected(true);
        add(outputArea);
        outputArea.setEditable(false);
        setSize(720, 200);
        setVisible(true);
        blankDisplay();

        // To save typing in new entries while testing, uncomment
        // the following lines (or add your own test cases)
        
    } // constructor

    // listen for and respond to GUI events 
    public void actionPerformed(ActionEvent event)
    {
        String message = "";
        
        if (event.getSource() == addR)
        {
            message = addEntry();
        }
        if(event.getSource() == removeEntry)
        {
        	message = removeEntry();
        }
        if (event.getSource() == findAllByName)
        {
            //message = lookupAllEntriesForGivenName();
        }
        if(event.getSource() == findAllByDateForSelectedSport)
        {
        	message = lookupAllEntriesForSelectedSport();
        }
        if(event.getSource() == runRadio) //if run is selected
        {
        	selectedRadio = "run";
        	recoveryTime.setEditable(false);
        	repetitions.setEditable(false);
        	terrain.setEditable(false);
        	tempo.enable(false);
        	whereSwim.enable(false);
        }
        if(event.getSource() == sprintRadio) //if sprint is selected
        {
        	selectedRadio = "sprint";
        	recoveryTime.setEditable(true);
        	repetitions.setEditable(true);
        	terrain.setEditable(false);
        	tempo.enable(false);
        	whereSwim.enable(false);
        }
        if(event.getSource() == cycleRadio) //if cycle is selected
        {
        	selectedRadio = "cycle";
        	recoveryTime.setEditable(false);
        	repetitions.setEditable(false);
        	terrain.setEditable(true);
        	tempo.enable(true);
        	whereSwim.enable(false);
        }
        if(event.getSource() == swimRadio) //if swim is selected
        {
        	selectedRadio = "swim";
        	recoveryTime.setEditable(false);
        	repetitions.setEditable(false);
        	terrain.setEditable(false);
        	tempo.enable(false);
        	whereSwim.enable(true);
        }
        outputArea.setText(message);
        //blankDisplay();
    } // actionPerformed

    public String addEntry()
    {
        String message = "Record added\n";
        System.out.println("Adding " + selectedRadio + " entry to the records");
        
    	if(name.getText().trim().equals("")) //if there is no name input
    	{
    		return "Please enter a name";
    	}
    	
        String n = name.getText().trim();
        
        try
        {
            int m = Integer.parseInt(month.getText());
            int d = Integer.parseInt(day.getText());
            int y = Integer.parseInt(year.getText());
            float km = java.lang.Float.parseFloat(dist.getText());
            int h = Integer.parseInt(hours.getText());
            int mm = Integer.parseInt(mins.getText());
            int s = Integer.parseInt(secs.getText());
            
            if(selectedRadio.equals("run"))
            {
            	if(myAthletes.isUniqueEntry(n, d, m, y, h, mm, s, km)) //if there are no other run entries with the exact same details
            	{
                    RunEntry eRun = new RunEntry(n, d, m, y, h, mm, s, km);
                    myAthletes.addRunEntry(eRun); //add the new entry
                    blankDisplay();
                    removeEntry.setEnabled(true);
                    findAllByName.setEnabled(true);
                    findAllByDateForSelectedSport.setEnabled(true);
                    return message;
            	}
            	else
            		return "The same details have already been entered";
            }
            else if(selectedRadio.equals("sprint"))
            {
            	int recov = Integer.parseInt(recoveryTime.getText());
            	int reps = Integer.parseInt(repetitions.getText());
            	
            	if(myAthletes.isUniqueEntry(n, d, m, y, h, mm, s, km, recov, reps)) //if there are no other run entries with the exact same details
            	{
                    SprintEntry eSprint = new SprintEntry(n, d, m, y, h, mm, s, km, recov, reps);
                    myAthletes.addSprintEntry(eSprint); //add the new entry
                    blankDisplay();
                    removeEntry.setEnabled(true);
                    findAllByName.setEnabled(true);
                    findAllByDateForSelectedSport.setEnabled(true);
                    return message;
            	}
            	else
            		return "The same details have already been entered";
            }
            else if(selectedRadio.equals("cycle"))
            {
            	String ter = terrain.getText();
            	String tem = tempo.getSelectedItem().toString();
            	
            	if(myAthletes.isUniqueEntry(n, d, m, y, h, mm, s, km, ter, tem)) //if there are no other run entries with the exact same details
            	{
                    CycleEntry eCycle = new CycleEntry(n, d, m, y, h, mm, s, km, ter, tem);
                    myAthletes.addCycleEntry(eCycle); //add the new entry
                    blankDisplay();
                    removeEntry.setEnabled(true);
                    findAllByName.setEnabled(true);
                    findAllByDateForSelectedSport.setEnabled(true);
                    return message;
            	}
            	else
            		return "The same details have already been entered";
            }
            else //if swim is selected
            {
            	String wh = whereSwim.getSelectedItem().toString();
            	
            	if(myAthletes.isUniqueEntry(n, d, m, y, h, mm, s, km, wh)) //if there are no other run entries with the exact same details
            	{
                    SwimEntry eSwim = new SwimEntry(n, d, m, y, h, mm, s, km, wh);
                    myAthletes.addSwimEntry(eSwim); //add the new entry
                    blankDisplay();
                    removeEntry.setEnabled(true);
                    findAllByName.setEnabled(true);
                    findAllByDateForSelectedSport.setEnabled(true);
                    return message;
            	}
            	else
            		return "The same details have already been entered";
            }
        }
        catch(Exception e) //catches if invalid details are entered or not all text boxes have data in them
        {
        	return "Please enter valid details";
        }
    }
    
    public String removeEntry() //Removes an entry based on the name and date input and the sport selected
    {
        String message = "Record removed\n";
        System.out.println("Removing from the records");
        
    	if(name.getText().trim().equals("")) //if there is no name input
    	{
    		return "Please enter a name";
    	}
    	
    	String n = name.getText().trim();
    	
    	try
    	{
            int m = Integer.parseInt(month.getText());
            int d = Integer.parseInt(day.getText());
            int y = Integer.parseInt(year.getText());
            
            if(selectedRadio.equals("run"))
            {
            	return myAthletes.removeRunEntry(n, d, m, y);
            }
            else if(selectedRadio.equals("sprint"))
            {
            	return myAthletes.removeSprintEntry(n, d, m, y);
            }
            else if(selectedRadio.equals("cycle"))
            {
            	return myAthletes.removeCycleEntry(n, d, m, y);
            }
            else
            {
            	return myAthletes.removeSwimEntry(n, d, m, y);
            }
    	}
        catch(Exception e)
    	{
        	return "Please enter a valid date";
    	}
    }
    
    public String lookupAllEntriesForSelectedSport()
    {
    	try
    	{
            int m = Integer.parseInt(month.getText());
            int d = Integer.parseInt(day.getText());
            int y = Integer.parseInt(year.getText());
            outputArea.setText("looking up record ...");
            String message = myAthletes.lookupAllEntriesForSelectedSport(d, m, y, selectedRadio); //passes in the date as well as the selected sport
            return message;
    	}
    	catch(Exception e) //catches if there is no valid date in the day, month or year text boxes
    	{
    		return "Please enter a date";
    	}
    }
    
    /*
    public String lookupAllEntriesForGivenName()
    {
    	try
    	{
    		if(name.getText().trim() != "")
    		{
                outputArea.setText("looking up record ...");
                String message = myAthletes.lookupAllEntriesForGivenName(name.getText().trim().toLowerCase());
                return message;
    		}
    		return "Please enter a name";
    	}
    	catch(Exception e)
    	{
    		return "Please enter a name";
    	}
    }*/

    public void blankDisplay()
    {
        name.setText("");
        day.setText("");
        month.setText("");
        year.setText("");
        hours.setText("");
        mins.setText("");
        secs.setText("");
        dist.setText("");
        recoveryTime.setText("");
        repetitions.setText("");
        terrain.setText("");

    }// blankDisplay
    // Fills the input fields on the display for testing purposes only
    public void fillDisplay(Entry ent)
    {
        name.setText(ent.getName());
        day.setText(String.valueOf(ent.getDay()));
        month.setText(String.valueOf(ent.getMonth()));
        year.setText(String.valueOf(ent.getYear()));
        hours.setText(String.valueOf(ent.getHour()));
        mins.setText(String.valueOf(ent.getMin()));
        secs.setText(String.valueOf(ent.getSec()));
        dist.setText(String.valueOf(ent.getDistance()));
    }

} // TrainingRecordGUI

