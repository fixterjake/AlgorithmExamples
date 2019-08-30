package com.fixterjake.algorithms;

import java.util.ArrayList;

public class InsertionSort {

    public static long insertionSort(ArrayList<Integer> list) {
        long startTime = System.nanoTime();
        for (int i = 0; i < list.size(); i++) {
            int key = list.get(i);
            int j = i - 1;
            while (j >= 0 && list.get(j) > key) {
                list.set(j + 1, list.get(j));
                j = j - 1;
            }
            list.set(j + 1, key);
        }
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    public static void process() {
        long insertion = App.processTime(InsertionSort.insertionSort(App.list));
        App.print("Insertion Sort execution time (milliseconds): " + insertion);
        App.executionTimes.add(insertion);
        App.algorithmTypes.add("Insertion Sort");
    }
}
