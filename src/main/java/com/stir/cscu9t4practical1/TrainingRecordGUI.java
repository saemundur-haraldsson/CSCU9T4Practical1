// GUI and main program for the Training Record
package com.stir.cscu9t4practical1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

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
    private JComboBox typeOfExerciseDropDown = new JComboBox(EnumExerciseType.values());

    private JLabel cyclingSurfaceLabel = new JLabel(" Surface type: ");
    private JTextField cyclingSurfaceType = new JTextField(15);

    private JLabel cyclingRouteLabel = new JLabel(" Route difficulty: ");
    private JTextField cyclingRouteDifficulty = new JTextField(15);

    private JLabel sprintingRepsLabel = new JLabel(" Repetitions: ");
    private JTextField sprintingRepetitions = new JTextField(3);

    private JLabel sprintingRecoveryLabel = new JLabel(" Recovery: ");
    private JTextField sprintingRecovery = new JTextField(3);

    private JLabel swimmingLocationLabel = new JLabel(" Location: ");
    private JTextField swimmingLocation = new JTextField(15);

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

        add(typeOfExerciseDropDown);
        typeOfExerciseDropDown.setSelectedIndex(0);
        typeOfExerciseDropDown.addActionListener(this);

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

        add(cyclingSurfaceLabel);
        add(cyclingSurfaceType);
        cyclingSurfaceType.setEditable(true);
        cyclingSurfaceType.setEnabled(true);

        add(cyclingRouteLabel);
        add(cyclingRouteDifficulty);
        cyclingRouteDifficulty.setEditable(true);
        cyclingRouteDifficulty.setEnabled(true);

        add(sprintingRepsLabel);
        add(sprintingRepetitions);
        sprintingRepetitions.setEditable(true);
        sprintingRepetitions.setEnabled(false);

        add(sprintingRecoveryLabel);
        add(sprintingRecovery);
        sprintingRecovery.setEditable(true);
        sprintingRecovery.setEnabled(false);

        add(swimmingLocationLabel);
        add(swimmingLocation);
        swimmingLocation.setEditable(true);
        swimmingLocation.setEnabled(false);

        add(lookUpByDate);
        lookUpByDate.addActionListener(this);
        lookUpByDate.setEnabled(false);

        add(findAllByDate);
        findAllByDate.addActionListener(this);
        findAllByDate.setEnabled(false);

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
        if (event.getSource() == typeOfExerciseDropDown)
        {
            message = "";

            setUpDisplayForDifferentExerciseTypes();
        }
        outputArea.setText(message);
        blankDisplay();
    } // actionPerformed

    private void setUpDisplayForDifferentExerciseTypes()
    {
        if (typeOfExerciseDropDown.getSelectedItem().equals(EnumExerciseType.Cycling))
        {
            setEnablingForGUIComponents(true, true, false, false, false);
        }
        else if (typeOfExerciseDropDown.getSelectedItem().equals(EnumExerciseType.Running))
        {
            setEnablingForGUIComponents(false, false,true, true, false);
        }
        else
        {
            setEnablingForGUIComponents(false, false, false, false, true);
        }
    }

    private void setEnablingForGUIComponents(boolean cyclingRouteDifficulty, boolean cyclingSurfaceType, boolean sprintingRepetitions, boolean sprintingRecovery, boolean swimmingLocation)
    {
        this.cyclingRouteDifficulty.setEnabled(cyclingRouteDifficulty);
        this.cyclingSurfaceType.setEnabled(cyclingSurfaceType);
        this.sprintingRepetitions.setEnabled(sprintingRepetitions);
        this.sprintingRecovery.setEnabled(sprintingRecovery);
        this.swimmingLocation.setEnabled(swimmingLocation);
    }

    public String addEntry(String what)
    {
        String message;
        int numberOfEntriesAtStart = myAthletes.getNumberOfEntries();

        System.out.println("Adding "+what+" entry to the records");
        message = myAthletes.addEntry(getExerciseTypeFromDropDown(), name.getText(), day.getText(), month.getText(), year.getText(), hours.getText(), mins.getText(), secs.getText(), dist.getText(), cyclingSurfaceType.getText(), cyclingRouteDifficulty.getText(), sprintingRepetitions.getText(), sprintingRecovery.getText(), swimmingLocation.getText());

        if ((numberOfEntriesAtStart != myAthletes.getNumberOfEntries()) && !lookUpByDate.isEnabled())  //Check to see if an entry has actually been added, and if the buttons for looking up entries are disabled.
        {
            lookUpByDate.setEnabled(true);  //Enable buttons for looking up entries.
            findAllByDate.setEnabled(true);
        }

        return message;
    }   //addEntry

    private EnumExerciseType getExerciseTypeFromDropDown()
    {
        return (EnumExerciseType) typeOfExerciseDropDown.getSelectedItem();
    }

    public String lookupEntry()
    {
        return myAthletes.lookupEntry(day.getText(), month.getText(), year.getText());
    }   //lookupEntry

    public String findAllByDate()
    {
        return myAthletes.findAllByDate(day.getText(), month.getText(), year.getText());
    }   //findAllByDate

    public void blankDisplay() {
        name.setText("");
        day.setText("");
        month.setText("");
        year.setText("");
        hours.setText("");
        mins.setText("");
        secs.setText("");
        dist.setText("");
        cyclingSurfaceType.setText("");
        cyclingRouteDifficulty.setText("");
        sprintingRepetitions.setText("0");
        sprintingRecovery.setText("0");
        swimmingLocation.setText("");
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

