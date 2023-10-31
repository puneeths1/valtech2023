package Management;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class WordCounterTest {
    @Test
    public void testCountToughWords() {
    	String text = "This is a sample text with some tough words. Tough words are difficult to understand.";

        Map<String, Integer> wordCount = WordCounter.countToughWords(text);

        assertEquals(1, wordCount.get("sample"));
        assertEquals(1, wordCount.get("difficult"));
        assertEquals(1, wordCount.get("understand"));
        assertEquals(null, wordCount.get("is"));
    }

    @Test
    public void testReadArticleFromWebsite() {
        String testURL = "https://www.readersdigest.in/features/story-the-night-the-stars-fell-127683"; // Replace with a valid URL to test
        String articleContent = null;
        try {
            articleContent = WordCounter.readArticleFromWebsite(testURL);
        } catch (IOException e) {
            e.printStackTrace();
        }

        assertNotNull(articleContent);
        assertFalse(articleContent.isEmpty());
    }
}
