package com.valtech.training.javacodelitypractice;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class voweltest {
	
	private static class Word implements Comparable<Word>{
		private String actualWord;
		private int vowelCount;
		private float ratio;
		
		public Word(String word) {
			actualWord = word;
			for(int i=0;i<word.length();i++) {
				if("aeiouAEIOU".contains(""+word.charAt(i))) {
					vowelCount++;
				}
			}
			ratio=vowelCount * 1000/ word.length();
		}

		@Override
		public int compareTo(Word o) {
			// TODO Auto-generated method stub
			//compare ratio if same ratio,vompare index
			if(ratio!=o.ratio){
				return (int)(ratio-o.ratio);
			}
			
			if(ratio==o.ratio) {
				
//				if(actualWord.length() != o.actualWord.length()) {
//					return actualWord.length() - o.actualWord.length();
//				}
				
				int length = actualWord.length() > o.actualWord.length() ? o.actualWord.length():actualWord.length();
				for (int i = 0; i < length; i++) {
					if("aeiouAEIOU".equals(""+o.actualWord.charAt(i))) {
						return -1;
					}
					if("aeiouAEIOU".equals(""+actualWord.charAt(i))) {
						return 1;
					}
				}
				
			}
			return 0;
		}
	}

    public static void main(String[] args) {
    	
    	
        String sentence = "Hello how are you doing I am Good ";
//        String[] words = sentence.split("\\s+"); 
    	System.out.println(breakAndSort(sentence));
    	
    }
    
        
   
        public static List<String> breakAndSort(String str){
        	List<String> segments = Arrays.asList(str.split(" "));
        	Collections.sort(segments);
        	return segments;
        	
        }
        
    
}
