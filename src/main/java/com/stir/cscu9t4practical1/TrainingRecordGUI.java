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
            String entryType = name.getText();
            if (entryType.equalsIgnoreCase("cycling")) {
                message = addEntry("CycleSession");
            } else if (entryType.equalsIgnoreCase("running")) {
                message = addEntry("RunSprintSession");
            } else if (entryType.equalsIgnoreCase("swimming")) {
                message = addEntry("SwimSession");
            } else {
                message = addEntry("TrainingSession");
            }
        }
        if (event.getSource() == lookUpByDate) {
            // Call the lookupEntry method to find an entry by date
            String date = getInputDate();
            message = lookupEntry(date);
        }
        if (event.getSource() == findAllByDate) {
            // Call the findAllEntries method to find all entries on a date
            String date = getInputDate();
            message = findAllEntries(date);
        }
        // Update the display with the message
        outputArea.setText(message);
    }

    // Add a new entry to the training record and return a message to display
    private String addEntry(String entryType) {
        // Get the input values from the GUI components
        String athleteName = name.getText();
        int dayInt = Integer.parseInt(day.getText());
        int monthInt = Integer.parseInt(month.getText());
        int yearInt = Integer.parseInt(year.getText());
        int hoursInt = Integer.parseInt(hours.getText());
        int minsInt = Integer.parseInt(mins.getText());
        int secsInt = Integer.parseInt(secs.getText());
        double distance = Double.parseDouble(dist.getText());

        // Create a new instance of the appropriate entry type
        Entry newEntry;
        switch (entryType) {
            case "CycleSession":
                newEntry = new CycleSession(athleteName, dayInt, monthInt, yearInt, hoursInt, minsInt, secsInt, distance);
                break;
            case "RunSprintSession":
                newEntry = new RunSprintSession(athleteName, dayInt, monthInt, yearInt, hoursInt, minsInt, secsInt, distance);
                break;
            case "SwimSession":
                newEntry = new SwimSession(athleteName, dayInt, monthInt, yearInt, hoursInt, minsInt, secsInt, distance);
                break;
            default:
                newEntry = new TrainingSession(athleteName, dayInt, monthInt, yearInt, hoursInt, minsInt, secsInt);
        }

        // Add the new entry to the training record
        myAthletes.addEntry(newEntry);

        // Return a message indicating success
        return "New " + entryType + " added to the record.";
    }

    // Find an entry by date and return a message to display
    private String lookupEntry(String date) {
        // Use the lookupEntry method of the TrainingRecord class to find the entry
        Entry entry = myAthletes.lookupEntry(date);

        // If the entry is not found, return a message indicating so
        if (entry == null) {
            return "No entry found for " + date;
        }

        // Otherwise, return a string representation of the entry
        return entry.toString();
    }

    // Find all entries on a date and return a message to display
    private String findAllEntries(String date) {
        // Use the findAllEntries method of the TrainingRecord class to find all entries
        ArrayList < Entry > entries = myAthletes.findAllEntries(date);

        // If there are no entries found, return a message indicating so
        if (entries.isEmpty()) {
            return "No entries found for " + date;
        }

        // Otherwise, return a string representation of all the entries
        String message = "";
        for (Entry entry: entries) {
            message += entry.toString() + "\n";
        }
        return message;
    }

    // Get the date input from the GUI components and format it as a string
    private String getInputDate() {
        String dayStr = day.getText();
        String monthStr = month.getText();
        String yearStr = year.getText();
        return dayStr + "/" + monthStr + "/" + yearStr;
    }

    // Set all the GUI components to their default values
    private void blankDisplay() {
        name.setText("");
        day.setTest("");
        //Find all entries on a date and return a message to display
        private String findAllEntries(String date) {
            //Create a Date object from the input date string
            String[] dateParts = date.split("/");
            int dayInt = Integer.parseInt(dateParts[0]);
            int monthInt = Integer.parseInt(dateParts[1]);
            int yearInt = Integer.parseInt(dateParts[2]);
            Date searchDate = new Date(dayInt, monthInt, yearInt);

            //Use the findEntries method to search for entries on the given date
            ArrayList < Entry > entries = myAthletes.findEntries(searchDate);

            //If no entries were found, return an appropriate message
            if (entries.isEmpty()) {
                return "No entries found on " + searchDate.toString() + ".";
            }

            //Build a message listing all the entries found on the given date
            StringBuilder message = new StringBuilder("Entries found on " + searchDate.toString() + ":\n");
            for (Entry entry: entries) {
                message.append(entry.toString()).append("\n");
            }

            return message.toString();
        }

        //Get the input date from the day, month, and year fields
        private String getInputDate() {
            String dayString = day.getText();
            String monthString = month.getText();
            String yearString = year.getText();
            return dayString + "/" + monthString + "/" + yearString;
        }

        //Clear the GUI components for entering a new entry
        private void blankDisplay() {
            name.setText("");
            day.setText("");
            month.setText("");
            year.setText("");
            hours.setText("");
            mins.setText("");
            secs.setText("");
            dist.setText("");
            outputArea.setText("");
        }

    } // TrainingRecordGUI class