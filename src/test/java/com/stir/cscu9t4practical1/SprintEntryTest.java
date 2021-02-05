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
public class SprintEntryTest
{
    
    public SprintEntryTest()
    {
    	
    }
    
    @BeforeAll
    public static void setUpClass()
    {
    	
    }
    
    @AfterAll
    public static void tearDownClass()
    {
    	
    }
    
    @BeforeEach
    public void setUp()
    {
    	
    }
    
    @AfterEach
    public void tearDown()
    {
    	
    }

    /**
     * Test of getName method, of class SprintEntry.
     */
    @Test
    public void testGetName()
    {
        System.out.println("getName");
        SprintEntry instance = new SprintEntry("Alice", 1, 2, 2003, 0, 20, 5, 200, 5, 2);
        String expResult = "Alice";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDay method, of class SprintEntry.
     */
    @Test
    public void testGetDay()
    {
        System.out.println("getDay");
        SprintEntry instance = new SprintEntry("Alice", 1, 2, 2003, 0, 20, 5, 2, 5, 2);
        int expResult = 1;
        int result = instance.getDay();
        assertEquals(expResult, result);
    }

    /**
     * Test of getMonth method, of class SprintEntry.
     */
    @Test
    public void testGetMonth()
    {
        System.out.println("getMonth");
        SprintEntry instance = new SprintEntry("Alice", 1, 2, 2003, 0, 20, 5, 2, 5, 2);
        int expResult = 2;
        int result = instance.getMonth();
        assertEquals(expResult, result);
    }

    /**
     * Test of getYear method, of class SprintEntry.
     */
    @Test
    public void testGetYear()
    {
        System.out.println("getYear");
        SprintEntry instance = new SprintEntry("Alice", 1, 2, 2003, 0, 20, 5, 2, 5, 2);
        int expResult = 2003;
        int result = instance.getYear();
        assertEquals(expResult, result);
    }

    /**
     * Test of getHour method, of class SprintEntry.
     */
    @Test
    public void testGetHour()
    {
        System.out.println("getHour");
        SprintEntry instance = new SprintEntry("Alice", 1, 2, 2003, 0, 20, 5, 2, 5, 2);
        int expResult = 0;
        int result = instance.getHour();
        assertEquals(expResult, result);
    }

    /**
     * Test of getMin method, of class SprintEntry.
     */
    @Test
    public void testGetMin()
    {
        System.out.println("getMin");
        SprintEntry instance = new SprintEntry("Alice", 1, 2, 2003, 0, 20, 5, 2, 5, 2);
        int expResult = 20;
        int result = instance.getMin();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSec method, of class SprintEntry.
     */
    @Test
    public void testGetSec()
    {
        System.out.println("getSec");
        SprintEntry instance = new SprintEntry("Alice", 1, 2, 2003, 0, 20, 5, 2, 5, 2);
        int expResult = 5;
        int result = instance.getSec();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDistance method, of class SprintEntry.
     */
    @Test
    public void testGetDistance()
    {
        System.out.println("getDistance");
        SprintEntry instance = new SprintEntry("Alice", 1, 2, 2003, 0, 20, 5, 2, 5, 2);
        float expResult = 2.0F;
        float result = instance.getDistance();
        assertEquals(expResult, result, 0.0);
    }
    
    /**
     * Test of getRepetitions method of class SprintEntry
     */
    @Test
    public void testGetRepetitions()
    {
        System.out.println("getRepetitions");
        SprintEntry instance = new SprintEntry("Alice", 1, 2, 2003, 0, 20, 5, 2, 5, 2);
        int expResult = 2;
        int result = instance.getRepetitions();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getRecovery method of class SprintEntry
     */
    @Test
    public void testGetRecovery()
    {
        System.out.println("getRepetitions");
        SprintEntry instance = new SprintEntry("Alice", 1, 2, 2003, 0, 20, 5, 2, 5, 2);
        int expResult = 5;
        int result = instance.getRecoveryTime();
        assertEquals(expResult, result);
    }

    /**
     * Test of getEntry method, of class SprintEntry.
     */
    @Test
    public void testGetEntry()
    {
        System.out.println("getEntry");
        SprintEntry instance = new SprintEntry("Alice", 1, 2, 2003, 0, 6, 7, 200, 1, 3);
        String expResult = "Alice sprinted 3x200m in 0:6:7 with 1 minute(s) recovery on 1/2/2003\n";
        String result = instance.getSprintEntry();
        assertEquals(expResult, result);
    }
    
}