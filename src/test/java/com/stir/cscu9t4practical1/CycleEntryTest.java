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
public class CycleEntryTest {
    
    public CycleEntryTest() {
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
     * Test of getName method, of class CycleEntry.
     */
    @Test
     void testGetName() {
        System.out.println("getName");
        CycleEntry instance = new CycleEntry("Alice", 1, 2, 2003, 0, 16, 7, 3, "asphalt", "moderate");
        String expResult = "Alice";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDay method, of class CycleEntry.
     */
    @Test
     void testGetDay() {
        System.out.println("getDay");
        CycleEntry instance = new CycleEntry("Alice", 1, 2, 2003, 0, 16, 7, 3, "gravel", "moderate");
        int expResult = 1;
        int result = instance.getDay();
        assertEquals(expResult, result);
    }

    /**
     * Test of getMonth method, of class CycleEntry.
     */
    @Test
     void testGetMonth() {
        System.out.println("getMonth");
        CycleEntry instance = new CycleEntry("Alice", 1, 2, 2003, 0, 16, 7, 3, "mountain", "fast");
        int expResult = 2;
        int result = instance.getMonth();
        assertEquals(expResult, result);
    }

    /**
     * Test of getYear method, of class CycleEntry.
     */
    @Test
     void testGetYear() {
        System.out.println("getYear");
        CycleEntry instance = new CycleEntry("Alice", 1, 2, 2003, 0, 16, 7, 3, "gravel", "slow");
        int expResult = 2003;
        int result = instance.getYear();
        assertEquals(expResult, result);
    }

    /**
     * Test of getHour method, of class CycleEntry.
     */
    @Test
     void testGetHour() {
        System.out.println("getHour");
        CycleEntry instance = new CycleEntry("Alice", 1, 2, 2003, 0, 16, 7, 3, "asphalt", "fast");
        int expResult = 0;
        int result = instance.getHour();
        assertEquals(expResult, result);
    }

    /**
     * Test of getMin method, of class CycleEntry.
     */
    @Test
     void testGetMin() {
        System.out.println("getMin");
        CycleEntry instance = new CycleEntry("Alice", 1, 2, 2003, 0, 16, 7, 3, "asphalt", "moderate");
        int expResult = 16;
        int result = instance.getMin();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSec method, of class CycleEntry.
     */
    @Test
     void testGetSec() {
        System.out.println("getSec");
        CycleEntry instance = new CycleEntry("Alice", 1, 2, 2003, 0, 16, 7, 3, "asphalt", "moderate");
        int expResult = 7;
        int result = instance.getSec();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDistance method, of class CycleEntry.
     */
    @Test
     void testGetDistance() {
        System.out.println("getDistance");
        CycleEntry instance = new CycleEntry("Alice", 1, 2, 2003, 0, 16, 7, 3, "asphalt", "moderate");
        float expResult = 3.0F;
        float result = instance.getDistance();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getTerrain method, of class CycleEntry.
     */
    @Test
     void getCyleTrackType() {
        System.out.println("getTrackType");
        CycleEntry instance = new CycleEntry("Alice", 1, 2, 2003, 0, 16, 7, 3, "asphalt", "moderate");
        String expResult = "asphalt";
        String result =  instance.getCyleTrackType();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTempo method, of class CycleEntry.
     */
    @Test
     void testGetDifficulty() {
        System.out.println("getDifficulty");
        CycleEntry instance = new CycleEntry("Alice", 1, 2, 2003, 0, 16, 7, 3, "asphalt", "moderate");
        String expResult = "moderate";
        String result = instance.getDifficulty();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getEntry method, of class CycleEntry.
     */
    @Test
     void testGetEntry() {
        System.out.println("getEntry");
        CycleEntry instance = new CycleEntry("Alice", 1, 2, 2003, 0, 16, 7, 3, "asphalt", "moderate");
        String expResult = "Alice cycled 3.0 km in 0:16:7 on 1/2/2003 on asphalt at moderate tempo\n";
        String result = instance.getEntry();
        assertEquals(expResult, result);
    }
    
}