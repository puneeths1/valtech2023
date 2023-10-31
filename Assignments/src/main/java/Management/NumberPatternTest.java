package Management;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberPatternTest {

    @Test
    public void testNumberPatternSorting() {
        List<String> inputNumbers = new ArrayList<>();
        inputNumbers.add("1234567890");
        inputNumbers.add("1122334455");
        inputNumbers.add("9876543210");
        inputNumbers.add("9999999999");

        List<String> expectedSortedNumbers = new ArrayList<>();
       
       
        
        expectedSortedNumbers.add("9999999999"); 
        expectedSortedNumbers.add("1122334455"); 
        expectedSortedNumbers.add("1234567890");
        expectedSortedNumbers.add("9876543210");

        Collections.sort(inputNumbers, new NumberPattern.CustomComparator());

        for (int i = 0; i < inputNumbers.size(); i++) {
            assertEquals(expectedSortedNumbers.get(i), inputNumbers.get(i));
        }
    }
}



   
