package Management;

import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class HTMLTagNumberTest {

    @Test
    public void testCountHTMLTags() {
        HTMLTagNumber htmlTagNumber = new HTMLTagNumber();
        try {
            int tagCount = htmlTagNumber.countHTMLTags("C:\\Users\\Puneeth.S\\Documents\\practice\\presentation_site\\index.html");
            assertEquals(38, tagCount); // Modify the expected count as per your HTML file.
        } catch (IOException e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    public void testCountTagOccurrences() {
        HTMLTagNumber htmlTagNumber = new HTMLTagNumber();
        try {
            Map<String, Integer> tagOccurrences = htmlTagNumber.countTagOccurrences("C:\\Users\\Puneeth.S\\Documents\\practice\\presentation_site\\index.html");
            // Modify the expected occurrences as per your HTML file content and tag usage.
            assertEquals(4, tagOccurrences.get("div"));
            assertEquals(4, tagOccurrences.get("p"));
        } catch (IOException e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }
}
