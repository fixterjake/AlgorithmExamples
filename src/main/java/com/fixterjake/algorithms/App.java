package com.fixterjake.algorithms;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class App {

    /** File holding random integers **/
    private static final String numsPath = "nums.txt";
    /** File holding result of sorting **/
    private static final String resultsPath = "results.txt";
    /** Number of integers to generate **/
    private static final int fileSize = 40000;
    /** List to populate and sort using given algorithms **/
    protected static ArrayList<Integer> list = new ArrayList<Integer>();;
    /** List of execution times **/
    protected static ArrayList<Long> executionTimes = new ArrayList<Long>();
    /** List of algorithm types tested **/
    protected static ArrayList<String> algorithmTypes = new ArrayList<String>();

    /**
     * Write execution times to result file
     */
    protected static void writeResult() {
        try {
            PrintWriter pout = new PrintWriter(new File(resultsPath));
            pout.println("|| ****************************** ||");
            pout.println("|| Execution times for each algorithm:");
            for (int i = 0; i < executionTimes.size(); i++) {
                pout.println("|| " + algorithmTypes.get(i) + ": "
                                   + executionTimes.get(i) + " milliseconds, "
                                   + executionTimes.get(i) / 1000.0 + " seconds");
            }
            long sum = 0;
            for (int i = 0; i < executionTimes.size(); i++) {
                sum += executionTimes.get(i);
            }
            pout.println("|| Total execution time: "
                          + sum + " milliseconds, "
                          + sum / 1000.0 + " seconds");
            pout.println("|| ****************************** ||");
            pout.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Function to read integers from file and populate list.
     */
    private static void populateList() {
        try {
            Scanner sc = new Scanner(new File(numsPath));
            while (sc.hasNext()) {
                list.add(sc.nextInt());
            }
            sc.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Initialize file with n number of random integers
     * n being a global variable.
     */
    private static void init() {
        Random random = new Random();
        try {
            PrintWriter pout = new PrintWriter(new File(numsPath));
            for (int i = 0; i < fileSize; i++) {
                pout.println(random.nextInt(fileSize));
            }
            populateList();
            pout = new PrintWriter(new File(resultsPath));
            pout.println("|| ****************************** ||");
            pout.println("|| Results of algorithms:");
            pout.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Converts nanoseconds to milliseconds for logging & output
     * @param time Execution time in nanoseconds
     * @return Execution time in milliseconds
     */
    protected static long processTime(long time) {
        return time / 1000000;
    }

    /**
     * Helper function to print spacer.
     */
    protected static void printSpacer() {
        System.out.println("|| ****************************** ||");
    }

    /**
     * Helper function to print given string.
     * @param string String to print
     */
    protected static void print(String string) {
        System.out.println("|| " + string);
    }

    protected static void writeSortedList() {
        try {
            PrintWriter pout = new PrintWriter(new File(numsPath));
            for (int i : list) {
                pout.println(i);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        init();
        printSpacer();
        print("Available algorithms, please enter the corresponding number: ");
        printSpacer();
        print("1 : Bubble sort");
        print("2 : Insertion sort");
        print("3 : Shell sort");
        print("4 : All");
        print("0 : Exit");
        printSpacer();
        int choice = 0;
        try {
            choice = sc.nextInt();
        }
        catch(Exception e) {
            printSpacer();
            print("Unknown response.");
            printSpacer();
            System.exit(1);
        }
        printSpacer();
        switch (choice) {
            case 1:     BubbleSort.process();
                        break;

            case 2:     InsertionSort.process();
                        break;

            case 3:     ShellSort.process();
                        break;

            case 4:     BubbleSort.process();
                        InsertionSort.process();
                        ShellSort.process();
                        break;
            default:
        }
        writeSortedList();
        printSpacer();
        print("Now exiting");
        printSpacer();
        writeResult();
        System.exit(0);
    }
}
