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
    //1
    private JTextField rep = new JTextField(2);
    private JTextField rec = new JTextField(2);
    private JTextField ter = new JTextField(10);
    private JTextField tem = new JTextField(10);
    private JTextField whe = new JTextField(10);
       
    private JLabel labn = new JLabel(" Name:");
    private JLabel labd = new JLabel(" Day:");
    private JLabel labm = new JLabel(" Month:");
    private JLabel laby = new JLabel(" Year:");
    private JLabel labh = new JLabel(" Hours:");
    private JLabel labmm = new JLabel(" Mins:");
    private JLabel labs = new JLabel(" Secs:");
    private JLabel labdist = new JLabel(" Distance (km):");
    //2
    private JLabel laba = new JLabel(" Repetitions:");
    private JLabel labb = new JLabel(" Recovery:");
    private JLabel labc = new JLabel(" Terrain:");
    private JLabel labe = new JLabel(" Tempo:");
    private JLabel labf = new JLabel(" Where:");
       
    private JButton addR = new JButton("Add");
    private JButton lookUpByDate = new JButton("Look Up");
  //1
    private JButton FindAllByDate  = new JButton("Find All By Date");

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
        
        //1
        add(laba);
        add(rep);
        rep.setEditable(true);
        //2
        add(labb);
        add(rec);
        rec.setEditable(true);
        //3
        add(labc);
        add(ter);
        ter.setEditable(true);
        //4
        add(labe);
        add(tem);
        tem.setEditable(true);
        //5
        add(labf);
        add(whe);
        whe.setEditable(true);
        
        add(addR);
        addR.addActionListener(this);
        add(lookUpByDate);
        lookUpByDate.addActionListener(this);
        add(FindAllByDate);
        FindAllByDate.addActionListener(this);//1
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
        if (event.getSource() == FindAllByDate) {//1
        	
        	message = findAllEntry();
        	
        }
        outputArea.setText(message);
        blankDisplay();
    } // actionPerformed

   



	public String addEntry(String what) {
        String message = "Record added\n";
        System.out.println("Adding "+what+" entry to the records");
        String n = name.getText();
        if(!isVaildStr(month.getText()))return "add faild";
        int m = Integer.parseInt(month.getText());
        if(!isVaildStr(day.getText()))return "add faild";   
        int d = Integer.parseInt(day.getText());
        if(!isVaildStr(year.getText()))return "add faild";
        int y = Integer.parseInt(year.getText());
        float km = java.lang.Float.parseFloat(dist.getText());
        int h = Integer.parseInt(hours.getText());
        int mm = Integer.parseInt(mins.getText());
        int s = Integer.parseInt(secs.getText());
        
        
        //8
        Entry e = null;
        if(!rep.getText().isEmpty() &&!rec.getText().isEmpty()) {
        	int repe=Integer.parseInt(rep.getText());
        	int reco=Integer.parseInt(rec.getText());
        	e =new SprintEntry(n, d, m, y, h, mm, s, km,repe,reco);
        }else if(!ter.getText().isEmpty() &&!tem.getText().isEmpty()) {
        	String terr=ter.getText();
        	String temp=tem.getText();
        	e =new CycleEntry(n, d, m, y, h, mm, s, km,terr,temp);
        }else if(!whe.getText().isEmpty()) {
        	e =new SwimEntry(n, d, m, y, h, mm, s, km,whe.getText());
        }else {
        	 e = new Entry(n, d, m, y, h, mm, s, km);
        }

        myAthletes.addEntry(e);
        return message;
    }
	//2
	private boolean isVaildStr(String s) {
    	if(s!=null) {
    		for(int i=0;i<s.length();i++) {
    			if(!Character.isDigit(s.charAt(i)))
    				return false;
    		}
    		
    		return true;
    	}
    	return false;
    	
    }
    
    public String lookupEntry() {
        int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());
        outputArea.setText("looking up record ...");
        String message = myAthletes.lookupEntry(d, m, y);
        return message;
    }
    //findAllEntry
    public String findAllEntry() {
        int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());
        outputArea.setText("looking up record ...");
        String message = myAthletes.findAllEntry(d, m, y);
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
        //1
        rep.setText("");
        rec.setText("");
        ter.setText("");
        tem.setText("");
        whe.setText("");

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

