package com.fixterjake.testing;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class App {

    /** File holding random integers **/
    private static final String numsPath = "nums.txt";
    /** File holding result of sorting **/
    private static final String resultsPath = "results.txt";
    /** Number of integers to generate **/
    private static final int fileSize = 100000;
    /** List to populate and sort using given algorithms **/
    private static ArrayList<Integer> list = new ArrayList<Integer>();;
    /** List of execution times **/
    private static ArrayList<Long> executionTimes = new ArrayList<Long>();
    /** List of algorithm types tested **/
    private static ArrayList<String> algorithmTypes = new ArrayList<String>();

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
                                   + TimeUnit.MILLISECONDS.toSeconds(executionTimes.get(i)) + " seconds");
            }
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
    private static long processTime(long time) {
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

    public static void main(String[] args) {
        App app = new App();
        Scanner sc = new Scanner(System.in);
        printSpacer();
        print("Is this the first run? (Y/N)");
        if (sc.next().equalsIgnoreCase("Y")) {
            app.init();
            print("File populated.");
        }
        printSpacer();
        print("Available algorithms, please enter the corresponding number: ");
        printSpacer();
        print("1 : Bubble sort");
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
        switch (choice) {
            case 1:     long time = processTime(BubbleSort.bubbleSort(list));
                        printSpacer();
                        print("Execution time (milliseconds): " + time);
                        print("Now exiting");
                        printSpacer();
                        executionTimes.add(time);
                        algorithmTypes.add("Bubble Sort");
                        break;

            default:    printSpacer();
                        print("Exiting.");
                        printSpacer();
        }
        writeResult();
        System.exit(0);
    }
}
