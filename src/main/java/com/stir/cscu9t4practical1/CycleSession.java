package com.stir.cscu9t4practical1;

import java.time.LocalDate;

//Subclass representing a cycling training session
class CycleSession extends TrainingSession {
 private int distance;
 private String terrain;

 public CycleSession(LocalDate date, int duration, int distance, String terrain) {
     super(date, duration);
     this.distance = distance;
     this.terrain = terrain;
 }

 @Override
 public String getType() {
     return "Cycle";
 }

 public int getDistance() {
     return distance;
 }

 public String getTerrain() {
     return terrain;
 }

 // Redefining the toString method to return a String representation of a CycleSession object
 @Override
 public String toString() {
     return super.toString() + " Cycled " + distance + " km on " + terrain + " terrain.";
 }
}
