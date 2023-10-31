package Management;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class NumberPattern {
    public static void main(String[] args) {
        List<String> inputNumbers = new ArrayList<>();
        inputNumbers.add("1234567890");
        inputNumbers.add("1122334455");
        inputNumbers.add("9876543210");
        inputNumbers.add("9999999999");

        Comparator<String> customComparator = new Comparator<String>() {
            @Override
            public int compare(String num1, String num2) {
                int count1 = countRepeatedDigits(num1);
                int count2 = countRepeatedDigits(num2);

                // Compare by ease of memorization (shorter numbers are easier to remember)
                int memorizationComparison = Integer.compare(num1.length(), num2.length());

                // If the counts of repeated digits are different, put the one with more repeated digits first
                if (count1 != count2) {
                    return Integer.compare(count2, count1); // Reverse order to have more repeats first
                }

                // If counts are the same, compare by memorization
                return memorizationComparison;
            }

            public int countRepeatedDigits(String number) {
                int count = 0;
                for (int i = 0; i < number.length(); i++) {
                    char currentDigit = number.charAt(i);
                    for (int j = i + 1; j < number.length(); j++) {
                        if (currentDigit == number.charAt(j)) {
                            count++;
                        }
                    }
                }
                return count;
            }
        };

        Collections.sort(inputNumbers, customComparator);

        for (String number : inputNumbers) {
            System.out.println(number);
        }
    }
    
    public static class CustomComparator implements Comparator<String> {
        @Override
        public int compare(String num1, String num2) {
            int count1 = countRepeatedDigits(num1);
            int count2 = countRepeatedDigits(num2);

            // Compare by ease of memorization (shorter numbers are easier to remember)
            int memorizationComparison = Integer.compare(num1.length(), num2.length());

            // If the counts of repeated digits are different, put the one with more repeated digits first
            if (count1 != count2) {
                return Integer.compare(count2, count1); // Reverse order to have more repeats first
            }

            // If counts are the same, compare by memorization
            return memorizationComparison;
        }

        private int countRepeatedDigits(String number) {
            int count = 0;
            for (int i = 0; i < number.length(); i++) {
                char currentDigit = number.charAt(i);
                for (int j = i + 1; j < number.length(); j++) {
                    if (currentDigit == number.charAt(j)) {
                        count++;
                    }
                }
            }
            return count;
        }
    }
}
