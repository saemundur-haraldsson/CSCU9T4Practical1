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
    private JTextField terr = new JTextField(6);
    private JTextField tem = new JTextField(6);
    private JTextField rep = new JTextField(2);
    private JTextField rec = new JTextField(2);
    private JTextField loc = new JTextField(6);
    private JLabel labn = new JLabel(" Name:");
    private JLabel labd = new JLabel(" Day:");
    private JLabel labm = new JLabel(" Month:");
    private JLabel laby = new JLabel(" Year:");
    private JLabel labh = new JLabel(" Hours:");
    private JLabel labmm = new JLabel(" Mins:");
    private JLabel labs = new JLabel(" Secs:");
    private JLabel labdist = new JLabel("Distance (km):");
    private JLabel labterr = new JLabel(" Terrain (if cycle):");
    private JLabel labtem = new JLabel(" Tempo (if cycle):");
    private JLabel labrep = new JLabel(" Repetitions (if sprint):");
    private JLabel labrec = new JLabel(" Recovery time (mins, if sprint):");
    private JLabel labloc = new JLabel("Location (if swim):");
    private JButton addR = new JButton("Add");
    private JButton lookUpByDate = new JButton("Look Up");
    private JButton findAllByDate = new JButton("Find All By Date");
    private JButton findAllByName = new JButton("Find All By Name");

    private String[] options = {"Generic", "Cycle", "Sprint", "Swim"};
    private JComboBox<String> entryType = new JComboBox<>(options);

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
        add(labterr);
        add(terr);
        terr.setEditable(true);
        add(labtem);
        add(tem);
        tem.setEditable(true);
        add(labrep);
        add(rep);
        rep.setEditable(true);
        add(labrec);
        add(rec);
        rec.setEditable(true);
        add(labloc);
        add(loc);
        loc.setEditable(true);
        add(entryType);
        add(addR);
        addR.addActionListener(this);
        add(lookUpByDate);
        lookUpByDate.addActionListener(this);
        add(findAllByDate);
        findAllByDate.addActionListener(this);
        add(findAllByName);
        findAllByName.addActionListener(this);
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
            message = addEntry(entryType.getItemAt(entryType.getSelectedIndex()).toLowerCase());
        } else if (event.getSource() == lookUpByDate) {
            message = lookupEntry("single");
        } else if (event.getSource() == findAllByDate) {
            message = lookupEntry("all");
        } else if (event.getSource() == findAllByName) {
            message = lookupEntry("name");
        }
        outputArea.setText(message);
        blankDisplay();
    }

    /**
     * Adds a single entry to the record.
     */
    public String addEntry(String what) {
        String message = "Record added.\n";
        System.out.println("Attempting to add " + what + " entry to the records...");
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
                Entry e;
                switch (what) {
                    case "cycle":
                        String trn = terr.getText();
                        String tpo = tem.getText();
                        e = new CycleEntry(n, d, m, y, h, mm, s, km, trn, tpo);
                        break;
                    case "sprint":
                        int rpt = Integer.parseInt(rep.getText());
                        int rcv = Integer.parseInt(rec.getText());
                        e = new SprintEntry(n, d, m, y, h, mm, s, km, rpt, rcv);
                        break;
                    case "swim":
                        String lcn = loc.getText();
                        e = new SwimEntry(n, d, m, y, h, mm, s, km, lcn);
                        break;
                    default:
                        e = new Entry(n, d, m, y, h, mm, s, km);
                }
                if (!myAthletes.addEntry(e)) {
                    message = "Could not add duplicate record.";
                }
            } catch (NumberFormatException e) {
                message = "Error: Please provide valid, non-null numbers in the numerical fields.";
            }
        }
        return message;
    }

    /**
     * Looks up a single entry by date.
     */
    public String lookupEntry(String type) {
        outputArea.setText("Looking up record(s)...");
        try {
            if (type.equals("all") || type.equals("single")) {
                int m = Integer.parseInt(month.getText());
                int d = Integer.parseInt(day.getText());
                int y = Integer.parseInt(year.getText());
                if (type.equals("all")) {
                    return myAthletes.lookupEntries(d, m, y);
                } else {
                    return myAthletes.lookupEntry(d, m, y);
                }
            } else {
                String nameToFind = name.getText();
                if (nameToFind.length() == 0) {
                    return "Error: Please provide a non-null value for the name.";  // avoid returning all records
                } else {
                    return myAthletes.lookupByName(nameToFind);
                }
            }
        } catch (NumberFormatException e) {
            return "Error: Please provide valid, non-null numbers in the numerical fields.";
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
        terr.setText("");
        tem.setText("");
        rep.setText("");
        rec.setText("");
        loc.setText("");
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

