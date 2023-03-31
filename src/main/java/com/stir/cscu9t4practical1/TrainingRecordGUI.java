// GUI and main program for the Training Record
package com.stir.cscu9t4practical1;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.lang.Number;

public class TrainingRecordGUI extends JFrame implements ActionListener {

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
    private JButton lookUpAllByDate = new JButton("Look Up All");

    private TrainingRecord myAthletes = new TrainingRecord();

    private JTextArea outputArea = new JTextArea(5, 50);
    private JTextField whereField = new JTextField(10);
    private JTextField repetitionsField = new JTextField(3);
    private JTextField recoveryField = new JTextField(3);

    private JTextField tempoField = new JTextField(3);
    private JTextField terrainField = new JTextField(10);
    private JButton findAllBasedOnName = new JButton("Name Search");
    private JButton removeButton = new JButton("Remove Entry");

    public static void main(String[] args) {
        TrainingRecordGUI applic = new TrainingRecordGUI();
    } // main

    // set up the GUI 
    public TrainingRecordGUI() {
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
        add(new JLabel("---Swimming---"));
        add(new JLabel("Outdoor or Indoor:"));
        add(whereField);
        add(new JLabel("---Sprinting---"));
        add(new JLabel("Repetitions:"));
        add(repetitionsField);
        add(new JLabel("Recovery Intervals(mins):"));
        add(recoveryField);
        add(new JLabel("---Cycling---"));
        add(new JLabel("Terrain:"));
        add(terrainField);
        add(new JLabel("Tempo(mph):"));
        add(tempoField);
        add(addR);
        addR.addActionListener(this);
        add(lookUpByDate);
        lookUpByDate.addActionListener(this);
        add(lookUpAllByDate);
        lookUpAllByDate.addActionListener(this);
        add(findAllBasedOnName);
        findAllBasedOnName.addActionListener(this);
        add(removeButton);
        removeButton.addActionListener(this);
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
            message = addEntry("generic");
        }
        if (event.getSource() == lookUpByDate) {
            message = lookupEntry();
        }
        if (event.getSource() == lookUpAllByDate) {
            message = lookupAllEntries();
        }
        if (event.getSource() == findAllBasedOnName){
            message = lookupAllEntriesByName();
        } if (event.getSource() ==  removeButton){
            message = removeAllEntries();
        }
        outputArea.setText(message);
        blankDisplay();
    } // actionPerformed

    public String addEntry(String what) {
        String message = "adding...";
        String n = name.getText();
        int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());
        float km = java.lang.Float.parseFloat(dist.getText());
        int h = Integer.parseInt(hours.getText());
        int mm = Integer.parseInt(mins.getText());
        int s = Integer.parseInt(secs.getText());
        String terrain = terrainField.getText();
        String tempo = tempoField.getText();
        String where = whereField.getText();
        String repetitions = repetitionsField.getText();
        String recovery = recoveryField.getText();
        if (myAthletes.CheckIfEntryExists(m,d,y,n) == false) {
            if (!terrain.isEmpty() && !tempo.isEmpty()) {
                CycleEntry e = new CycleEntry(n, d, m, y, h, mm, s, km, terrain, tempo);
                myAthletes.addEntry(e);
                System.out.print("Added as cycle");
            } else if (!where.isEmpty()) {
                SwimEntry e = new SwimEntry(n, d, m, y, h, mm, s, km, where);
                myAthletes.addEntry(e);
                System.out.print("Added as swim");
            } else if (!repetitions.isEmpty() && !recovery.isEmpty()) {
                SprintEntry e = new SprintEntry(n, d, m, y, h, mm, s, km, Integer.parseInt(repetitions), Integer.parseInt(recovery));
                myAthletes.addEntry(e);
                System.out.print("Added as sprint");
            } else {
                Entry e = new Entry(n, d, m, y, h, mm, s, km);
                myAthletes.addEntry(e);
                message = "Record added as run";
            }
            return message;
        }else {
            message = "An entry under this name and date already exists";
            return message;
        }
    }
    
    public String lookupEntry() {
        int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());
        outputArea.setText("looking up record ...");
        String message = myAthletes.lookupEntry(d, m, y);
        return message;
    }
    public String lookupAllEntries() {
        int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());
        outputArea.setText("looking up record ...");
        String message = myAthletes.lookupAllEntries(d, m, y);
        return message;
    }
    public String lookupAllEntriesByName(){
       String searchTerm = name.getText();
        outputArea.setText("looking up record ...");
        String message = myAthletes.lookupAllEntriesByName(searchTerm);
        return message;
    }
    public String removeAllEntries() {
        int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());
        String n = name.getText();
        outputArea.setText("looking up record ...");
        String message = myAthletes.removeAllEntries(d, m, y,n);
        return message;
    }

    public void blankDisplay() {
        name.setText("");
        day.setText("");
        month.setText("");
        year.setText("");
        hours.setText("");
        mins.setText("");
        secs.setText("");
        dist.setText("");
        recoveryField.setText("");
        terrainField.setText("");
        repetitionsField.setText("");
        tempoField.setText("");
        whereField.setText("");
    }// blankDisplay
    // Fills the input fields on the display for testing purposes only
    public void fillDisplay(Entry ent) {
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

