//import necessary packages
package com.stir.cscu9t4practical1;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.lang.Number;

public class TrainingRecordGUI extends JFrame implements ActionListener {

	// Declare instance variables for GUI components
    private JTextField name = new JTextField(30);
    private JTextField day = new JTextField(2);
    private JTextField month = new JTextField(2);
    private JTextField year = new JTextField(4);
    private JTextField hours = new JTextField(2);
    private JTextField mins = new JTextField(2);
    private JTextField secs = new JTextField(2);
    private JTextField dist = new JTextField(4);
    private JLabel labn = new JLabel(" Name:");
    private JLabel labd = new JLabel(" Day:");
    private JLabel labm = new JLabel(" Month:");
    private JLabel laby = new JLabel(" Year:");
    private JLabel labh = new JLabel(" Hours:");
    private JLabel labmm = new JLabel(" Mins:");
    private JLabel labs = new JLabel(" Secs:");
    private JLabel labdist = new JLabel(" Distance (km):");
    private JButton addR = new JButton("Add");
    private JButton lookUpByDate = new JButton("Look Up");
    private JButton findAllByDate = new JButton("Find All By Date");

    // Create an instance of the TrainingRecord class to hold all the entries
    private TrainingRecord myAthletes = new TrainingRecord();

    // Create a JTextArea component to display output
    private JTextArea outputArea = new JTextArea(5, 50);

    public static void main(String[] args) {
        TrainingRecordGUI applic = new TrainingRecordGUI();
    } // main

    // set up the GUI 
    public TrainingRecordGUI() {
        super("Training Record");
        
        // Set layout for the JFrame
        setLayout(new FlowLayout());
        
        // Add the GUI components to the JFrame
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
        add(addR);
        addR.addActionListener(this);
        add(lookUpByDate);
        lookUpByDate.addActionListener(this);
        add(findAllByDate);
        findAllByDate.addActionListener(this);
        add(outputArea);
        outputArea.setEditable(false);
        setSize(720, 200);
        setVisible(true);
        blankDisplay();

        // To save typing in new entries while testing, uncomment
        // the following lines (or add your own test cases)
        
    } // constructor

    // listen for and respond to GUI events 
    public void actionPerformed(ActionEvent event) {
        String message = "";
        if (event.getSource() == addR) {
        	// Call the addEntry method to add a new entry to the record
            message = addEntry("generic");
        }
        if (event.getSource() == lookUpByDate) {
            // Call the lookupEntry method to find an entry in the record
            message = myAthletes.lookupEntry(name.getText(), new Date(Integer.parseInt(day.getText()), Integer.parseInt(month.getText()), Integer.parseInt(year.getText())));
        }
        if (event.getSource() == findAllByDate) {
            // Call the findAllEntriesByDate method to find all entries on the given date
            String dateStr = day.getText() + "-" + month.getText() + "-" + year.getText();
            Date d = new Date(dateStr);
            message = myAthletes.findAllEntriesByDate(new Date(Integer.parseInt(day.getText()), Integer.parseInt(month.getText()), Integer.parseInt(year.getText())));
            outputArea.setText(message);
        }
        outputArea.setText(message);
        // Clear the input fields after each action
        blankDisplay();
    } // actionPerformed

    public String addEntry(String what) {
        // initialize a message to indicate that a record has been added
        String message = "Record added\n";
        // print a message to the console indicating that a new entry is being added
        System.out.println("Adding " + what + " entry to the records");
        // retrieve the input values from the GUI
        String n = name.getText();
        int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());
        float km = java.lang.Float.parseFloat(dist.getText());
        int h = Integer.parseInt(hours.getText());
        int min = Integer.parseInt(mins.getText());
        int sec = Integer.parseInt(secs.getText());
        // create new Date and Time objects from the input values
        Date d1 = new Date(d, m, y);
        Time t1 = new Time(h, min, sec);
        // check the type of entry being added
        if (what.equalsIgnoreCase("generic")) {
            // if it's a generic entry, create a new Entry object and add it to the TrainingRecord
            Entry e1 = new Entry(n, d1, t1, km);
            myAthletes.addEntry(e1);
        } else {
            // if it's not a generic entry, display an error message
            message = "Entry not added. Invalid entry type.";
        }
        // return a message indicating the result of the operation
        return message;
    } // addEntry

    public String lookupEntry() {
        // initialize a message indicating that no entry was found
        String message = "No such entry";
        // retrieve the input values from the GUI
        int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());
        // create a new Date object from the input values
        Date d1 = new Date(d, m, y);
        // search for all entries on the given date
        ArrayList<Entry> entries = myAthletes.findEntry(d1);
        // if entries were found, create a message containing details of each entry
        if (!entries.isEmpty()) {
            message = "";
            for (Entry e : entries) {
                message += e.getEntry() + "\n";
            }
        }
        // return the message containing the entry details
        return message;
    } // lookupEntry

    public void blankDisplay() {
        // reset all input fields to blank values
        name.setText("");
        day.setText("");
        month.setText("");
        year.setText("");
        hours.setText("");
        mins.setText("");
        secs.setText("");
        dist.setText("");
    } // blankDisplay

    // Fills the input fields on the display for testing purposes only
    public void fillDisplay(Entry ent) {
        // fill in the input fields with values from the given Entry object
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
