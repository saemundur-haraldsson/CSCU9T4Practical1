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
    
    private JTextField terr = new JTextField(15);
    private JTextField temp = new JTextField(4);
    private JTextField poolLoc = new JTextField(7);
    private JTextField rep = new JTextField(2);
    private JTextField rec = new JTextField(2);
    
    private JLabel labn = new JLabel(" Name:");
    private JLabel labd = new JLabel(" Day:");
    private JLabel labm = new JLabel(" Month:");
    private JLabel laby = new JLabel(" Year:");
    private JLabel labh = new JLabel(" Hours:");
    private JLabel labmm = new JLabel(" Mins:");
    private JLabel labs = new JLabel(" Secs:");
    private JLabel labdist = new JLabel(" Distance (km):");
    
    private JLabel labterr = new JLabel(" Terrain: ");
    private JLabel labtemp = new JLabel(" Tempo (mins): ");
    private JLabel labpoolLoc = new JLabel("Indoor/Outdoor: ");
    private JLabel labrep = new JLabel(" Repetitions: ");
    private JLabel labrec = new JLabel(" Recovery (mins): ");
    
    private JButton addR = new JButton("Add Run");
    private JButton addC = new JButton("Add Cycle");
    private JButton addS = new JButton("Add Swim");
    private JButton addSp = new JButton("Add Sprinting");
    private JButton remove = new JButton ("Remove Entry");
    
    private JButton lookUpByDate = new JButton("Look Up");
    private JButton FindAllByDate = new JButton ("Find by date");

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
        add(labterr);
        add(terr);
        terr.setEditable(true);
        add(labtemp);
        add(temp);
        temp.setEditable(true);
        add(labpoolLoc);
        add(poolLoc);
        poolLoc.setEditable(true);
        add(labrep);
        add(rep);
        rep.setEditable(true);
        add(labrec);
        add(rec);
        rec.setEditable(true);
        add(addR);
        addR.addActionListener(this);
        add(addC);
        addC.addActionListener(this);
        add(addS);
        addS.addActionListener(this);
        add(addSp);
        addSp.addActionListener(this);
        add(remove);
        remove.addActionListener(this);
        add(lookUpByDate);
        lookUpByDate.addActionListener(this);
        add(FindAllByDate);
        FindAllByDate.addActionListener(this);
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
        if (event.getSource() == addC) {
            message = addCycle("generic");
        }
        if (event.getSource() == addS) {
            message = addSwimming("generic");
        }
        if (event.getSource() == addSp) {
        	message = addSprinting("generic");
        }
        if (event.getSource() == lookUpByDate) {
            message = lookupEntry();
        }
        if(event.getSource()==FindAllByDate) {
        	message = lookUpAllEntries();
        	
        }
        if(event.getSource()==remove) {
        	RemoveEntry();
        }
        outputArea.setText(message);
        blankDisplay();
    } // actionPerformed
   
    //add method for running
    public String addEntry(String what) {
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
        Entry e = new Entry(n, d, m, y, h, mm, s, km);
        myAthletes.addEntry(e);
        return message;
    }
    //add method for cycling
    public String addCycle(String what) {
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
        String t = terr.getText();
        String tm = temp.getText();
        Entry e = new Cycling(n, d, m, y, h, mm, s, km,t,tm);
        myAthletes.addEntry(e);
        return message;
    }
    //add method for swimming
    public String addSwimming(String what) {
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
        String pl = poolLoc.getText();
        Entry e = new Swimming(n, d, m, y, h, mm, s, km,pl);
        myAthletes.addEntry(e);
        return message;
    }
    //add method for sprinting
    public String addSprinting(String what) {
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
        int rp = Integer.parseInt(rep.getText());
        int rc = Integer.parseInt(rec.getText());
        Entry e = new Sprinting(n, d, m, y, h, mm, s, km,rp,rc);
        myAthletes.addEntry(e);
        return message;
    }
    //Looks up one entry
    public String lookupEntry() {
        int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());
        outputArea.setText("looking up record ...");
        String message = myAthletes.lookupEntry(d, m, y);
        return message;
    }
    //Looks up all entries
    public String lookUpAllEntries() {
    	int m = Integer.parseInt(month.getText());
    	int d = Integer.parseInt(day.getText());
    	int y = Integer.parseInt(year.getText());
    	outputArea.setText("looking up record...");
    	String message = myAthletes.lookUpAllEntries(d, m, y);
    	return message;
    }
    //removes entry
    public void RemoveEntry() {
    	String n = name.getText();
    	int m = Integer.parseInt(month.getText());
    	int d = Integer.parseInt(day.getText());
    	int y = Integer.parseInt(year.getText());
    	outputArea.setText("Removing the entry...");
    	Entry removedEntry = myAthletes.lookupEntry(n, d, m, y);
    	boolean done = myAthletes.removeEntry(removedEntry);
    	if (done) {
    		outputArea.setText("Entry removal done");
    	}
    	else {
    		outputArea.setText("Entry has not been removed");
    	}
    }
     // blankDisplay
    // Fills the input fields on the display for testing purposes only
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
        temp.setText("");
        poolLoc.setText("");
        rep.setText("");
        rec.setText("");

    }
    //Setting which buttons are enabled 
    public void setEnabledRemoval(ActionEvent event) {
        if(myAthletes.getNumberOfEntries() == 0) {
        	remove.setEnabled(false);
        } 
    	}
    public void setEnabledLookUp(ActionEvent event) {
        if(myAthletes.getNumberOfEntries() == 0) {
        	lookUpByDate.setEnabled(false);
        	FindAllByDate.setEnabled(false);
        } 
    	}
    
    
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
    public void fillDisplay(Cycling ent) {
    	 name.setText(ent.getName());
         day.setText(String.valueOf(ent.getDay()));
         month.setText(String.valueOf(ent.getMonth()));
         year.setText(String.valueOf(ent.getYear()));
         hours.setText(String.valueOf(ent.getHour()));
         mins.setText(String.valueOf(ent.getMin()));
         secs.setText(String.valueOf(ent.getSec()));
         dist.setText(String.valueOf(ent.getDistance()));
         terr.setText(String.valueOf(ent.getTerrain()));
         temp.setText(String.valueOf(ent.getTempo()));
    }
    public void fillDisplay(Swimming ent) {
   	 name.setText(ent.getName());
        day.setText(String.valueOf(ent.getDay()));
        month.setText(String.valueOf(ent.getMonth()));
        year.setText(String.valueOf(ent.getYear()));
        hours.setText(String.valueOf(ent.getHour()));
        mins.setText(String.valueOf(ent.getMin()));
        secs.setText(String.valueOf(ent.getSec()));
        dist.setText(String.valueOf(ent.getDistance()));
        poolLoc.setText(String.valueOf(ent.getPoolLocation()));
   }
    public void fillDisplay(Sprinting ent) {
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
} // TrainingRecordGUI