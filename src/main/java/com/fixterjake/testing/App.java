package com.fixterjake.testing;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class App {

    /** File holding random integers **/
    private final String filePath = "nums.txt";
    /** Number of integers to generate **/
    private final int fileSize = 100000;
    /** List to populate and sort using given algorithms **/
    private ArrayList<Integer> list;

    public App() {
        if (list.size() <= 0) {
            populateList();
        }
    }

    private void populateList() {

    }

    /**
     * Initialize file with n number of random integers
     * n being a global variable.
     */
    private void init() {
        Random random = new Random();
        File file = new File(filePath);
        try {
            PrintWriter pout = new PrintWriter(file);
            for (int i = 0; i < fileSize; i++) {
                pout.println(random.nextInt(fileSize));
            }
            populateList();
            pout.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Helper function to print spacer.
     */
    private static void printSpacer() {
        System.out.println("|| ****************************** ||");
    }

    /**
     * Helper function to print given string.
     * @param string String to print
     */
    private static void print(String string) {
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
        print("1 : Bubble sort");
        printSpacer();
        int choice;
        try {
            choice = sc.nextInt();
        }
        catch(Exception e) {
            printSpacer();
            print("Unknown response.");
            printSpacer();
            System.exit(1);
        }
    }
}
