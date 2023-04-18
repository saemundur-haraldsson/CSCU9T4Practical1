package com.stir.cscu9t4practical1;

import org.junit.Test;
import static org.junit.Assert.*;
import java.time.LocalDate;

//Testing the RunSprintSession class
public class RunSprintSessionTest {
 // Testing the constructor
 @Test
 public void testConstructor() {
     LocalDate date = LocalDate.now();
     int duration = 60;
     int distance = 1000;
     RunSprintSession runSprintSession = new RunSprintSession(date, duration, distance);
     assertEquals(date, runSprintSession.getDate());
     assertEquals(duration, runSprintSession.getDuration());
     assertEquals(distance, runSprintSession.getDistance());
 }
 
 // Testing the getType method
 @Test
 public void testGetType() {
     LocalDate date = LocalDate.now();
     int duration = 60;
     int distance = 1000;
     RunSprintSession runSprintSession = new RunSprintSession(date, duration, distance);
     assertEquals("Run/Sprint", runSprintSession.getType());
 }
 
 // Testing the toString method
 @Test
 public void testToString() {
     LocalDate date = LocalDate.now();
     int duration = 60;
     int distance = 1000;
     RunSprintSession runSprintSession = new RunSprintSession(date, duration, distance);
     String expected = "Run/Sprint session on " + date + " for " + duration + " minutes. Ran/Sprinted " + distance + " meters.";
     assertEquals(expected, runSprintSession.toString());
 }
}
