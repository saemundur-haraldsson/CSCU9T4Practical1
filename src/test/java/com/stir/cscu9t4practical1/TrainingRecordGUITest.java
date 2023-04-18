package com.stir.cscu9t4practical1;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
import javax.swing.JButton;

public class TrainingRecordGUITest {

    @Test
    public void testAddEntry() {
        TrainingRecordGUI instance = new TrainingRecordGUI();
        Entry entry = new Entry("Alice", 1, 2, 2003, 0, 16, 7, 3);
        instance.fillDisplay(entry);
        String message = instance.addEntry("generic");
        assertEquals(message, "Record added\n");
    }

    @Test
    public void testBlankDisplay() {
        TrainingRecordGUI instance = new TrainingRecordGUI();
        instance.blankDisplay();
        assertTrue(instance.getNameField().getText().isEmpty());
        assertTrue(instance.getDayField().getText().isEmpty());
        assertTrue(instance.getMonthField().getText().isEmpty());
        assertTrue(instance.getYearField().getText().isEmpty());
        assertTrue(instance.getDistanceField().getText().isEmpty());
        assertTrue(instance.getHoursField().getText().isEmpty());
        assertTrue(instance.getMinutesField().getText().isEmpty());
        assertTrue(instance.getSecondsField().getText().isEmpty());
    }

    @Test
    public void testFillDisplay() {
        TrainingRecordGUI instance = new TrainingRecordGUI();
        Entry entry = new Entry("Alice", 1, 2, 2003, 0, 16, 7, 3);
        instance.fillDisplay(entry);
        assertEquals(instance.getNameField().getText(), "Alice");
        assertEquals(instance.getDayField().getText(), "1");
        assertEquals(instance.getMonthField().getText(), "2");
        assertEquals(instance.getYearField().getText(), "2003");
        assertEquals(instance.getDistanceField().getText(), "0.16");
        assertEquals(instance.getHoursField().getText(), "7");
        assertEquals(instance.getMinutesField().getText(), "3");
        assertEquals(instance.getSecondsField().getText(), "3");
    }

    @Test
    public void testFindAllByDate() {
        TrainingRecordGUI instance = new TrainingRecordGUI();
        Entry entry1 = new Entry("Alice", 1, 2, 2003, 0, 16, 7, 3);
        Entry entry2 = new Entry("Bob", 2, 2, 2003, 0, 16, 7, 3);
        Entry entry3 = new Entry("Charlie", 3, 2, 2003, 0, 16, 7, 3);
        instance.addEntry(entry1);
        instance.addEntry(entry2);
        instance.addEntry(entry3);
        String output = instance.findAllByDate(2, 2, 2003);
        assertTrue(output.contains("Bob"));
        assertFalse(output.contains("Alice"));
        assertFalse(output.contains("Charlie"));
    }

    @Test
    public void testLookUpByDate() {
        TrainingRecordGUI instance = new TrainingRecordGUI();
        Entry entry1 = new Entry("Alice", 1, 2, 2003, 0, 16, 7, 3);
        Entry entry2 = new Entry("Bob", 2, 2, 2003, 0, 16, 7, 3);
        Entry entry3 = new Entry("Charlie", 3, 2, 2003, 0, 16, 7, 3);
        instance.addEntry(entry1);
        instance.addEntry(entry2);
        instance.addEntry(entry3);
        Entry output = instance.lookUpByDate(1, 2, 2003);
        assertEquals(output, entry1);
    }
    @Test
    public void testRemoveEntry() {
        TrainingRecordGUI instance = new TrainingRecordGUI();
        Entry entry = new Entry("Alice", 1, 2, 2003, 0, 16, 7, 3);
        instance.addEntry(entry);
        String message = instance.removeEntry("Alice", 1, 2, 2003);
        assertEquals(message, "Record removed\n");
    }

    @Test
    public void testAddEntryButton() {
        TrainingRecordGUI instance = new TrainingRecordGUI();
        instance.blankDisplay();
        instance.getNameField().setText("Alice");
        instance.getDayField().setText("1");
        instance.getMonthField().setText("2");
        instance.getYearField().setText("2003");
        instance.getDistanceField().setText("0.16");
        instance.getHoursField().setText("7");
        instance.getMinutesField().setText("3");
        instance.getSecondsField().setText("3");
        JButton addEntryButton = instance.getAddEntryButton();
        addEntryButton.doClick();
        Entry addedEntry = instance.lookUpByDate(1, 2, 2003);
        assertEquals(addedEntry.getName(), "Alice");
        assertEquals(addedEntry.getDay(), 1);
        assertEquals(addedEntry.getMonth(), 2);
        assertEquals(addedEntry.getYear(), 2003);
        assertEquals(addedEntry.getDistance(), 0.16, 0.001);
        assertEquals(addedEntry.getHours(), 7);
        assertEquals(addedEntry.getMinutes(), 3);
        assertEquals(addedEntry.getSeconds(), 3);
    }