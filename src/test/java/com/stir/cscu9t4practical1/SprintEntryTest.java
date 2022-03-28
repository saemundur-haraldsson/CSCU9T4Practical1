/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stir.cscu9t4practical1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
/**
 *
 * @author saemundur
 */
public class SprintEntryTest {
    
    public SprintEntryTest() {
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
     * Test of getName method, of class SprintEntry.
     */
    @Test
     void testGetName() {
        System.out.println("getName");
        SprintEntry instance = new SprintEntry("Alice", 1, 2, 2003, 0, 16, 7, 300, 4, 2);

        String expResult = "Alice";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDay method, of class SprintEntry.
     */
    @Test
     void testGetDay() {
        System.out.println("getDay");
        SprintEntry instance = new SprintEntry("Alice", 1, 2, 2003, 0, 16, 7, 300, 4, 2);
        int expResult = 1;
        int result = instance.getDay();
        assertEquals(expResult, result);
    }

    /**
     * Test of getMonth method, of class SprintEntry.
     */
    @Test
     void testGetMonth() {
        System.out.println("getMonth");
        SprintEntry instance = new SprintEntry("Alice", 1, 2, 2003, 0, 16, 7, 300, 4, 2);
        int expResult = 2;
        int result = instance.getMonth();
        assertEquals(expResult, result);
    }

    /**
     * Test of getYear method, of class SprintEntry.
     */
    @Test
     void testGetYear() {
        System.out.println("getYear");
        SprintEntry instance = new SprintEntry("Alice", 1, 2, 2003, 0, 16, 7, 300, 4, 2);
        int expResult = 2003;
        int result = instance.getYear();
        assertEquals(expResult, result);
    }

    /**
     * Test of getHour method, of class SprintEntry.
     */
    @Test
     void testGetHour() {
        System.out.println("getHour");
        SprintEntry instance = new SprintEntry("Alice", 1, 2, 2003, 0, 16, 7, 300, 4, 2);
        int expResult = 0;
        int result = instance.getHour();
        assertEquals(expResult, result);
    }

    /**
     * Test of getMin method, of class SprintEntry.
     */
    @Test
     void testGetMin() {
        System.out.println("getMin");
        SprintEntry instance = new SprintEntry("Alice", 1, 2, 2003, 0, 16, 7, 300, 4, 2);
        int expResult = 16;
        int result = instance.getMin();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSec method, of class SprintEntry.
     */
    @Test
     void testGetSec() {
        System.out.println("getSec");
        SprintEntry instance = new SprintEntry("Alice", 1, 2, 2003, 0, 16, 7, 300, 4, 2);
        int expResult = 7;
        int result = instance.getSec();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDistance method, of class SprintEntry.
     */
    @Test
    public void testGetDistance() {
        System.out.println("getDistance");
        Entry instance = new SprintEntry("Alice", 1, 2, 2003, 0, 16, 7, 300, 4, 2);
        float expResult = 300.0F;
        float result = instance.getDistance();
        assertEquals(expResult, result,0.0);
    }
    

    /**
     * Test of getRepetitions method of class SprintEntry
     */
    @Test
    public void testGetRepetitions() {
        System.out.println("getRepetitions");
        SprintEntry instance = new SprintEntry("Alice", 1, 2, 2003, 0, 16, 7, 300, 4, 2);
        int expResults = 2;
        int result = instance.getLaps();
        assertEquals(expResults, result);
    }
    /**
     * Test of getRecovery method of class SprintEntry
     */
    @Test
     void testGetRecoveryTime() {
        System.out.println("getRecoveryTime");
        SprintEntry instance = new SprintEntry("Alice", 1, 2, 2003, 0, 16, 7, 300, 4, 2);
        int expResulta = 4;
        int result = instance.getRecoveryTime();
        assertEquals(expResulta, result);
    }

    /**
     * Test of getSprintEntry method, of class SprintEntry.
     */
    @Test
     void testGetSprintEntry() {
        System.out.println("getSprint");
     SprintEntry instance = new SprintEntry("Alice", 1, 2, 2003, 0, 16, 7, 300, 4, 2);
        String expResult = "Alice sprinted 2x300.0 m in 0:16:7 with 4 minutes recovery on 1/2/2003\n";
        String result = instance.getEntry();
        assertEquals(expResult, result);
    }
    
}