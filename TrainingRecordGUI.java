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
    private JTextField tr = new JTextField(15);
    private JTextField tp = new JTextField(4);
    private JTextField locationOfPool = new JTextField(7);
    private JTextField rp = new JTextField(2);
    private JTextField rc = new JTextField(2);
    private JLabel labn = new JLabel(" Name:");
    private JLabel labd = new JLabel(" Day:");
    private JLabel labm = new JLabel(" Month:");
    private JLabel laby = new JLabel(" Year:");
    private JLabel labh = new JLabel(" Hours:");
    private JLabel labmm = new JLabel(" Mins:");
    private JLabel labs = new JLabel(" Secs:");
    private JLabel labdist = new JLabel(" Distance (km):");
    private JLabel labrp = new JLabel(" Repetitions: ");
    private JLabel labrc = new JLabel(" Recovery: ");
    private JLabel labtr = new JLabel(" Terrain: ");
    private JLabel labtp = new JLabel(" Tempo: ");
    private JLabel lablocationOfPool = new JLabel("Location of pool: ");
    private JButton addRun = new JButton("Add Run");
    private JButton addCycle = new JButton("Add Cycle");
    private JButton addSwim = new JButton("Add Swim");
    private JButton addSprint = new JButton("Add Sprinting");
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
        add(labtr);
        add(tr);
        tr.setEditable(true);
        add(labtp);
        add(tp);
        tp.setEditable(true);
        add(lablocationOfPool);
        add(locationOfPool);
        locationOfPool.setEditable(true);
        add(labrp);
        add(rp);
        rp.setEditable(true);
        add(labrc);
        add(rc);
        rc.setEditable(true);
        add(addRun);
        addRun.addActionListener(this);
        add(addCycle);
        addCycle.addActionListener(this);
        add(addSwim);
        addSwim.addActionListener(this);
        add(addSprint);
        addSprint.addActionListener(this);
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
        if (event.getSource() == addRun) {
            message = addEntry("generic");
        }
        if (event.getSource() == addCycle) {
            message = addCycle("generic");
        }
        if (event.getSource() == addSwim) {
            message = addSwimming("generic");
        }
        if (event.getSource() == addSprint) {
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
   
    //add method for run
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
    //add method for cycle
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
        String t = tr.getText();
        String tm = tp.getText();
        Entry e = new Cycle(n, d, m, y, h, mm, s, km,t,tm);
        myAthletes.addEntry(e);
        return message;
    }
    //add method for swim
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
        String p = locationOfPool.getText();
        Entry e = new Swim(n, d, m, y, h, mm, s, km,p);
        myAthletes.addEntry(e);
        return message;
    }
    //add method for sprint
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
        int rep = Integer.parseInt(rp.getText());
        int rec = Integer.parseInt(rc.getText());
        Entry e = new Sprint(n, d, m, y, h, mm, s, km,rep,rec);
        myAthletes.addEntry(e);
        return message;
    }
    //Method to look up one entry
    public String lookupEntry() {
        int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());
        outputArea.setText("looking up record ...");
        String message = myAthletes.lookupEntry(d, m, y);
        return message;
    }
    //Method to look up all entries
    public String lookUpAllEntries() {
    	int m = Integer.parseInt(month.getText());
    	int d = Integer.parseInt(day.getText());
    	int y = Integer.parseInt(year.getText());
    	outputArea.setText("looking up record...");
    	String message = myAthletes.lookUpAllEntries(d, m, y);
    	return message;
    }
    //Method to remove an entry
    public void RemoveEntry() {
    	String n = name.getText();
    	int m = Integer.parseInt(month.getText());
    	int d = Integer.parseInt(day.getText());
    	int y = Integer.parseInt(year.getText());
    	outputArea.setText("Removing the entry...");
    	Entry rEntry = myAthletes.lookupEntry(n, d, m, y);
    	boolean removalProcess = myAthletes.removeTheEntry(rEntry);
    	if (removalProcess) {
    		outputArea.setText("Removal Process done");
    	}
    	else {
    		outputArea.setText("Removal Process could not be completed");
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
        tr.setText("");
        tp.setText("");
        locationOfPool.setText("");
        rp.setText("");
        rc.setText("");

    }
    //Making which buttons available
    public void availableButtons(ActionEvent event) {
        if(myAthletes.getNumberOfEntries() == 0) {
        	remove.setEnabled(false); 
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
    public void fillDisplay(Sprint ent) {
      	 name.setText(ent.getName());
           day.setText(String.valueOf(ent.getDay()));
           month.setText(String.valueOf(ent.getMonth()));
           year.setText(String.valueOf(ent.getYear()));
           hours.setText(String.valueOf(ent.getHour()));
           mins.setText(String.valueOf(ent.getMin()));
           secs.setText(String.valueOf(ent.getSec()));
           dist.setText(String.valueOf(ent.getDistance()));
           rp.setText(String.valueOf(ent.getRepetitions()));
           rc.setText(String.valueOf(ent.getRecovery()));
      }
    public void fillDisplay(Swim ent) {
      	 name.setText(ent.getName());
           day.setText(String.valueOf(ent.getDay()));
           month.setText(String.valueOf(ent.getMonth()));
           year.setText(String.valueOf(ent.getYear()));
           hours.setText(String.valueOf(ent.getHour()));
           mins.setText(String.valueOf(ent.getMin()));
           secs.setText(String.valueOf(ent.getSec()));
           dist.setText(String.valueOf(ent.getDistance()));
           locationOfPool.setText(String.valueOf(ent.getPoolLocation()));
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
         tr.setText(String.valueOf(ent.getTerrain()));
         tp.setText(String.valueOf(ent.getTempo()));
    }


} // TrainingRecordGUI