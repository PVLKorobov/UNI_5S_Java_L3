package org.pvl;

import NK.TableGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/// Main speed test method
/// Provides methods to get speed and comparison of ArrayList and LinkedList structures
public class SpeedTest {
    // Class methods
    /// Constructor
    /// Initializes lists references as null values
    public SpeedTest(int callsCount) {
        this.callsCount = callsCount;
        linkedList = null;
        arrayList = null;
        tableRows = new ArrayList<>();
    }

    /// Class main
    /// Calls test methods and assembles results table
    public static void main(String[] args) {
        SpeedTest speedTest = new SpeedTest(2000);

        List<String> headers = new ArrayList<>(Arrays.asList("Method", "Calls", "ArrayList time", "LinkedList time"));

        TableGenerator tableGenerator = new TableGenerator();
        System.out.print(tableGenerator.generateTable(headers, speedTest.tableRows)); // TODO
    }
    //

    // Class members
    /// Reference to tested linked list object
    private LinkedList<Integer> linkedList;
    /// Reference to tested array list object
    private ArrayList<Integer> arrayList;
    /// Reference to the array of result table rows
    private List<List<String>> tableRows;
    /// Amount of calls for each tested method
    private int callsCount;
    //
}
