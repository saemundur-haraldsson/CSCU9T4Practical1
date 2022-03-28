// GUI and main program for the Training Record
package com.stir.cscu9t4practical1;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

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
    
    private JTextField trkType = new JTextField(5);
    private JTextField difficulty = new JTextField(5);
    private JTextField where = new JTextField(5);
    private JTextField laps = new JTextField(4);
    private JTextField recoveryTime = new JTextField(4);

    private JLabel labTrk = new JLabel(" TrackType:");
    private JLabel labDifficulty = new JLabel(" difficulty:");
    private JLabel labWhere = new JLabel(" where:");
    private JLabel labLaps = new JLabel(" laps:");
   private JLabel labRecovery = new JLabel(" recovery time:");


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
    private JButton findAllByDate = new JButton ("Find All By Date"); // new find by date button 
    private JButton selectEntry = new JButton ("Select Entry");
    private JButton findAllByName = new JButton ("findByName");

    private JList<String> entryType;
    
    final DefaultListModel<String> l1 = new DefaultListModel<>();  
   

    
    


    private TrainingRecord myAthletes = new TrainingRecord();

    private JTextArea outputArea = new JTextArea(5, 50);

    public static void main(String[] args) {
        TrainingRecordGUI applic = new TrainingRecordGUI();
    } // main

    
    // set up the GUI 
    public TrainingRecordGUI() {
        super("Training Record");
        setLayout(new FlowLayout());
        
        
 
        l1.addElement("generic");
        l1.addElement("swim");  
        l1.addElement("sprint");  
        l1.addElement("cycle"); 
        entryType = new JList<>(l1);
        entryType.setBounds(100,100, 75,75);  
        entryType.setSize(400,400);  
        entryType.setLayout(null);  
        entryType.setVisible(true);  
        add(entryType);
        add(selectEntry);
        selectEntry.addActionListener(this);
        
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
        
        add(labTrk);
        labTrk.setVisible(false);
        add(trkType);
        trkType.setEditable(true);
        trkType.setVisible(false);
        
        add(labDifficulty);
        labDifficulty.setVisible(false);
        add(difficulty);
        difficulty.setEditable(true);
        difficulty.setVisible(false);
        
        add(labWhere);
        labWhere.setVisible(false);
        add(where);
        where.setEditable(true);
        where.setVisible(false);
        
        add(labLaps);
        labLaps.setVisible(false);
        add(laps);
        laps.setEditable(true);
        laps.setVisible(false);
        
        add(labRecovery);
        labRecovery.setVisible(false);
        add(recoveryTime);
        recoveryTime.setEditable(true);
        recoveryTime.setVisible(false);
        
        
        dist.setEditable(true);
        add(addR);
        addR.addActionListener(this);
        add(lookUpByDate);
        lookUpByDate.addActionListener(this);
        add(outputArea);
        outputArea.setEditable(false);
        add(findAllByDate);   // add find by date to page
        findAllByDate.addActionListener(this);
        
        add(findAllByName);   // add find by date to page
        findAllByName.addActionListener(this);
        // add action listener
        setSize(720, 200);
        setVisible(true);
        blankDisplay();
          
        // To save; typing in new entries while testing, uncomment
        // the following lines (or add your own test cases)
        
    } // constructor
   
    // listen for and respond to GUI events 
    public void actionPerformed(ActionEvent event) {
        String message = "";
        if (event.getSource() == addR && entryType.getSelectedIndex() == 3  ) {
            message = addEntry("cycle");
        }
        if (event.getSource() == addR   && entryType.getSelectedIndex() == 0 ) {
            message = addEntry("generic");
        }
        if (event.getSource() == addR && entryType.getSelectedIndex() == 1  ) {
            message = addEntry("swim");
        }
        if (event.getSource() == addR && entryType.getSelectedIndex() == 2  ) {
            message = addEntry("sprint");
        }
        
        if (event.getSource() == lookUpByDate) {
            message = lookupEntry();
        }
        if (event.getSource()==findAllByDate) {
        	 message = findAllByDate(); // action event for findAllByDate
        }
        if (event.getSource()==findAllByName) {
        	message = findAllByName();
        }
        
        if (event.getSource()== selectEntry&&entryType.getSelectedIndex() == 0 ) {
    		where.setVisible(false);
    		labWhere.setVisible(false);
    		
    		trkType.setVisible(false);
    		labTrk.setVisible(false);
    		labDifficulty.setVisible(false);
    		difficulty.setVisible(false);
    		laps.setVisible(false);
    		labLaps.setVisible(false);
    		labRecovery.setVisible(false);
    		recoveryTime.setVisible(false);

    		
    }
        if (event.getSource()== selectEntry&&entryType.getSelectedIndex() == 1 ) {
    		where.setVisible(true);
    		labWhere.setVisible(true);
    		
    		trkType.setVisible(false);
    		labTrk.setVisible(false);
    		labDifficulty.setVisible(false);
    		difficulty.setVisible(false);
    		laps.setVisible(false);
    		labLaps.setVisible(false);
    		labRecovery.setVisible(false);
    		recoveryTime.setVisible(false);

    		
    }
        if (event.getSource()== selectEntry&&entryType.getSelectedIndex() == 2 ) {
    		laps.setVisible(true);
    		labLaps.setVisible(true);
    		labRecovery.setVisible(true);
    		recoveryTime.setVisible(true);
    		trkType.setVisible(false);
    		labTrk.setVisible(false);
    		labDifficulty.setVisible(false);
    		difficulty.setVisible(false);
    		where.setVisible(false);
    		labWhere.setVisible(false);
    }
        if (event.getSource()== selectEntry&&entryType.getSelectedIndex() == 3 ) {
    		trkType.setVisible(true);
    		labTrk.setVisible(true);
    		labDifficulty.setVisible(true);
    		difficulty.setVisible(true);
    		laps.setVisible(false);
    		labLaps.setVisible(false);
    		labRecovery.setVisible(false);
    		recoveryTime.setVisible(false);
    		where.setVisible(false);
    		labWhere.setVisible(false);

    }
        outputArea.setText(message);
        blankDisplay();
    } // actionPerformed

    public String addEntry(String what) {
        String message = "Record added\n";
        
        int m,d,y,h,mm,s,recovery,lps;
        float km;
        String n;
        Entry e;
        String wh;


        String tr;
        String diff;
       
        
        // input handling 
        try { 
          
            n = name.getText();

         m = Integer.parseInt(month.getText());
         d = Integer.parseInt(day.getText());
         y = Integer.parseInt(year.getText());
         km = java.lang.Float.parseFloat(dist.getText());
         h = Integer.parseInt(hours.getText());
         mm = Integer.parseInt(mins.getText());
         s = Integer.parseInt(secs.getText());
        
        
        
         
         if (entryType.getSelectedIndex() == 0) {
        	 System.out.println("Adding "+what+" entry to the records");
        	 e= new Entry(n, d, m, y, h, mm, s, km);
        	 myAthletes.addEntry(e);
         }
         if (entryType.getSelectedIndex() == 1) {
             wh = where.getText();

        	 System.out.println("Adding "+what+" entry to the records");
        	 e = new SwimEntry(n, d, m, y, h, mm, s, km, wh);
        	 myAthletes.addEntry(e);
         }
         if (entryType.getSelectedIndex() == 2) {
        	 System.out.println("Adding "+what+" entry to the records");
        	 recovery = Integer.parseInt(recoveryTime.getText());
             lps = Integer.parseInt(laps.getText());
        	 e = new SprintEntry(n, d, m, y, h, mm, s, km,lps,recovery);
        	 myAthletes.addEntry(e);
         }
         if (entryType.getSelectedIndex() == 3) {
        	 diff = difficulty.getText();
             tr = trkType.getText();
        	 System.out.println("Adding "+what+" entry to the records");
        	 e = new CycleEntry(n, d, m, y, h, mm, s, km,tr,diff);
        	 myAthletes.addEntry(e);
         }
        }
        catch (NumberFormatException e1) {
        	message = "invalid input  "+ e1; 
        	
        	return message;

        }
        return message;
    }
    
    public String lookupEntry() {
    	 int m,d,y;
    	 try {
        m = Integer.parseInt(month.getText());
        d = Integer.parseInt(day.getText());
        y = Integer.parseInt(year.getText());
    	 }
    	 catch (Exception e){
    		 return "check your input";
    	 }
        outputArea.setText("looking up record ...");
        return myAthletes.lookupEntry(d, m, y);
    }
    
    public 	String findAllByDate() {
    	int m,d,y;
    	try {
    		 m = Integer.parseInt(month.getText());
             d = Integer.parseInt(day.getText());
             y = Integer.parseInt(year.getText());
    	}
    	 catch (Exception e ) {
    		 return "check your input";
    	 }
          outputArea.setText("looking up records ...");
          return myAthletes.lookupEntries(d, m, y); 
    }
    public 	String findAllByName() {
    	String n;
    	try {
    		n= name.getText();
    	}
    	 catch (Exception e ) {
    		 return "check your input";
    	 }
          outputArea.setText("looking up records ...");
          return myAthletes.lookupByName(n); 
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

