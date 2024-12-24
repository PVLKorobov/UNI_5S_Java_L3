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
    /// Initializes new empty lists
    public SpeedTest(int callsCount) {
        this.callsCount = callsCount;
        linkedList = new LinkedList<>();
        arrayList = new ArrayList<>();
        tableRows = new ArrayList<>();
    }

    /// Class main
    /// Calls test methods and assembles results table
    public static void main(String[] args) {
        SpeedTest speedTest = new SpeedTest(2000);

        List<String> headers = new ArrayList<>(Arrays.asList("Method", "Calls", "ArrayList time", "LinkedList time"));
        speedTest.testAdd();
        speedTest.testGet();
        speedTest.testSet();
        speedTest.testSize();
        speedTest.testClear();
        speedTest.testRemove();

        TableGenerator tableGenerator = new TableGenerator();
        System.out.print(tableGenerator.generateTable(headers, speedTest.tableRows));
    }


    /// Clear method
    /// Clears tested lists
    private void clearLists() {
        linkedList.clear();
        arrayList.clear();
    }

    /// Add table row method
    /// Adds speed test result to table as table row
    /// @param methodName name of tested method as String
    /// @param arrayTotalTime total time of `callsCount` calls of the tested method for `arrayList` in ms
    /// @param linkedTotalTime total time of `callsCount` calls of the tested method for `linkedList` in ms
    private void addTimeToTable(String methodName, long arrayTotalTime, long linkedTotalTime) {
        List<String> row = new LinkedList<>(Arrays.asList(methodName, Integer.toString(callsCount), Long.toString(arrayTotalTime), Long.toString(linkedTotalTime)));
        tableRows.add(row);
    }


    /// Add method speed test
    /// Records call time for `callsCount` calls of add method of ArrayList and LinkedList
    /// Measures time to  add `callsCount` elements to tested lists
    /// Records results to `tableRows` as a list
    public void testAdd() {
        long arrayStartTime = System.currentTimeMillis();
        for (int i = 0; i < callsCount; ++i) {
            arrayList.add(i);
        }
        long arrayTotalTime = System.currentTimeMillis() - arrayStartTime;

        long linkedStartTime = System.currentTimeMillis();
        for (int i = 0; i < callsCount; ++i) {
            linkedList.add(i);
        }
        long linkedTotalTime = System.currentTimeMillis() - linkedStartTime;

        addTimeToTable("add", arrayTotalTime, linkedTotalTime);
    }

    /// Remove method speed test
    /// Records call time for `callsCount` calls of remove method of ArrayList and LinkedList
    /// Adds `callsCount` elements to tested lists and measures time to remove them
    /// Records results to `tableRows` as a list
    public void testRemove() {
        for (int i = 0; i < callsCount; ++i) {
            arrayList.add(i);
            linkedList.add(i);
        }

        long arrayStartTime = System.currentTimeMillis();
        for (int i = 0; i < callsCount; ++i) {
            arrayList.removeFirst();
        }
        long arrayTotalTime = System.currentTimeMillis() - arrayStartTime;

        long linkedStartTime = System.currentTimeMillis();
        for (int i = 0; i < callsCount; ++i) {
            linkedList.removeFirst();
        }
        long linkedTotalTime = System.currentTimeMillis() - linkedStartTime;

        addTimeToTable("remove", arrayTotalTime, linkedTotalTime);
    }

    /// Get method speed test
    /// Records call time for `callsCount` calls of get method of ArrayList and LinkedList
    /// Adds `callsCount` elements to tested lists and measures time to access each of them
    /// Records results to `tableRows` as a list
    public void testGet() {
        for (int i = 0; i < callsCount; ++i) {
            arrayList.add(i);
            linkedList.add(i);
        }

        long arrayStartTime = System.currentTimeMillis();
        for (int i = 0; i < callsCount; ++i) {
            arrayList.get(i);
        }
        long arrayTotalTime = System.currentTimeMillis() - arrayStartTime;

        long linkedStartTime = System.currentTimeMillis();
        for (int i = 0; i < callsCount; ++i) {
            linkedList.get(i);
        }
        long linkedTotalTime = System.currentTimeMillis() - linkedStartTime;

        addTimeToTable("get", arrayTotalTime, linkedTotalTime);
    }

    /// Set method speed test
    /// Records call time for `callsCount` calls of set method of ArrayList and LinkedList
    /// Adds `callsCount` elements to tested lists and measures time to replace each of them
    /// Records results to `tableRows` as a list
    public void testSet() {
        for (int i = 0; i < callsCount; ++i) {
            arrayList.add(i);
            linkedList.add(i);
        }

        long arrayStartTime = System.currentTimeMillis();
        for (int i = 0; i < callsCount; ++i) {
            arrayList.set(i, 0);
        }
        long arrayTotalTime = System.currentTimeMillis() - arrayStartTime;

        long linkedStartTime = System.currentTimeMillis();
        for (int i = 0; i < callsCount; ++i) {
            linkedList.set(i, 0);
        }
        long linkedTotalTime = System.currentTimeMillis() - linkedStartTime;

        addTimeToTable("set", arrayTotalTime, linkedTotalTime);
    }

    /// Clear method speed test
    /// Records call time for `callsCount` calls of clear method of ArrayList and LinkedList
    /// Adds `callsCount` elements to tested lists and measures time to clear the lists
    /// Records results to `tableRows` as a list
    public void testClear() {
        for (int i = 0; i < callsCount; ++i) {
            arrayList.add(i);
            linkedList.add(i);
        }

        long arrayStartTime = System.currentTimeMillis();
        arrayList.clear();
        long arrayTotalTime = System.currentTimeMillis() - arrayStartTime;

        long linkedStartTime = System.currentTimeMillis();
        linkedList.clear();
        long linkedTotalTime = System.currentTimeMillis() - linkedStartTime;

        addTimeToTable("clear", arrayTotalTime, linkedTotalTime);
    }

    /// Sort method speed test
    /// Records call time for `callsCount` calls of sort method of ArrayList and LinkedList
    /// Adds `callsCount` elements to tested lists and measures time to sort the lists
    /// Records results to `tableRows` as a list
    public void testSize() {
        for (int i = 0; i < callsCount; ++i) {
            arrayList.add(callsCount - i);
            linkedList.add(callsCount - i);
        }

        long arrayStartTime = System.currentTimeMillis();
        arrayList.sort(null);
        long arrayTotalTime = System.currentTimeMillis() - arrayStartTime;

        long linkedStartTime = System.currentTimeMillis();
        linkedList.sort(null);
        long linkedTotalTime = System.currentTimeMillis() - linkedStartTime;

        addTimeToTable("sort", arrayTotalTime, linkedTotalTime);
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
