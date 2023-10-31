package Management;
import org.junit.Test;
import org.junit.Before;
import java.util.Map;
import static org.junit.Assert.assertEquals;

public class ViewingCssTest {
    private ViewingCss viewingCss;

    @Before
    public void setUp() {
        viewingCss = new ViewingCss();
    }

    @Test
    public void testReadCSSFile() {
        String filePath =  "C:\\Users\\Puneeth.S\\Documents\\practice\\presentation_site\\style.css"; // Provide a test CSS file
        Map<String, String> cssMap = viewingCss.readCSSFile(filePath);
        // Test that the cssMap contains expected values based on your test CSS file
        assertEquals(6, cssMap.size()); // Adjust this based on your test data
    }

    @Test
    public void testConvertHexToRGB() {
        String input = ".test { color: #FF0000; background: #00FF00; }";
        String expected = ".test { color: rgb(255, 0, 0); background: rgb(0, 255, 0); }";
        String result = viewingCss.convertHexToRGB(input);
        assertEquals(expected, result);
    }

    @Test
    public void testHexToRgb() {
        String hexColor = "#00AABB";
        String expected = "rgb(0, 170, 187)";
        String result = viewingCss.hexToRgb(hexColor);
        assertEquals(expected, result);
    }
}
