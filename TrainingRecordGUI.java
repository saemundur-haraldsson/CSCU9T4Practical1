// GUI and main program for the Training Record
package com.stir.cscu9t4practical1;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.lang.Number;
import java.awt.Dialog;
public class TrainingRecordGUI extends JFrame implements ActionListener {

    private JTextField name = new JTextField(30);
    private JTextField day = new JTextField(2);
    private JTextField month = new JTextField(2);
    private JTextField year = new JTextField(4);
    private JTextField hours = new JTextField(2);
    private JTextField mins = new JTextField(2);
    private JTextField secs = new JTextField(2);
    private JTextField dist = new JTextField(4);
    private JTextField type = new JTextField(10);
    private JLabel labn = new JLabel(" Name:");
    private JLabel labd = new JLabel(" Day:");
    private JLabel labm = new JLabel(" Month:");
    private JLabel laby = new JLabel(" Year:");
    private JLabel labh = new JLabel(" Hours:");
    private JLabel labmm = new JLabel(" Mins:");
    private JLabel labs = new JLabel(" Secs:");
    private JLabel labtype = new JLabel(" Type:");
    private JLabel labdist = new JLabel(" Distance (km):");
    private JButton addR = new JButton("Add");
    private JButton lookUpByDate = new JButton("Look Up");
    private JButton findAllByDate = new JButton("Find All");
    private JButton removeEntry = new JButton("Remove Entry");

    private TrainingRecord myAthletes = new TrainingRecord();

    private JTextArea outputArea = new JTextArea(5, 50);

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
        add(labtype);
        add(type);
        type.setEditable(true);
        add(addR);
        addR.addActionListener(this);
        
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
        if (event.getSource() == findAllByDate) {
            // to do
            message = findAllByDate();
        }
        if (event.getSource() == removeEntry) {
            // to do
            
            
        
            message = removeEntry();
            int b = myAthletes.getNumberOfEntries();
            
            if (b == 0){
            System.out.println("working");
            lookUpByDate.setEnabled(false);
            findAllByDate.setEnabled(false);
            removeEntry.setEnabled(false);
        }
        }
        outputArea.setText(message);
        blankDisplay();
    } // actionPerformed

    public String addEntry(String what) {
        
        String n = name.getText();
        int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());
        float km = java.lang.Float.parseFloat(dist.getText());
        int h = Integer.parseInt(hours.getText());
        int mm = Integer.parseInt(mins.getText());
        int s = Integer.parseInt(secs.getText());
        String input = type.getText();
        boolean a = myAthletes.duplicate(d, m, y, n);
        if (a == true){
            String message = "Duplicate record";
            return message;
        }
        String message = "Record added\n";
        System.out.println("Adding "+what+" entry to the records");
        
    
        if ("Sprint".equals(input) || "sprint".equals(input)){
            int rep = Integer.parseInt(JOptionPane.showInputDialog("Enter the repetitions: "));
            int rec = Integer.parseInt(JOptionPane.showInputDialog("Enter the recovery: "));
                    
            Entry e = new SprintEntry(n, d, m, y, h, mm, s, km, rep, rec);
            myAthletes.addEntry(e);
            return message;
        }
        if ("Cycle".equals(input) || "cycle".equals(input)){
            String temp = JOptionPane.showInputDialog("Enter the tempo: ");
            String ter = JOptionPane.showInputDialog("Enter the terrain: ");
            Entry e = new CycleEntry(n, d, m, y, h, mm, s, km, ter, temp);
            myAthletes.addEntry(e);
            return message;
        }
        if ("Swim".equals(input) || "swim".equals(input)){
            String loc = JOptionPane.showInputDialog("Location: ");
            
            Entry e = new SwimEntry(n, d, m, y, h, mm, s, km, loc);
            myAthletes.addEntry(e);
            return message;
        }
        else {
            message = "Error";
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
    public String findAllByDate() {
        int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());
        outputArea.setText("looking up record ...");
        String message = myAthletes.findAllByDate(d, m, y);
        
        return message;
    }
    public String removeEntry(){
        int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());
        String n = name.getText();
        outputArea.setText("Checking if record exists...");
        String message = myAthletes.removeEntry(d, m, y, n);
        
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
        type.setText("");
        int b = myAthletes.getNumberOfEntries();
        
        if (b != 0){
        
        
        add(lookUpByDate);
        
        
        
        

        lookUpByDate.addActionListener(this);
        add(findAllByDate);
        findAllByDate.addActionListener(this);
        removeEntry.addActionListener(this);
        add(removeEntry);
        
        
        }
        
        

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

