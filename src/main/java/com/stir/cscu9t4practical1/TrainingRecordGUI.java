// GUI and main program for the Training Record
package com.stir.cscu9t4practical1;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
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
    private JButton findAllByDate = new JButton("Find All By Date");

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
            message = addEntry("generic");
        }
        if (event.getSource() == lookUpByDate) {
            message = lookupEntry();
        }
        if (event.getSource() == findAllByDate)
        {
            message = findAllByDate();
        }
        outputArea.setText(message);
        blankDisplay();
    } // actionPerformed

    public String addEntry(String what)
    {
        String message;
        String inputErrorMessage = isInputSafe();

        if (inputErrorMessage.equals(""))
        {
            message = "Record added\n";
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
            myAthletes.addEntry(e);        }
        else
        {
            message = inputErrorMessage;
        }

        return message;
    }
    
    public String lookupEntry()
    {
        String message;
        String inputErrorMessage = isInputSafe();

        if (inputErrorMessage.equals("")) {
            int m = Integer.parseInt(month.getText());
            int d = Integer.parseInt(day.getText());
            int y = Integer.parseInt(year.getText());
            outputArea.setText("looking up record ...");
            message = myAthletes.lookupEntry(d, m, y);
        }
        else
        {
            message = inputErrorMessage;
        }
        return message;
    }

    public String findAllByDate()
    {
        String message;
        String inputErrorMessages = isInputSafe();

        if (inputErrorMessages.equals(""))
        {
            int m = Integer.parseInt(month.getText());
            int d = Integer.parseInt(day.getText());
            int y = Integer.parseInt(year.getText());
            outputArea.setText("looking up record ...");
            message = myAthletes.findAllByDate(d, m, y);
        }
        else
        {
            message = inputErrorMessages;
        }

        return message;
    }

    private String isInputSafe()
    {
        InputChecker inputChecker = new InputChecker();
        String result = "";

        if (!inputChecker.isNameSafe(name.getText()))
        {
            result += "Please check that you have put a valid entry in the day field.\n";
        }

        if (!inputChecker.isDaySafe(day.getText()))
        {
            result += "Please check that you have put a valid number in the Day field.\n";
        }

        if (!inputChecker.isMonthSafe(month.getText()))
        {
            result += "Please check that you have put a valid number in the Month field.\n";
        }

        if (!inputChecker.isYearSafe(year.getText()))
        {
            result += "Please check that you have put a valid number in the Year field.\n";
        }

        if (!inputChecker.isHourSafe(hours.getText()))
        {
            result += "Please check that you have put a valid number in the Hours field.\n";
        }

        if (!inputChecker.isMinuteSafe(mins.getText()))
        {
            result += "Please check that you have put a valid number in the Minutes field.\n";
        }

        if (!inputChecker.isSecondSafe(secs.getText()))
        {
            result += "Please check that you have put a valid number in the Seconds field.\n";
        }

        if (!inputChecker.isDistanceSafe(dist.getText()))
        {
            result += "Please check that you have put a valid number in the Distance field.\n";
        }

        return result;
    }   //isInputSafe


    public void blankDisplay() {
        name.setText("");
        day.setText("");
        month.setText("");
        year.setText("");
        hours.setText("");
        mins.setText("");
        secs.setText("");
        dist.setText("");
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

