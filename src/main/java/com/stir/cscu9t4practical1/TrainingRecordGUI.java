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

    /**
     * Main method; program entry-point.
     */
    public static void main(String[] args) {
        TrainingRecordGUI applic = new TrainingRecordGUI();
    }

    /**
     * Constructor for the GUI; set up text areas, labels, buttons, etc.
     */
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

    }

    /**
     * Listen for and respond to GUI events.
     */
    public void actionPerformed(ActionEvent event) {
        String message = "";
        if (event.getSource() == addR) {
            message = addEntry("generic");
        }
        if (event.getSource() == lookUpByDate) {
            message = lookupEntry("single");
        }
        if (event.getSource() == findAllByDate) {
            message = lookupEntry("all");
        }
        outputArea.setText(message);
        blankDisplay();
    }

    /**
     * Adds a single entry to the record.
     */
    public String addEntry(String what) {
        String message = "Record added\n";
        System.out.println("Adding " + what + " entry to the records");
        String n = name.getText();
        if (n.length() == 0) {
            message = "Error: Name cannot be empty.";
        } else {
            try {
                int m = Integer.parseInt(month.getText());
                int d = Integer.parseInt(day.getText());
                int y = Integer.parseInt(year.getText());
                float km = java.lang.Float.parseFloat(dist.getText());
                int h = Integer.parseInt(hours.getText());
                int mm = Integer.parseInt(mins.getText());
                int s = Integer.parseInt(secs.getText());
                Entry e = new Entry(n, d, m, y, h, mm, s, km);
                myAthletes.addEntry(e);
            } catch (NumberFormatException e) {
                message = "Error: Please provide valid numbers in the numerical fields; they cannot be empty.";
            }
        }
        return message;
    }

    /**
     * Looks up a single entry by date.
     */
    public String lookupEntry(String type) {
        try {
            int m = Integer.parseInt(month.getText());
            int d = Integer.parseInt(day.getText());
            int y = Integer.parseInt(year.getText());
            outputArea.setText("Looking up record ...");
            if (type.equals("all")) {
                return myAthletes.findAllByDate(d, m, y);
            } else {
                return myAthletes.lookupEntry(d, m, y);
            }
        } catch (NumberFormatException e) {
            return "NumberFormatException: Could not parse a text field input to a number.";
        }
    }

    /**
     * Blanks all input fields.
     */
    public void blankDisplay() {
        name.setText("");
        day.setText("");
        month.setText("");
        year.setText("");
        hours.setText("");
        mins.setText("");
        secs.setText("");
        dist.setText("");
    }

    /**
     * Fills the input fields on the display; for testing purposes only.
     */
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
}

