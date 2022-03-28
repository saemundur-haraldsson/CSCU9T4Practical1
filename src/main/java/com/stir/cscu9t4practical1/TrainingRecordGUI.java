// GUI and main program for the Training Record
package com.stir.cscu9t4practical1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class TrainingRecordGUI extends JFrame implements ActionListener {

    private JTextField name = new JTextField(30);
    private JTextField day = new JTextField(2);
    private JTextField month = new JTextField(2);
    private JTextField year = new JTextField(4);
    private JTextField hours = new JTextField(2);
    private JTextField mins = new JTextField(2);
    private JTextField secs = new JTextField(2);
    private JTextField dist = new JTextField(4);

    private JTextField terrain = new JTextField(6);
    private JTextField tempo = new JTextField(6);
    private JTextField repititions = new JTextField(3);
    private JTextField recovery = new JTextField(2);
    private JTextField where = new JTextField(5);

    private String[] excerciseType = {"Choose Excercise: ", "Sprint", "Swim", "Cycle"};
    private JComboBox menu = new JComboBox<String>(excerciseType);

    private JLabel labn = new JLabel(" Name:");
    private JLabel labd = new JLabel(" Day:");
    private JLabel labm = new JLabel(" Month:");
    private JLabel laby = new JLabel(" Year:");
    private JLabel labh = new JLabel(" Hours:");
    private JLabel labmm = new JLabel(" Mins:");
    private JLabel labs = new JLabel(" Secs:");
    private JLabel labdist = new JLabel(" Distance (km):");

    private JLabel labterrain = new JLabel(" Terrain:");
    private JLabel labtempo = new JLabel(" Tempo:");
    private JLabel labrep = new JLabel(" Repititions:");
    private JLabel labreco = new JLabel(" Recovery:");
    private JLabel labwhe = new JLabel(" Where:");

    private JButton addR = new JButton("Add");
    private JButton lookUpByDate = new JButton("Look Up");
    private JButton findAllByDate = new JButton("Find All By Date");
    private JButton findAllByName = new JButton("Find All By Name");
    private JButton weeklyDistance = new JButton("Weekly Distance");
    private JButton remove = new JButton("Remove");


    private TrainingRecord myAthletes = new TrainingRecord();

    private JTextArea outputArea = new JTextArea(5, 50);

    private boolean hasAlreadyRan = false;

    // set up the GUI
    public TrainingRecordGUI() {
        super("Training Record");
        setLayout(new FlowLayout());
        add(menu);
        menu.addActionListener(this);
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
        add(labterrain);
        add(terrain);
        terrain.setEditable(true);
        labterrain.setVisible(false);
        terrain.setVisible(false);
        add(labtempo);
        add(tempo);
        tempo.setEditable(true);
        labtempo.setVisible(false);
        tempo.setVisible(false);
        add(labrep);
        add(repititions);
        repititions.setEditable(true);
        labrep.setVisible(false);
        repititions.setVisible(false);
        add(labreco);
        add(recovery);
        recovery.setEditable(true);
        labreco.setVisible(false);
        repititions.setVisible(false);
        add(labwhe);
        add(where);
        labwhe.setVisible(false);
        where.setVisible(false);
        add(addR);
        addR.addActionListener(this);
        add(lookUpByDate);
        lookUpByDate.addActionListener(this);
        add(remove);
        remove.addActionListener(this);
        remove.setEnabled(false);
        add(findAllByDate);
        findAllByDate.addActionListener(this);
        findAllByDate.setEnabled(false);
        add(findAllByName);
        findAllByName.addActionListener(this);
        findAllByName.setEnabled(false);
        add(weeklyDistance);
        weeklyDistance.addActionListener(this);
        weeklyDistance.setEnabled(false);
        add(outputArea);
        outputArea.setEditable(false);
        setSize(720, 200);
        setVisible(true);
        blankDisplay();

        // To save typing in new entries while testing, uncomment
        // the following lines (or add your own test cases)

    } // constructor

    public static void main(String[] args) {

        TrainingRecordGUI applic = new TrainingRecordGUI();

        //Uncomment below to test
        /* Cycle cycle = new Cycle("Jerry",3,1,2,2,3,2,1,"asphalt","moderate");
           applic.setMenuValue(1);
           applic.fillDisplay(cycle);
           applic.addEntry("generic");
        */

        /* SwimEntry swim = new SwimEntry("Jerry",3,1,2,2,3,2,30,"pool");
           applic.setMenuValue(2);
           applic.fillDisplay(swim);
           applic.addEntry("generic");
        */

        /* Sprint sprint = new SwimEntry("Jerry",8,1,2,2,3,2,3,8,2);
           applic.setMenuValue(3);
           applic.fillDisplay(sprint);
           applic.addEntry("generic");
        */


    } // main

    //checks if the date is in correct format
    public static boolean isDateValid(String date) {
        try {
            DateFormat d = new SimpleDateFormat("dd/MM/yyyy");
            d.setLenient(false);
            d.parse(date);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // listen for and respond to GUI events
    public void actionPerformed(ActionEvent event) {
        String message = "";
        if (event.getSource() == addR) {
            message = addEntry("generic");
            if (!hasAlreadyRan && !message.equals("Error Occured") && !message.equals("Date in wrong format")
                    && !message.equals("Please choose your excercise")
                    && !message.contains("No duplicate entries!")) {
                remove.setEnabled(true);
                lookUpByDate.setEnabled(true);
                findAllByName.setEnabled(true);
                findAllByDate.setEnabled(true);
                weeklyDistance.setEnabled(true);
                hasAlreadyRan = true;
            }
        }
        if (event.getSource() == lookUpByDate) {
            message = lookupEntry();
        }
        if (event.getSource() == remove) {
            message = removeEntry();
        }
        if (event.getSource() == findAllByDate) {
            message = lookUpAllEntries();
        }
        if (event.getSource() == findAllByName) {
            message = findAllByName();
        }
        if (event.getSource() == weeklyDistance) {
            message = getWeeklyDistance();
        }
        //Shows the correct field of certain excercise chosen
        if (event.getSource() == menu) {
            //checks that an exercise type is selected
            if (!isActivitySelected()) {
                message = "Select an excercise using the menu";
            }

            //checks that an entry has been added
            if (hasAlreadyRan) {
                //Sets the buttons to enabled when they can be used
                remove.setEnabled(true);
                lookUpByDate.setEnabled(true);
                findAllByName.setEnabled(true);
                findAllByDate.setEnabled(true);
                weeklyDistance.setEnabled(true);
            }

            //Show fields depending on the excercise type chosen
            if (menu.getSelectedItem().equals("Cycle")) {
                setVisibleFalse("Cycle");
                setVisibleTrue("Cycle");
            } else if (menu.getSelectedItem().equals("Swim")) {
                setVisibleFalse("Swim");
                setVisibleTrue("Swim");
            } else if (menu.getSelectedItem().equals("Sprint")) {
                setVisibleFalse("Sprint");
                setVisibleTrue("Sprint");
            }
        }
        outputArea.setText(message);
        blankDisplay();
    } // actionPerformed

    //calculates weekly distance for a name given a certain date
    private String getWeeklyDistance() {
        try {

            String n = name.getText().toUpperCase();
            String month1 = month.getText();
            String day1 = day.getText();
            String year1 = year.getText();

            if (n == null || n.trim().isEmpty()
                    || month1 == null || month1.trim().isEmpty()
                    || day1 == null || day1.trim().isEmpty()
                    || year1 == null || year1.trim().isEmpty()) {
                throw new Exception();
            }

            int m = Integer.parseInt(month1);
            int d = Integer.parseInt(day1);
            int y = Integer.parseInt(year1);

            if (!isDateValid(d + "/" + m + "/" + y)) {
                return "Enter a valid date";
            }

            String message = myAthletes.getWeeklyDistance(n, d, m, y);
            return message;
        } catch (Exception e) {
            return "Error occured";
        }
    }

    //sets the correct fields and labels as visible when they are needed depending on excercise
    private void setVisibleTrue(String excercise) {

        switch (excercise) {
            case "Cycle":
                labterrain.setVisible(true);
                terrain.setVisible(true);
                labtempo.setVisible(true);
                tempo.setVisible(true);
                break;
            case "Swim":
                labwhe.setVisible(true);
                where.setVisible(true);
                break;
            case "Sprint":
                labrep.setVisible(true);
                repititions.setVisible(true);
                labreco.setVisible(true);
                recovery.setVisible(true);
                break;
        }
    }

    //sets the correct fields and labels as hidden when they are not needed depending on excercise
    private void setVisibleFalse(String excercise) {

        switch (excercise) {
            case "Cycle":
                labrep.setVisible(false);
                repititions.setVisible(false);
                labreco.setVisible(false);
                recovery.setVisible(false);
                labwhe.setVisible(false);
                where.setVisible(false);
                break;
            case "Swim":
                labrep.setVisible(false);
                repititions.setVisible(false);
                labreco.setVisible(false);
                recovery.setVisible(false);
                labterrain.setVisible(false);
                terrain.setVisible(false);
                labtempo.setVisible(false);
                tempo.setVisible(false);
                break;
            case "Sprint":
                labterrain.setVisible(false);
                terrain.setVisible(false);
                labtempo.setVisible(false);
                tempo.setVisible(false);
                labwhe.setVisible(false);
                where.setVisible(false);
                break;
        }
    }

    //Checks if an activity has been selected
    private Boolean isActivitySelected() {
        if (menu.getSelectedItem().equals("Choose Excercise: ")) {
            return false;
        }
        return true;
    }

    //Removes an entry using user input
    public String removeEntry() {
        try {

            String n = name.getText().toUpperCase();
            String month1 = month.getText();
            String day1 = day.getText();
            String year1 = year.getText();

            if (n == null || n.trim().isEmpty()
                    || month1 == null || month1.trim().isEmpty()
                    || day1 == null || day1.trim().isEmpty()
                    || year1 == null || year1.trim().isEmpty()) {
                throw new Exception();
            }

            int m = Integer.parseInt(month1);
            int d = Integer.parseInt(day1);
            int y = Integer.parseInt(year1);

            String message = myAthletes.removeEntry(n, d, m, y);

            menu.setSelectedIndex(0);
            return message;
        } catch (Exception e) {
            return "Error occured";
        }
    }

    //Adds an entry using user input
    public String addEntry(String what) {
        try {

            if (!isActivitySelected()) {
                return "Select Excercise Type From Menu";
            }

            String message = "Record added\n";
            System.out.println("Adding " + what + " entry to the records");
            String n = name.getText().toUpperCase();
            String month1 = month.getText();
            String day1 = month.getText();
            String year1 = month.getText();
            String distance = dist.getText();
            String hour = hours.getText();
            String min = mins.getText();
            String sec = secs.getText();
            String terr = terrain.getText();
            String temp = tempo.getText();
            String rep = repititions.getText();
            String rec = recovery.getText();
            String whe = where.getText();

            if (n == null || n.trim().isEmpty()
                    || month1 == null || month1.trim().isEmpty()
                    || day1 == null || day1.trim().isEmpty()
                    || year1 == null || year1.trim().isEmpty()
                    || distance == null || distance.trim().isEmpty()
                    || hour == null || hour.trim().isEmpty()
                    || min == null || min.trim().isEmpty()
                    || sec == null || sec.trim().isEmpty()) {
                throw new Exception();
            }

            int m = Integer.parseInt(month1);
            int d = Integer.parseInt(day1);
            int y = Integer.parseInt(year1);
            float km = java.lang.Float.parseFloat(distance);
            int h = Integer.parseInt(hour);
            int mm = Integer.parseInt(min);
            int s = Integer.parseInt(sec);

            if (!isDateValid(d + "/" + m + "/" + y)) {
                return "Date not valid";
            }

            if (anyDuplicateEntries(n, d, m, y)) {
                return "No Duplicates Allowed\n" +
                        "This record exists with " +
                        "\nName:\t" + n +
                        "\nDay:\t" + d +
                        "\nMonth:\t" + m +
                        "\nYear:\t" + y;
            }

            switch (menu.getSelectedItem().toString()) {
                case "Cycle":
                    Cycle cycle = new Cycle(n, d, m, y, h, mm, s, km, terr, temp);
                    myAthletes.addEntry(cycle);
                    break;
                case "Swim":
                    SwimEntry swim = new SwimEntry(n, d, m, y, h, mm, s, km, whe);
                    myAthletes.addEntry(swim);
                    break;
                case "Sprint":
                    int reps = Integer.parseInt(rep);
                    int reco = Integer.parseInt(rec);
                    Sprint sprint = new Sprint(n, d, m, y, h, mm, s, km, reps, reco);
                    myAthletes.addEntry(sprint);
                    break;
            }
            menu.setSelectedIndex(0);
            return message;
        } catch (Exception e) {
            return "Something went wrong when adding entry";
        }

    }

    //returns boolean value given certain name,day,month and year
    public boolean anyDuplicateEntries(String name, int day, int month, int year) {
        try {
            outputArea.setText("Checking for duplicate records...");
            String message = myAthletes.checkForDuplicates(name, day, month, year);
            if (message.equals("No Entries found...")) {
                return false;
            }
            return true;
        } catch (Exception e) {
            outputArea.setText("Error occured when checking duplicate entries");
            return false;
        }
    }

    //Finds one record given a date
    public String lookupEntry() {
        int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());
        outputArea.setText("looking up record ...");
        String message = myAthletes.lookupEntry(d, m, y);
        return message;
    }

    //Finds all records given a date
    public String lookUpAllEntries() {
        try {
            int m = Integer.parseInt(month.getText());
            int d = Integer.parseInt(day.getText());
            int y = Integer.parseInt(year.getText());
            outputArea.setText("searching for entry...");
            String message = myAthletes.lookUpAllEntries(d, m, y);
            return message;
        } catch (Exception e) {
            return "Error occured when looking up entries";
        }
    }

    //Finds all records of a name
    public String findAllByName() {
        try {
            String n = name.getText();
            outputArea.setText("searching for entry...");
            String message = myAthletes.findAllEntriesByName(n);
            return message;
        } catch (Exception e) {
            return "Error occured when looking up entries";
        }
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
        terrain.setText("");
        tempo.setText("");
        where.setText("");
        repititions.setText("");
        recovery.setText("");

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

    public void fillDisplay(Sprint ent) {
        name.setText(ent.getName());
        day.setText(String.valueOf(ent.getDay()));
        month.setText(String.valueOf(ent.getMonth()));
        year.setText(String.valueOf(ent.getYear()));
        hours.setText(String.valueOf(ent.getHour()));
        mins.setText(String.valueOf(ent.getMin()));
        secs.setText(String.valueOf(ent.getSec()));
        dist.setText(String.valueOf(ent.getDistance()));
        repititions.setText(String.valueOf(ent.getRepititions()));
        recovery.setText(String.valueOf(ent.getRecovery()));
    }

    public void fillDisplay(Cycle ent) {
        name.setText(ent.getName());
        day.setText(String.valueOf(ent.getDay()));
        month.setText(String.valueOf(ent.getMonth()));
        year.setText(String.valueOf(ent.getYear()));
        hours.setText(String.valueOf(ent.getHour()));
        mins.setText(String.valueOf(ent.getMin()));
        secs.setText(String.valueOf(ent.getSec()));
        dist.setText(String.valueOf(ent.getDistance()));
        terrain.setText(String.valueOf(ent.getTerrain()));
        tempo.setText(String.valueOf(ent.getTempo()));
    }

    public void fillDisplay(SwimEntry ent) {
        name.setText(ent.getName());
        day.setText(String.valueOf(ent.getDay()));
        month.setText(String.valueOf(ent.getMonth()));
        year.setText(String.valueOf(ent.getYear()));
        hours.setText(String.valueOf(ent.getHour()));
        mins.setText(String.valueOf(ent.getMin()));
        secs.setText(String.valueOf(ent.getSec()));
        dist.setText(String.valueOf(ent.getDistance()));
        where.setText(String.valueOf(ent.getWhere()));
    }

    public void setMenuValue(int position) {
        menu.setSelectedIndex(position);
    }

} // TrainingRecordGUI

