package com.stir.cscu9t4practical1;

import java.time.LocalDate;

//Subclass representing a running or sprinting training session
class RunSprintSession extends TrainingSession {
 private int distance;

 public RunSprintSession(LocalDate date, int duration, int distance) {
     super(date, duration);
     this.distance = distance;
 }

 @Override
 public String getType() {
     return "Run/Sprint";
 }

 public int getDistance() {
     return distance;
 }

 // Redefining the toString method to return a String representation of a RunSprintSession object
 @Override
 public String toString() {
     return super.toString() + " Ran/Sprinted " + distance + " meters.";
 }
}