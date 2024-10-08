package com.example.smartcity.dataStructure;

import java.util.ArrayList;
import java.util.List;

public class Tokenizer {
    public List<String> tokenize(String query) {
        String[] tokens = query.split("\\s+");
        List<String> tokenList = new ArrayList<>();
        for (String token : tokens) {
            tokenList.add(token);
        }
        return tokenList;
    }
}
