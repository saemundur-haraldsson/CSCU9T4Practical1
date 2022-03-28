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
import org.junit.jupiter.api.TestInstance;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author saemundur
 */
class TrainingRecordTest {
    public TrainingRecordTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public  void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of addEntry method, of class TrainingRecord.
     * You might want to extend this test when you implement the other
     * Entry types
     */
    @Test
    public void testAddEntry() {
        System.out.println("addEntry");
        Entry a = new Entry("Alice", 1, 2, 2003, 0, 16, 7, 3);
        TrainingRecord instance = new TrainingRecord();
        instance.addEntry(a);
        assertEquals(instance.getNumberOfEntries(),1);
    }
    
    /**
     * Test of addEntry with a repeat
     * Adding another entry for the same person on the same day should fail
     */
    @Test
    public void testAddEntryUnique() {
        System.out.println("addEntry -- fail");
        Entry a = new Entry("Alice", 1, 2, 2003, 0, 16, 7, 3);
        Entry b = new Entry("Alice", 1, 2, 2003, 0, 16, 7, 3);
        TrainingRecord instance = new TrainingRecord();
        instance.addEntry(a);
        instance.addEntry(b);
        assertEquals(instance.getNumberOfEntries(),1);
        // You might also consider using assertThrows() and let
        // TrainingRecord instance take care of when you're trying to add
        // a none-unique entry
    }

    /**
     * Test of lookupEntry method, of class TrainingRecord.
     */
    @Test
    public void testLookupEntry() {
        System.out.println("lookupEntry");
        TrainingRecord instance = new TrainingRecord();
        String expResult = "No entries found";
        Entry a = new Entry("Alice", 1, 2, 2003, 0, 16, 7, 3);
        Entry b = new Entry("Bob", 1, 2, 2003, 0, 14, 15, 3);
        Entry c1 = new Entry("Claire", 7, 3, 2010, 0, 26, 20, 7);
        Entry c2 = new Entry("Claire", 11, 3, 2010, 0, 24, 55, 7);
        instance.addEntry(a);
        instance.addEntry(b);
        instance.addEntry(c1);
        instance.addEntry(c2);
        int d = 7;
        int m = 3;
        int y = 2010;
        String result = instance.lookupEntry(d, m, y);
        assertNotEquals(expResult, result, "expecting to find the entry");
        result = instance.lookupEntry(1, 2, 1999);
        assertEquals(expResult, result, "expecting to not find the entry");
    }
    
    /**
     * Test of getNumberOfEntries, of class TrainingRecord
     */
    @Test
    public void testGetNumberOfEntries() {
        System.out.println("GetNumberOfEntries");
        TrainingRecord instance = new TrainingRecord();
        Entry a = new Entry("Alice", 1, 2, 2003, 0, 16, 7, 3);
        Entry b = new Entry("Bob", 1, 2, 2003, 0, 14, 15, 3);
        Entry c1 = new Entry("Claire", 7, 3, 2010, 0, 26, 20, 7);
        Entry c2 = new Entry("Claire", 11, 3, 2010, 0, 24, 55, 7);
        assertEquals(instance.getNumberOfEntries(),0);
        instance.addEntry(a);
        assertEquals(instance.getNumberOfEntries(),1);
        instance.addEntry(b);
        assertEquals(instance.getNumberOfEntries(),2);
        instance.addEntry(c1);
        assertEquals(instance.getNumberOfEntries(),3);
        instance.addEntry(c2);
        assertEquals(instance.getNumberOfEntries(),4);
    }
    
    /**
     * Test of yet to be implemented lookupEntries, of class TrainingRecord
     * Implement the method and then remove the "fail" line below and
     * un-comment call to the method and the assertion line
     */
    @Test
    public void testLookupEntries() {
        System.out.println("lookupEntries");
        String expectResultsNone = "Sorry couldn't find anything for this date";
        String expectResults = "Alice ran 3.0 km in 0:16:7 on 1/2/2003\n" + 
                                "Bob ran 3.0 km in 0:14:15 on 1/2/2003\n";
        TrainingRecord instance = new TrainingRecord();
        Entry a = new Entry("Alice", 1, 2, 2003, 0, 16, 7, 3);
        Entry b = new Entry("Bob", 1, 2, 2003, 0, 14, 15, 3);
        instance.addEntry(a);
        instance.addEntry(b);
        fail("This method cannot be tested as it does not exist yet");
        int d = 1;
        int m = 2;
        int y = 2003;
        // un-comment the lines below when you've implemented the method
//        String resultSuccess = instance.lookupEntries(d,m,y);
//        String resultNone = instance.lookupEntries(d,m,1999);
//        assertEquals(expectResultsNone,resultNone);
//        assertEquals(expectResults,resultSuccess);
    }
    
}
