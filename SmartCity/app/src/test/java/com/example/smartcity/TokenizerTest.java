package com.example.smartcity;

import com.example.smartcity.dataStructure.Tokenizer;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class TokenizerTest {

    @Test
    public void testTokenize() {
        Tokenizer tokenizer = new Tokenizer();
        String query = "This is a test query";
        List<String> tokens = tokenizer.tokenize(query);

        assertEquals(5, tokens.size());
        assertEquals("This", tokens.get(0));
        assertEquals("is", tokens.get(1));
        assertEquals("a", tokens.get(2));
        assertEquals("test", tokens.get(3));
        assertEquals("query", tokens.get(4));
    }
}