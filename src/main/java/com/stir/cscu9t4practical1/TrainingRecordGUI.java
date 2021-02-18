// GUI and main program for the Training Record
package com.stir.cscu9t4practical1;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.JButton;
import java.lang.Number;

import static java.awt.Color.*;


public class TrainingRecordGUI extends JFrame implements ActionListener {

    private JTextField name = new JTextField(30);
    private JTextField day = new JTextField(2);
    private JTextField month = new JTextField(2);
    private JTextField year = new JTextField(4);
    private JTextField hours = new JTextField(2);
    private JTextField mins = new JTextField(2);
    private JTextField secs = new JTextField(2);
    private JTextField dist = new JTextField(4);
    private JTextField where = new JTextField(30); //////////////////////////
    private JTextField terrain = new JTextField(30); /////////////////////
    private JTextField tempo = new JTextField(30); /////////////////////
    private JTextField reps = new JTextField(2); /////////////////////
    private JTextField recov = new JTextField(3); /////////////////////

    private JLabel labn = new JLabel(" Name:");
    private JLabel labd = new JLabel(" Day:");
    private JLabel labm = new JLabel(" Month:");
    private JLabel laby = new JLabel(" Year:");
    private JLabel labh = new JLabel(" Hours:");
    private JLabel labmm = new JLabel(" Mins:");
    private JLabel labs = new JLabel(" Secs:");
    private JLabel labdist = new JLabel(" Distance (km):");
    private JLabel labterr = new JLabel(" Terrain:"); //////////////////////////////
    private JLabel labtempo = new JLabel(" Tempo:"); ////////////////////////////
    private JLabel labreps = new JLabel(" Repetitions:"); ////////////////////////////
    private JLabel labrecov = new JLabel(" Recovery:"); ///////////////////////
    private JLabel labwhere = new JLabel(" Where(outdoor or pool):"); ///////////////
    String[] trainingType = {"Swim", "Sprint", "Cycle"};
    private JComboBox <String> TrainingType = new JComboBox(trainingType);

    private JButton addR = new JButton("Add");
    //addR.setBackground(00FF00);
    private JButton lookUpByDate = new JButton("Look Up");
    private JButton removeEntry = new JButton("Remove Entry"); /////////////////////////
    //removeEntry.setBackground(FF0000);

    private JButton findAllByDate = new JButton("Find by Date"); /////////////////////////////////



    private TrainingRecord myAthletes = new TrainingRecord();


////////////////////////////////////////////////////////////
    final ImageIcon imageIcon = new ImageIcon("https://live.staticflickr.com/3030/3069798182_255541cbcc_b.jpg");

    private JTextArea outputArea = new JTextArea(5, 50)// {
        //Image image = imageIcon.getImage();
        //Image grayImage = GrayFilter.createDisabledImage(image);
        //{
        //    setOpaque(false);
        //}
    ;

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
        add(labwhere); ////////////////////////////////////////////////////////
        add(where);
        where.setEditable(true);
        add(labterr);
        add(terrain);
        terrain.setEditable(true);
        add(labtempo);
        add(tempo);
        tempo.setEditable(true);
        add(labreps);
        add(reps);
        reps.setEditable(true);
        add(labrecov);
        add(recov);
        recov.setEditable(true);

        add(addR);
        addR.addActionListener(this);
        add(lookUpByDate);
        lookUpByDate.addActionListener(this);
        add(outputArea);
        outputArea.setEditable(false);

        add(findAllByDate); ///////////////////////////////////////////////////////////////////
        findAllByDate.addActionListener(this); /////////////////////////////////////////////
        add(TrainingType);
        TrainingType.addActionListener(this);
        add(removeEntry);
        removeEntry.addActionListener(this);

        setSize(720, 200);
        setVisible(true);
        blankDisplay();

        removeEntry.setBackground(RED);
        addR.setBackground(GREEN);
        outputArea = new JTextArea(5, 50) {
            Image image = imageIcon.getImage();
            //Image grayImage = GrayFilter.createDisabledImage(image);
            //{
            //    setOpaque(false);
            //}
        };
        // To save typing in new entries while testing, uncomment
        // the following lines (or add your own test cases)
        
    } // constructor

    // listen for and respond to GUI events 
    public void actionPerformed(ActionEvent event) {
        String message = " ";

        String selectedTraining = (String) TrainingType.getSelectedItem(); //////////////////////////////////


        if (message.equals(" ")) { ////////////////////////////////////////////////////////////////////
            outputArea.setText("Not implemented yet.");
        }

        if (event.getSource() == addR) {
            if (selectedTraining.equals("Swim")) {
                message = addSwimEntry("generic");
            }
            else if (selectedTraining.equals("Sprint")) {
                message = addSprintEntry("generic");
            }
            else if (selectedTraining.equals("Cycle")) {
                message = addCycleEntry("generic");
            }
        }
        if (event.getSource() == lookUpByDate) {
            message = lookupEntry();
        }

        if (event.getSource() == findAllByDate) { //////////////////////////////////////////////////
            message = lookUpEntries().toString().replaceAll("\\[", "").replaceAll("\\]", "/n").replaceAll("\\, ", "");
        }

        if (event.getSource() == removeEntry) {
            RemoveEntry();
            message = "Entry removed.";
        }

        outputArea.setText(message);
        blankDisplay();
    } // actionPerformed

    public String addSwimEntry(String what) { ////////////////////////////////////////////////////////
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
        String wh;
        if (where.getText().equals("pool")) {
            wh = "in a " + where.getText();
        }
        else {
            wh = where.getText();
        }
        SwimEntry e = new SwimEntry(n, d, m, y, h, mm, s, km, wh);
        myAthletes.addEntry(e);
        return message;
    }

    public String addSprintEntry(String what) { ////////////////////////////////////////////////////////////
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
        int rep = Integer.parseInt(reps.getText());
        float rec = java.lang.Float.parseFloat(recov.getText());
        Entry e = new SprintEntry(n, d, m, y, h, mm, s, km, rep, rec);
        myAthletes.addEntry(e);
        return message;
    }

    public String addCycleEntry(String what) { /////////////////////////////////////////////////
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
        String temp = tempo.getText();
        Entry e = new CycleEntry(n, d, m, y, h, mm, s, km, ter, temp);
        myAthletes.addEntry(e);
        return message;
    }
    
    public String lookupEntry() {
        int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());
        outputArea.setText("looking up record ...");
        String message = myAthletes.lookupEntry(d, m, y);
        return message;
    }

    public LinkedList<String> lookUpEntries() { /////////////////////////////////////////////////////////////
        int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());
        outputArea.setText("looking up records ...");
        LinkedList<String> message = myAthletes.lookUpEntries(d, m, y);
        return message;
    }

    public void RemoveEntry() { //////////////////////////////////////////////////
        int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());
        String n = name.getText();
        outputArea.setText("clearing record ...");
        myAthletes.RemoveEntry(d, m, y, n);
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

