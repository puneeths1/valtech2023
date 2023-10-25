package com.valtech.training.javacodelitypractice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class VowelsDivider {

    public static void sortWordsByVowels(List<String> words) {

        words.sort(Comparator.comparingInt(VowelsDivider::countVowels));
    }

    public static int countVowels(String word) {
        return (int) word.toLowerCase().chars().filter(VowelsDivider::isVowel).count();
    }

    public static boolean isVowel(int count) {
 
        return "aeiou".indexOf(count) != -1;
    	
    }

    public static void main(String[] args) {
        List<String> words = Arrays.asList("hello", "how", "are", "you", "I","am","good");

        sortWordsByVowels(words);

        for (String word : words) {
            System.out.println(word);
        }
    }
}
