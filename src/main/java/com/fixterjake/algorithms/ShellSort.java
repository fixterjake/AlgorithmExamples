package com.fixterjake.algorithms;

import java.util.ArrayList;

public class ShellSort {

    public static long shellSort(ArrayList<Integer> list) {
        long startTime = System.nanoTime();
        for (int gap = list.size() / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < list.size(); i++) {
                int temp = list.get(i);
                int j;
                for (j = i; j >= gap && list.get(j - gap) > temp; j -= gap) {
                    list.set(j, list.get(j - gap));
                }
                list.set(j, temp);
            }
        }
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    public static void process() {
        long shell = App.processTime(ShellSort.shellSort(App.list));
        App.print("Shell Sort execution time (milliseconds): " + shell);
        App.executionTimes.add(shell);
        App.algorithmTypes.add("Shell Sort");
    }
}
