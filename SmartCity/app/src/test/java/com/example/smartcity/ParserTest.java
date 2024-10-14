package com.example.smartcity;

import com.example.smartcity.dataStructure.Parser;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class ParserTest {

    @Test
    public void testParse() {
        List<String> validTokens = Arrays.asList("this", "is", "a", "test", "input");
        Parser parser = new Parser(validTokens);
        List<String> inputTokens = Arrays.asList("This", "is", "a", "tst", "inpt");
        List<String> result = parser.parse(inputTokens);

        assertEquals(5, result.size());
        assertEquals("this", result.get(0));
        assertEquals("is", result.get(1));
        assertEquals("a", result.get(2));
        assertEquals("test", result.get(3));
        assertEquals("input", result.get(4));
    }
}