           //  "https://www.readersdigest.in/features/story-the-night-the-stars-fell-127683";
package Management;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class WordCounter {
    
    public static void main(String[] args) {
        String articleURL = "https://www.readersdigest.in/features/story-the-night-the-stars-fell-127683"; 
        
        try {
            String articleContent = readArticleFromWebsite(articleURL);
            Map<String, Integer> toughWordsCount = countToughWords(articleContent);
            
            System.out.println("Tough Word Count:");
            
            for (String word : toughWordsCount.keySet()) {
                int count = toughWordsCount.get(word);
                System.out.println(word + ": " + count);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static String readArticleFromWebsite(String url) throws IOException {
        StringBuilder content = new StringBuilder();
        
        URL website = new URL(url);
        BufferedReader reader = new BufferedReader(new InputStreamReader(website.openStream()));
        
        String line;
        while ((line = reader.readLine()) != null) {
            content.append(line).append("\n");
        }
        
        reader.close();
        
        return content.toString();
    }
    
    public static Map<String, Integer> countToughWords(String text) {
        Map<String, Integer> wordCount = new HashMap<>();
        String[] words = text.split("\\s+");
        
        for (String word : words) {
            // Exclude common words
            if (!word.matches("(?i)\\b(?:as|in|the|of|will|can|is)\\b")) {
                word = word.replaceAll("[^a-zA-Z]", "").toLowerCase();
                
                if (!word.isEmpty()) {
                    wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                }
            }
        }
        
        return wordCount;
    }
}