import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HTMLTagNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
            
            String filePath = "C:\\Users\\Puneeth.S\\Documents\\practice\\presentation_site\\index.html";
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            int lineNumber = 0;
            Map<String, Integer> tagCount = new HashMap<>();
            
            while ((line = reader.readLine()) != null) {
                lineNumber++;
                Pattern pattern = Pattern.compile("<(\\w+)[^>]*>");
                Matcher matcher = pattern.matcher(line);
                
                while (matcher.find()) {
                    String tag = matcher.group(1);
                    tagCount.put(tag, tagCount.getOrDefault(tag, 0) + 1);
                    System.out.println("Tag: " + tag + " on line " + lineNumber);
                }
            }
            
            // Display tag counts at the end
            for (Map.Entry<String, Integer> entry : tagCount.entrySet()) {
                System.out.println("Tag: " + entry.getKey() + " Count: " + entry.getValue());
            }
            
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
