package com.stir.cscu9t4practical1;
import org.junit.Test;
import static org.junit.Assert.*;
import java.time.LocalDate;

//Testing the CycleSession class
public class CycleSessionTest {
 // Testing the constructor
 @Test
 public void testConstructor() {
     LocalDate date = LocalDate.now();
     int duration = 60;
     int distance = 25;
     String terrain = "hilly";
     CycleSession cycleSession = new CycleSession(date, duration, distance, terrain);
     assertEquals(date, cycleSession.getDate());
     assertEquals(duration, cycleSession.getDuration());
     assertEquals(distance, cycleSession.getDistance());
     assertEquals(terrain, cycleSession.getTerrain());
 }
 
 // Testing the getType method
 @Test
 public void testGetType() {
     LocalDate date = LocalDate.now();
     int duration = 60;
     int distance = 25;
     String terrain = "hilly";
     CycleSession cycleSession = new CycleSession(date, duration, distance, terrain);
     assertEquals("Cycle", cycleSession.getType());
 }
 
 // Testing the toString method
 @Test
 public void testToString() {
     LocalDate date = LocalDate.now();
     int duration = 60;
     int distance = 25;
     String terrain = "hilly";
     CycleSession cycleSession = new CycleSession(date, duration, distance, terrain);
     String expected = "Cycle session on " + date + " for " + duration + " minutes. Cycled " + distance + " km on " + terrain + " terrain.";
     assertEquals(expected, cycleSession.toString());
 }
}

//Testing the SwimSession class
public class SwimSessionTest {
 // Testing the constructor
 @Test
 public void testConstructor() {
     LocalDate date = LocalDate.now();
     int duration = 60;
     int distance = 1000;
     String poolType
