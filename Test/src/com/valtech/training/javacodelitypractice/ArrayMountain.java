package com.valtech.training.javacodelitypractice;

import java.util.List;

public class ArrayMountain {

    public static boolean checkMountain(List<Integer> array) {
        // Check if the array is empty or has only one element
        if (array == null || array.size() <= 1) {
            return false;
        }

        // Find the index of the peak element
        int peakIndex = -1;
        for (int i = 0; i < array.size() - 1; i++) {
            // Check if the array is strictly increasing
            if (array.get(i) < array.get(i + 1)) {
                peakIndex = i + 1;
            } else {
                break;
            }
        }

        // Check if the peak element exists and is not the first or last element
        if (peakIndex == -1 || peakIndex == 0 || peakIndex == array.size() - 1) {
            return false;
        }

        // Check if the array is strictly decreasing after the peak element
        for (int i = peakIndex; i < array.size() - 1; i++) {
            if (array.get(i) <= array.get(i + 1)) {
                return false;
            }
        }

        // If all the conditions are satisfied, return true
        return true;
    }

    public static void main(String[] args) {
        List<Integer> a = List.of(3, 5, 7, 6, 2, 1);
        System.out.println(checkMountain(a));
    }
}
