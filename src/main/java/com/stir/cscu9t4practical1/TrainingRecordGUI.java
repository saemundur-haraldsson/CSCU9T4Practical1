// GUI and main program for the Training Record
package com.stir.cscu9t4practical1;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.lang.Number;

public class TrainingRecordGUI extends JFrame implements ActionListener {

    private JRadioButton rbswim = new JRadioButton("Swim"); //TASK 8
    private JRadioButton rbsprint = new JRadioButton("Sprint"); //TASK 8
    private JRadioButton rbcycle = new JRadioButton("Cycle"); //TASK 8
    private ButtonGroup bg = new ButtonGroup();

    private JTextField name = new JTextField(30);
    private JTextField day = new JTextField(2);
    private JTextField month = new JTextField(2);
    private JTextField year = new JTextField(4);
    private JTextField hours = new JTextField(2);
    private JTextField mins = new JTextField(2);
    private JTextField secs = new JTextField(2);
    private JTextField dist = new JTextField(4);

    private JTextField where = new JTextField(10); //Task 8
    private JTextField recovery = new JTextField(2); //Task 8
    private JTextField repetition = new JTextField(2); //Task 8
    private JTextField terrain = new JTextField(10); //Task 8
    private JTextField tempo = new JTextField(10); //Task 8

    private JLabel labn = new JLabel(" Name:");
    private JLabel labd = new JLabel(" Day:");
    private JLabel labm = new JLabel(" Month:");
    private JLabel laby = new JLabel(" Year:");
    private JLabel labh = new JLabel(" Hours:");
    private JLabel labmm = new JLabel(" Mins:");
    private JLabel labs = new JLabel(" Secs:");
    private JLabel labdist = new JLabel(" Distance (km):");

    private JLabel labwhere = new JLabel("Where:"); //Task 8
    private JLabel labrecovery = new JLabel("Recovery"); //Task 8
    private JLabel labrepetition = new JLabel("Repetitions:"); //Task 8
    private JLabel labterrain = new JLabel("Terrain:"); //Task 8
    private JLabel labtempo = new JLabel("Tempo:"); //Task 8

    private JButton addR = new JButton("Add");
    private JButton lookUpByDate = new JButton("Look Up");
    private JButton findAllByDate = new JButton("Find All By Date"); //TASK 1
    private JButton removeEntries = new JButton("Remove Entries"); //TASK 11

    private TrainingRecord myAthletes = new TrainingRecord();

    private JTextArea outputArea = new JTextArea(15, 50);

    public static void main(String[] args) {
        TrainingRecordGUI applic = new TrainingRecordGUI();
    } // main

    // set up the GUI 
    public TrainingRecordGUI() {
        super("Training Record");
        setLayout(new FlowLayout());
        //adding radio buttons to deal with the different types of record to be added
        bg.add(rbswim); //TASK 8
        bg.add(rbcycle); //TASK 8
        bg.add(rbsprint); //TASK 8
        add(rbswim); //TASK 8
        rbswim.addActionListener(this);
        add(rbcycle); //TASK 8
        rbcycle.addActionListener(this);
        add(rbsprint); //TASK 8
        rbsprint.addActionListener(this);

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

        add(labwhere); //TASK 8
        add(where); //TASK 8
        where.setEditable(true); //TASK 8
        add(labrecovery); //TASK 8
        add(recovery); //TASK 8
        recovery.setEditable(true); //TASK 8
        add(labrepetition); //TASK 8
        add(repetition); //TASK 8
        repetition.setEditable(true); //TASK 8
        add(labterrain); //TASK 8
        add(terrain); //TASK 8
        terrain.setEditable(true); //TASK 8
        add(labtempo); //TASK 8
        add(tempo); //TASK 8
        tempo.setEditable(true); //TASK 8

        add(addR);
        addR.addActionListener(this);
        add(lookUpByDate);
        lookUpByDate.addActionListener(this);

        add(findAllByDate); //TASK 1
        findAllByDate.addActionListener(this); //TASK 1

        add(removeEntries); //TASK 11
        removeEntries.addActionListener(this); //TASK 11

        add(outputArea);
        outputArea.setEditable(false);
        setSize(780, 400);
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
        //action performed method for TASK 1
        if (event.getSource() == findAllByDate) {
            //message = ("Not implemented yet");
            message = lookupAllEntries();
        }

        if (event.getSource() == rbswim){
            message = addSwimEntry("swim");
            if (rbswim.isSelected())
            {
                labrecovery.setEnabled(false);
                recovery.setEnabled(false);
                labtempo.setEnabled(false);
                tempo.setEnabled(false);
                labterrain.setEnabled(false);
                terrain.setEnabled(false);
                labrepetition.setEnabled(false);
                repetition.setEnabled(false);
                labdist.setEnabled(true);
                dist.setEnabled(true);
            }
        }
        if (event.getSource() == rbcycle){
            message = addCycleEntry("cycle");
            if(rbcycle.isSelected())
            {
                labrepetition.setEnabled(false);
                repetition.setEnabled(false);
                labrecovery.setEnabled(false);
                recovery.setEnabled(false);
                labwhere.setEnabled(false);
                where.setEnabled(false);
                labdist.setEnabled(true);
                dist.setEnabled(true);
                labtempo.setEnabled(true);
                tempo.setEnabled(true);
                labterrain.setEnabled(true);
                terrain.setEnabled(true);
            }
        }
        if (event.getSource() == rbsprint){
            labdist.setText("Distance (m):");
            message = addSprintEntry("sprint");
            if(rbsprint.isSelected());
            {
                labwhere.setEnabled(false);
                where.setEnabled(false);
                labtempo.setEnabled(false);
                tempo.setEnabled(false);
                labterrain.setEnabled(false);
                terrain.setEnabled(false);
                labdist.setEnabled(true);
                dist.setEnabled(true);
                labrepetition.setEnabled(true);
                repetition.setEnabled(true);
                labrecovery.setEnabled(true);
                recovery.setEnabled(true);
            }
        }
        outputArea.setText(message);
        blankDisplay();
    } // actionPerformed

    public String addEntry(String what) {
        String message = "Record added\n";
        System.out.println("Adding "+what+" entry to the records");
        String n = name.getText();
        int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());
        float km = java.lang.Float.parseFloat(dist.getText());
        int h = Integer.parseInt(hours.getText());
        int mm = Integer.parseInt(mins.getText());
        int s = Integer.parseInt(secs.getText());
        Entry e = new Entry(n, d, m, y, h, mm, s, km);
        myAthletes.addEntry(e);
        return message;
    }//addEntry
    public String addSwimEntry(String what) {
        String message = "Record added\n";
        System.out.println("Adding "+what+" entry to the records");
        String n = name.getText();
        int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());
        float km = java.lang.Float.parseFloat(dist.getText());
        int h = Integer.parseInt(hours.getText());
        int mm = Integer.parseInt(mins.getText());
        int s = Integer.parseInt(secs.getText());
        String whr = where.getText();
        Entry e = new SwimEntry(n, d, m, y, h, mm, s, km, whr);
        myAthletes.addEntry(e);
        return message;
    }//addSwimEntry
    public String addCycleEntry(String what) {
        String message = "Record added\n";
        System.out.println("Adding "+what+" entry to the records");
        String n = name.getText();
        int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());
        float km = java.lang.Float.parseFloat(dist.getText());
        int h = Integer.parseInt(hours.getText());
        int mm = Integer.parseInt(mins.getText());
        int s = Integer.parseInt(secs.getText());
        String ter = terrain.getText();
        String tmpo = tempo.getText();
        Entry e = new CycleEntry(n, d, m, y, h, mm, s, km, ter, tmpo);
        myAthletes.addEntry(e);
        return message;
    }//addCycleEntry
    public String addSprintEntry(String what) {
        String message = "Record added\n";
        System.out.println("Adding "+what+" entry to the records");
        String n = name.getText();
        int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());
        float km = java.lang.Float.parseFloat(dist.getText());
        int h = Integer.parseInt(hours.getText());
        int mm = Integer.parseInt(mins.getText());
        int s = Integer.parseInt(secs.getText());
        int recov = Integer.parseInt(recovery.getText());
        int repetitions = Integer.parseInt(repetition.getText());
        Entry e = new SprintEntry(n, d, m, y, h, mm, s, km, recov, repetitions);
        myAthletes.addEntry(e);
        return message;
    }//addSprintEntry

    public String lookupEntry() {
        int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());
        outputArea.setText("looking up record ...");
        String message = myAthletes.lookupEntry(d, m, y);
        return message;
    } //lookupEntry

    public String lookupAllEntries() {
        int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());
        outputArea.setText("looking up records ...");
        String message = myAthletes.lookupAllEntries(d, m, y);
        return message;
    } //lookupAllEntries

    public void removeElement(){
        String n = name.getText();
        int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());
        outputArea.setText("Removing record ...");
        //myAthletes.removeElement(n,d,m,y);
    } //removeElement

    public void blankDisplay() {
        name.setText("");
        day.setText("");
        month.setText("");
        year.setText("");
        hours.setText("");
        mins.setText("");
        secs.setText("");
        dist.setText("");
        terrain.setText("");
        tempo.setText("");
        repetition.setText("");
        recovery.setText("");
        where.setText("");
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
        terrain.setText(String.valueOf(((CycleEntry)ent).getTerrain()));
        tempo.setText(String.valueOf(((CycleEntry)ent).getTempo()));
        repetition.setText(String.valueOf(((SprintEntry)ent).getRepetitions()));
        recovery.setText(String.valueOf(((SprintEntry)ent).getRecovery()));
        where.setText(String.valueOf(((SwimEntry)ent).getWhere()));
    }

} // TrainingRecordGUI

