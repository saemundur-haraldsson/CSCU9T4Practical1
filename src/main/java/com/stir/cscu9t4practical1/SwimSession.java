package com.stir.cscu9t4practical1;

import java.time.LocalDate;

//Subclass representing a swimming training session
class SwimSession extends TrainingSession {
 private int distance;
 private String poolType;

 public SwimSession(LocalDate date, int duration, int distance, String poolType) {
     super(date, duration);
     this.distance = distance;
     this.poolType = poolType;
 }

 @Override
 public String getType() {
     return "Swim";
 }

 public int getDistance() {
     return distance;
 }

 public String getPoolType() {
     return poolType;
 }

 // Redefining the toString method to return a String representation of a SwimSession object
 @Override
 public String toString() {
     return super.toString() + " Swam " + distance + " meters in a " + poolType + " pool.";
 }
}