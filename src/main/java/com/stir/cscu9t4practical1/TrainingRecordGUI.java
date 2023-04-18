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
    private JButton removeEntry = new JButton("Remove");
    private JLabel labRemove = new JLabel("Enter date and name to remove an entry:");
    private JTextField removeDay = new JTextField(2);
    private JTextField removeMonth = new JTextField(2);
    private JTextField removeYear = new JTextField(4);
    private JTextField removeName = new JTextField(30);
    private JLabel labRemoveDay = new JLabel(" Day:");
    private JLabel labRemoveMonth = new JLabel(" Month:");
    private JLabel labRemoveYear = new JLabel(" Year:");

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
        add(removeEntry);
        removeEntry.addActionListener(this);
        add(labRemove);
        add(labRemoveDay);
        add(removeDay);
        removeDay.setEditable(true);
        add(labRemoveMonth);
        add(removeMonth);
        removeMonth.setEditable(true);
        add(labRemoveYear);
        add(removeYear);
        removeYear.setEditable(true);
        add(labn);
        add(removeName);
        removeName.setEditable(true);
        // Add the output JTextArea component to the JFrame
        add(outputArea);
        outputArea.setEditable(false);

        // Set the JFrame size and make it visible
        setSize(600, 400);
        setVisible(true);
    } // constructor

    @Override
    public void actionPerformed(ActionEvent e) {
        // Handle the Add button click
        if (e.getSource() == addR) {
            String n = name.getText();
            int d = Integer.parseInt(day.getText());
            int m = Integer.parseInt(month.getText());
            int y = Integer.parseInt(year.getText());
            int h = Integer.parseInt(hours.getText());
            int mm = Integer.parseInt(mins.getText());
            int s = Integer.parseInt(secs.getText());
            float distf = Float.parseFloat(dist.getText()); // create an instance of the Entry class and add it to the TrainingRecord
            Entry entry = new Entry(n, d, m, y, h, mm, s, distf);
            myAthletes.addEntry(entry);

            // display success message
            outputArea.setText("Entry added successfully.");
        }

        // Handle the Look Up button click
        if (e.getSource() == lookUpByDate) {
            int d = Integer.parseInt(day.getText());
            int m = Integer.parseInt(month.getText());
            int y = Integer.parseInt(year.getText());

            // search for the Entry in the TrainingRecord and display it
            Entry entry = myAthletes.getEntryByDate(d, m, y);
            if (entry != null) {
                outputArea.setText(entry.getEntryAsString());
            } else {
                outputArea.setText("No entry found for that date.");
            }
        }

        // Handle the Find All By Date button click
        if (e.getSource() == findAllByDate) {
            int d = Integer.parseInt(day.getText());
            int m = Integer.parseInt(month.getText());
            int y = Integer.parseInt(year.getText());

            // search for all Entries in the TrainingRecord for a specific date and display them
            ArrayList < Entry > entries = myAthletes.getAllEntriesByDate(d, m, y);
            if (!entries.isEmpty()) {
                String output = "";
                for (Entry entry: entries) {
                    output += entry.getEntryAsString() + "\n";
                }
                outputArea.setText(output);
            } else {
                outputArea.setText("No entries found for that date.");
            }
        }

        // Handle the Remove button click
        if (e.getSource() == removeEntry) {
            int d = Integer.parseInt(removeDay.getText());
            int m = Integer.parseInt(removeMonth.getText());
            int y = Integer.parseInt(removeYear.getText());
            String n = removeName.getText();

            // remove the Entry from the TrainingRecord and display success message
            boolean removed = myAthletes.removeEntry(d, m, y, n);
            if (removed) {
                outputArea.setText("Entry removed successfully.");
            } else {
                outputArea.setText("No entry found to remove.");
            }
        }
    } // actionPerformed
} // TrainingRecordGUI