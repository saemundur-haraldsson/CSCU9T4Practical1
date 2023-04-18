package com.stir.cscu9t4practical1;
import org.junit.Test;
import static org.junit.Assert.*;
import java.time.LocalDate;

// Testing the TrainingSession class
public class TrainingSessionTest {
    // Testing the constructor
    @Test
    public void testConstructor() {
        LocalDate date = LocalDate.now();
        int duration = 60;
        TrainingSession trainingSession = new RunSprintSession(date, duration, 1000);
        assertEquals(date, trainingSession.getDate());
        assertEquals(duration, trainingSession.getDuration());
    }
}

