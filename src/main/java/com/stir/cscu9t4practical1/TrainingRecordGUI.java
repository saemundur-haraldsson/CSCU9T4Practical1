// GUI and main program for the Training Record
package com.stir.cscu9t4practical1;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.lang.Number;

public class TrainingRecordGUI extends JFrame implements ActionListener {

    private final JTextField name = new JTextField(30);
    private final JTextField day = new JTextField(2);
    private final JTextField month = new JTextField(2);
    private final JTextField year = new JTextField(4);
    private final JTextField hours = new JTextField(2);
    private final JTextField mins = new JTextField(2);
    private final JTextField secs = new JTextField(2);
    private final JTextField dist = new JTextField(4);
    private final JTextField terr = new JTextField(6);
    private final JTextField tem = new JTextField(6);
    private final JTextField rep = new JTextField(2);
    private final JTextField rec = new JTextField(2);
    private final JTextField loc = new JTextField(6);
    private final JLabel labn = new JLabel(" Name:");
    private final JLabel labd = new JLabel(" Day:");
    private final JLabel labm = new JLabel(" Month:");
    private final JLabel laby = new JLabel(" Year:");
    private final JLabel labh = new JLabel(" Hours:");
    private final JLabel labmm = new JLabel(" Mins:");
    private final JLabel labs = new JLabel(" Secs:");
    private final JLabel labdist = new JLabel("Distance (km):");
    private final JLabel labterr = new JLabel(" Terrain (if cycle):");
    private final JLabel labtem = new JLabel(" Tempo (if cycle):");
    private final JLabel labrep = new JLabel(" Repetitions (if sprint):");
    private final JLabel labrec = new JLabel(" Recovery time (mins, if sprint):");
    private final JLabel labloc = new JLabel("Location (if swim):");
    private final JButton addR = new JButton("Add");
    private final JButton remove = new JButton("Remove");
    private final JButton lookUpByDate = new JButton("Look Up");
    private final JButton findAllByDate = new JButton("Find All By Date");
    private final JButton findAllByName = new JButton("Find All By Name");

    private final String[] options = {"Generic", "Cycle", "Sprint", "Swim"};
    private final JComboBox<String> entryType = new JComboBox<>(options);

    private final TrainingRecord myAthletes = new TrainingRecord();

    private final JTextArea outputArea = new JTextArea(5, 50);

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
        add(remove);
        remove.addActionListener(this);
        remove.setEnabled(false);
        add(lookUpByDate);
        lookUpByDate.addActionListener(this);
        lookUpByDate.setEnabled(false);
        add(findAllByDate);
        findAllByDate.addActionListener(this);
        findAllByDate.setEnabled(false);
        add(findAllByName);
        findAllByName.addActionListener(this);
        findAllByName.setEnabled(false);
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
     *
     * @param event The event that triggered the method.
     */
    public void actionPerformed(ActionEvent event) {
        String message = "";
        if (event.getSource() == addR) {
            message = addEntry(entryType.getItemAt(entryType.getSelectedIndex()).toLowerCase());
        } else if (event.getSource() == remove) {
            message = removeEntry();
        } else if (event.getSource() == lookUpByDate) {
            message = lookupEntry("single");
        } else if (event.getSource() == findAllByDate) {
            message = lookupEntry("all");
        } else if (event.getSource() == findAllByName) {
            message = lookupEntry("name");
        }
        if (myAthletes.getNumberOfEntries() > 0) {
            remove.setEnabled(true);
            lookUpByDate.setEnabled(true);
            findAllByDate.setEnabled(true);
            findAllByName.setEnabled(true);
        } else if (myAthletes.getNumberOfEntries() == 0) {
            remove.setEnabled(false);
            lookUpByDate.setEnabled(false);
            findAllByDate.setEnabled(false);
            findAllByName.setEnabled(false);
        }
        outputArea.setText(message);
        blankDisplay();
    }

    /**
     * Adds a single entry to the record.
     *
     * @param type The type of entry to be added.
     *
     * @return A status message.
     */
    public String addEntry(String type) {
        String message = "Record added.\n";
        System.out.println("Attempting to add " + type + " entry to the records...");
        String n = name.getText();
        if (n.length() == 0) {
            message = "Error: Name cannot be empty.\n";
        } else {
            try {
                // get universal values
                int m = Integer.parseInt(month.getText());
                int d = Integer.parseInt(day.getText());
                int y = Integer.parseInt(year.getText());
                float km = java.lang.Float.parseFloat(dist.getText());
                int h = Integer.parseInt(hours.getText());
                int mm = Integer.parseInt(mins.getText());
                int s = Integer.parseInt(secs.getText());
                Entry e;
                // get any type-specific values & instantiate entry
                switch (type) {
                    case "cycle":
                        String trn = terr.getText();
                        String tpo = tem.getText();
                        if (trn.length() + tpo.length() == 0) {
                            message = "Error: Terrain/Tempo cannot be empty.\n";
                        }
                        e = new CycleEntry(n, d, m, y, h, mm, s, km, trn, tpo);
                        break;
                    case "sprint":
                        int rpt = Integer.parseInt(rep.getText());
                        int rcv = Integer.parseInt(rec.getText());
                        e = new SprintEntry(n, d, m, y, h, mm, s, km, rpt, rcv);
                        break;
                    case "swim":
                        String lcn = loc.getText();
                        if (lcn.length() == 0) {
                            message = "Error: Location cannot be empty.\n";
                        }
                        e = new SwimEntry(n, d, m, y, h, mm, s, km, lcn);
                        break;
                    default:
                        e = new Entry(n, d, m, y, h, mm, s, km);
                }
                if (!myAthletes.addEntry(e)) {
                    message = "Could not add duplicate record.\n";
                }
            } catch (NumberFormatException e) {
                message = "Error: Please provide valid, non-null numbers in the numerical fields.\n";
            }
        }
        return message;
    }

    /**
     * Removes a single entry from the record.
     *
     * @return A status message.
     */
    public String removeEntry() {
        String message = "Record removed.\n";
        System.out.println("Attempting to remove entry from the records...");
        String n = name.getText();
        if (n.length() == 0) {
            message = "Error: Name cannot be empty.\n";
        } else {
            try {
                int d = Integer.parseInt(day.getText());
                int m = Integer.parseInt(month.getText());
                int y = Integer.parseInt(year.getText());
                if (!myAthletes.removeEntry(n, d, m, y)) {
                    message = "Could not remove; record may not exist.\n";
                }
            } catch (NumberFormatException e) {
                message = "Error: Please provide valid, non-null numbers in the numerical fields.\n";
            }
        }
        return message;
    }

    /**
     * Looks up entries by date or name.
     *
     * @param mode One of "all", "single" or "name", determining whether to look up all entries by date or just one, or
     *             to look up all entries by name.
     *
     * @return A status message.
     */
    public String lookupEntry(String mode) {
        outputArea.setText("Looking up record(s)...");
        try {
            // look up by date
            if (mode.equals("all") || mode.equals("single")) {
                int m = Integer.parseInt(month.getText());
                int d = Integer.parseInt(day.getText());
                int y = Integer.parseInt(year.getText());
                if (mode.equals("all")) {
                    return myAthletes.lookupEntries(d, m, y);
                } else {
                    return myAthletes.lookupEntry(d, m, y);
                }
            // look up by name
            } else {
                String nameToFind = name.getText();
                if (nameToFind.length() == 0) {
                    return "Error: Please provide a non-null value for the name.\n";  // avoid returning all records
                } else {
                    return myAthletes.lookupByName(nameToFind);
                }
            }
        } catch (NumberFormatException e) {
            return "Error: Please provide valid, non-null numbers in the numerical fields.\n";
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
     * Methods for filling the input fields on the display; for testing purposes only.
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

    public void fillDisplay(CycleEntry ent) {
        name.setText(ent.getName());
        day.setText(String.valueOf(ent.getDay()));
        month.setText(String.valueOf(ent.getMonth()));
        year.setText(String.valueOf(ent.getYear()));
        hours.setText(String.valueOf(ent.getHour()));
        mins.setText(String.valueOf(ent.getMin()));
        secs.setText(String.valueOf(ent.getSec()));
        dist.setText(String.valueOf(ent.getDistance()));
        terr.setText(String.valueOf(ent.getTerrain()));
        tem.setText(String.valueOf(ent.getTempo()));
    }

    public void fillDisplay(SprintEntry ent) {
        name.setText(ent.getName());
        day.setText(String.valueOf(ent.getDay()));
        month.setText(String.valueOf(ent.getMonth()));
        year.setText(String.valueOf(ent.getYear()));
        hours.setText(String.valueOf(ent.getHour()));
        mins.setText(String.valueOf(ent.getMin()));
        secs.setText(String.valueOf(ent.getSec()));
        dist.setText(String.valueOf(ent.getDistance()));
        rep.setText(String.valueOf(ent.getRepetitions()));
        rec.setText(String.valueOf(ent.getRecovery()));
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
        loc.setText(String.valueOf(ent.getWhere()));
    }
}

