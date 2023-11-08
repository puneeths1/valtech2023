package com.valtech.training.pattern.checker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
//import java.util.Map;
import java.util.Map;



public class PatternCheckerServiceImpl implements PatternCheckerService {
    @Override
    public List<String> listPatterns(String mobile) {
        List<String> mobileNumbers = Arrays.asList(mobile);
        return listPatterns(mobileNumbers);
    }

    @Override
    public List<String> listPatterns(List<String> mobileNumbers) {
        // Create a frequency map for mobile numbers
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String number : mobileNumbers) {
            frequencyMap.put(number, frequencyMap.getOrDefault(number, 0) + 1);
        }

        // Sort the mobile numbers based on their frequency
        List<Map.Entry<String, Integer>> sortedEntries = new ArrayList<>(frequencyMap.entrySet());
        sortedEntries.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> entry1, Map.Entry<String, Integer> entry2) {
                return entry2.getValue().compareTo(entry1.getValue());
            }
        });

        List<String> sortedNumbers = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : sortedEntries) {
            for (int i = 0; i < entry.getValue(); i++) {
                sortedNumbers.add(entry.getKey());
            }
        }

        return sortedNumbers;
    }
}



