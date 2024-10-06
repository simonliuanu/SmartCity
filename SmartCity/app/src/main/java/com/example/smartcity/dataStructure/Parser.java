package com.example.smartcity.dataStructure;

import java.util.ArrayList;
import java.util.List;

public class Parser {

    private List<String> validTokens;

    public Parser(List<String> validTokens) {
        this.validTokens = validTokens;
    }

    public List<String> parse(List<String> tokens) {
        List<String> parsedTokens = new ArrayList<>();
        for (String token : tokens) {
            String correctedToken = findClosestValidToken(token);
            parsedTokens.add(correctedToken);
        }
        return parsedTokens;
    }

    private String findClosestValidToken(String token) {
        String closestToken = token;
        int minDistance = Integer.MAX_VALUE;

        for (String validToken : validTokens) {
            int distance = levenshteinDistance(token, validToken);
            if (distance < minDistance) {
                minDistance = distance;
                closestToken = validToken;
            }
        }

        return closestToken;
    }

    private int levenshteinDistance(String a, String b) {
        int[][] dp = new int[a.length() + 1][b.length() + 1];

        for (int i = 0; i <= a.length(); i++) {
            for (int j = 0; j <= b.length(); j++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1] + (a.charAt(i - 1) == b.charAt(j - 1) ? 0 : 1),
                            Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1));
                }
            }
        }

        return dp[a.length()][b.length()];
    }
}