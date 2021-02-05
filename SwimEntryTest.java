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
 * @author karim lolah
 */
public class SwimEntryTest {
    
    public SwimEntryTest() {
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
     * Test of getName method, of class Swimming
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Swim instance = new Swim ("Alice", 1, 2, 2003, 0, 16, 7, 3,"outdoors");
        String expResult = "Alice";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDay method, of class Swimming.
     */
    @Test
    public void testGetDay() {
        System.out.println("getDay");
        Swim instance = new Swim("Alice", 1, 2, 2003, 0, 16, 7, 3,"pool");
        int expResult = 1;
        int result = instance.getDay();
        assertEquals(expResult, result);
    }

    /**
     * Test of getMonth method, of class Swimming
     */
    @Test
    public void testGetMonth() {
        System.out.println("getMonth");
        Swim instance = new Swim("Alice", 1, 2, 2003, 0, 16, 7, 3,"outdoors");
        int expResult = 2;
        int result = instance.getMonth();
        assertEquals(expResult, result);
    }

    /**
     * Test of getYear method, of class Swimming
     */
    @Test
    public void testGetYear() {
        System.out.println("getYear");
        Swim instance = new Swim("Alice", 1, 2, 2003, 0, 16, 7, 3,"pool");
        int expResult = 2003;
        int result = instance.getYear();
        assertEquals(expResult, result);
    }

    /**
     * Test of getHour method, of class Swimming
     */
    @Test
    public void testGetHour() {
        System.out.println("getHour");
        Swim instance = new Swim("Alice", 1, 2, 2003, 0, 16, 7, 3,"pool");
        int expResult = 0;
        int result = instance.getHour();
        assertEquals(expResult, result);
    }

    /**
     * Test of getMin method, of class Swimming
     */
    @Test
    public void testGetMin() {
        System.out.println("getMin");
        Swim instance = new Swim("Alice", 1, 2, 2003, 0, 16, 7, 3,"pool");
        int expResult = 16;
        int result = instance.getMin();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSec method, of class Swimming
     */
    @Test
    public void testGetSec() {
        System.out.println("getSec");
        Swim instance = new Swim("Alice", 1, 2, 2003, 0, 16, 7, 3,"pool");
        int expResult = 7;
        int result = instance.getSec();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDistance method, of class Swim
     */
    @Test
    public void testGetDistance() {
        System.out.println("getDistance");
        Entry instance = new Swim("Alice", 1, 2, 2003, 0, 16, 7, 3,"pool");
        float expResult = 3.0F;
        float result = instance.getDistance();
        assertEquals(expResult, result, 0.0);
    }
    
    /**
     * Test of getWhere method, of class Swim
     */
    @Test
    public void testGetPoolLocation() {
        System.out.println("getPoolLocation");
        Swim instanceA = new Swim("Alice", 1, 2, 2003, 0, 16, 7, 3,"outdoors");
        String expResultA = "outdoors";
        String result = instanceA.getPoolLocation();
        assertEquals(expResultA, result);
        
        Swim instanceB = new Swim("Alice", 1, 2, 2003, 0, 16, 7, 3,"pool");
        String expResultB = "in a pool";
        String result2 = instanceB.getPoolLocation();
        assertEquals(expResultB, result2);
    }
    /**
     * Test of getEntry method, of class Swim
     */
    @Test
    public void testGetEntry() {
        System.out.println("getEntry");
        Swim instance = new Swim("Alice", 1, 2, 2003, 0, 16, 7, 3,"outdoors");
        String expResult = "Alice swam 3.0 km outdoors in 0:16:7 on 1/2/2003\n";
        String result = instance.getEntry();
        assertEquals(expResult, result);
    }
    
}