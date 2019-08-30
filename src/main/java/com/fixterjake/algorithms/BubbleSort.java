package com.fixterjake.algorithms;

import java.util.ArrayList;

public class BubbleSort {

    public static long bubbleSort(ArrayList<Integer> list) {
        long startTime = System.nanoTime();
        int temp;
        for (int i = 0; i < list.size(); i++) {
            for (int j = 1; j < list.size() - i; j++) {
                if (list.get(j - 1) > list.get(j)) {
                    temp = list.get(j - 1);
                    list.set(j - 1, list.get(j));
                    list.set(j, temp);
                }
            }
        }
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    public static void process() {
        long bubble = App.processTime(BubbleSort.bubbleSort(App.list));
        App.print("Bubble Sort execution time (milliseconds): " + bubble);
        App.executionTimes.add(bubble);
        App.algorithmTypes.add("Bubble Sort");
    }
}
