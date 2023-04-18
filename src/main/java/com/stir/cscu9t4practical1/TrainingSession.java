package com.stir.cscu9t4practical1;

import java.time.LocalDate;

//Superclass representing a training session
abstract class TrainingSession {
 private LocalDate date;
 private int duration;

 public TrainingSession(LocalDate date, int duration) {
     this.date = date;
     this.duration = duration;
 }

 // Abstract method that should be implemented by the subclasses
 public abstract String getType();

 public LocalDate getDate() {
     return date;
 }

 public int getDuration() {
     return duration;
 }

 // Redefining the toString method to return a String representation of a TrainingSession object
 @Override
 public String toString() {
     return getType() + " session on " + date + " for " + duration + " minutes.";
 }
}
