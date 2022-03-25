/*
 * Test class for TrainingRecordGUI
 * It is not finished as we're not expecting you to implement GUI testing
 * However, you're welcome to use this starter template and extend it and add
 * test for public methods you implement in TrainingRecordGUI.java
 */
package com.stir.cscu9t4practical1;

//import java.awt.event.ActionEvent;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;
// Only used if you want to use reflection to test private features
import java.lang.reflect.Field;
//import java.lang.reflect.InvocationTargetException;
//import java.lang.reflect.Method;
import javax.swing.JButton;




/**
 *
 * @author saemundur
 */
public class TrainingRecordGUITest {

    public TrainingRecordGUITest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of main method, of class TrainingRecordGUI.
     * just tests if the class can be initialised without errors
     */
    @Test
    public void testMain() {
        System.out.println("main");
        TrainingRecordGUI.main(null);
    }

    /**
     * Test of actionPerformed method, of class TrainingRecordGUI.
     * This doesn't test anything but might be used in evaluations
     */
    @Test
    public void testActionPerformed() throws IllegalArgumentException {
        System.out.println("Action not performed");
    }

    /**
     * Test of blankDisplay method, of class TrainingRecordGUI.
     * It just executes the method to see if it doesn't throw an exception
     */
    @Test
    public void testBlankDisplay() {
        System.out.println("blankDisplay");
        TrainingRecordGUI instance = new TrainingRecordGUI();
        instance.blankDisplay();
    }
    
    /**
     * Test of addEntry method, of class TrainingRecordGUI
     */
    @Test
    public void testAddEntry() {
        System.out.println("addEntry");
        TrainingRecordGUI instance = new TrainingRecordGUI();

        Entry genEntry = new Entry("Alice", 1, 2, 2003, 0, 16, 7, 3);
        instance.fillDisplay(genEntry);
        String message = instance.addEntry("generic");
        System.out.println(message);
        assertEquals("Record added.\n", message);

        message = instance.addEntry("generic");
        System.out.println(message);
        assertEquals("Could not add duplicate record.\n", message);

        CycleEntry cyEntry = new CycleEntry("Alice", 1, 2, 2004, 0, 16, 7, 3, "asphalt", "moderate");
        instance.fillDisplay(cyEntry);
        message = instance.addEntry("cycle");
        System.out.println(message);
        assertEquals("Record added.\n", message);

        SprintEntry spEntry = new SprintEntry("Alice", 1, 2, 2005, 0, 16, 7, 3, 5, 3);
        instance.fillDisplay(spEntry);
        message = instance.addEntry("sprint");
        System.out.println(message);
        assertEquals("Record added.\n", message);

        SwimEntry swEntry = new SwimEntry("Alice", 1, 2, 2006, 0, 16, 7, 3, "outdoors");
        instance.fillDisplay(swEntry);
        message = instance.addEntry("swim");
        System.out.println(message);
        assertEquals("Record added.\n", message);
    }

    /**
     * Test edge cases that should produce errors for addEntry()
     */
    @Test
    public void testAddEntryErrors() {
        System.out.println("addEntry");
        TrainingRecordGUI instance = new TrainingRecordGUI();

        Entry genEntry = new Entry("Alice", 1, 2, 2003, 0, 16, 7, 3);
        instance.fillDisplay(genEntry);
        instance.addEntry("generic");
        String message = instance.addEntry("generic");
        System.out.println(message);
        assertEquals("Could not add duplicate record.\n", message);

        genEntry = new Entry("", 1, 2, 2007, 0, 16, 7, 3);
        instance.fillDisplay(genEntry);
        message = instance.addEntry("generic");
        System.out.println(message);
        assertEquals("Error: Name cannot be empty.\n", message);

        CycleEntry cyEntry = new CycleEntry("Alice", 1, 2, 2008, 0, 16, 7, 3, "", "");
        instance.fillDisplay(cyEntry);
        message = instance.addEntry("cycle");
        System.out.println(message);
        assertEquals("Error: Terrain/Tempo cannot be empty.\n", message);

        SwimEntry swEntry = new SwimEntry("Alice", 1, 2, 2009, 0, 16, 7, 3, "");
        instance.fillDisplay(swEntry);
        message = instance.addEntry("swim");
        System.out.println(message);
        assertEquals("Error: Location cannot be empty.\n", message);
    }

    /**
     * Test of removeEntry method, of class TrainingRecordGUI
     */
    @Test
    public void testRemoveEntry() {
        System.out.println("removeEntry");
        TrainingRecordGUI instance = new TrainingRecordGUI();

        Entry genEntry = new Entry("Alice", 1, 2, 2003, 0, 16, 7, 3);
        instance.fillDisplay(genEntry);
        instance.addEntry("generic");

        instance.fillDisplay(genEntry);
        String message = instance.removeEntry();
        System.out.println(message);
        assertEquals("Record removed.\n", message);

        message = instance.removeEntry();
        System.out.println(message);
        assertEquals("Could not remove; record may not exist.\n", message);
    }
    
    /**
     * Test to see if all display requirements have been met
     */
    @Test
    public void testButtonsPresentInGUI() throws IllegalAccessException, IllegalArgumentException {
        System.out.println("Check if you have added the buttons"); 
        TrainingRecordGUI instance = new TrainingRecordGUI();
        Class<?> instanceClass = instance.getClass();
        String[] expectedFields = {"findAllByDate","lookUpByDate","remove"};
        Field[] fields = instanceClass.getDeclaredFields();
        int found = 0;
        for (Field field : fields) {
            if (Arrays.asList(expectedFields).contains(field.getName())){
                found += 1;
                field.setAccessible(true);
                assertTrue(field.get(instance) instanceof JButton);
            }
        }
        assertEquals(expectedFields.length,found,"Have you added all required buttons?");
    }
}
