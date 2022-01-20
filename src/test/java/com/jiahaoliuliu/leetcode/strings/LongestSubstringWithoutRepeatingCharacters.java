package com.jiahaoliuliu.leetcode.strings;

import org.junit.Test;

import java.util.Hashtable;

import static org.junit.Assert.assertEquals;

/**
 * Given a string s, find the length of the longest substring without repeating characters.
 * https://leetcode.com/explore/interview/card/google/59/array-and-strings/3047/
 * Constraints:
 * - 0 <= s.length <= 5 * 10^4
 * - s consists of english letters, digits, symbols and spaces
 */
public class LongestSubstringWithoutRepeatingCharacters {

    int lengthOfLongestSubstring(String word) {
        if (word.length() <= 1) return word.length();

        int longestSubstringLength = 1;
        for (int i = 0; i < word.length(); i++) {
            int tmpLongestSubstringLength = longestSubstringLength+1;
            while (i + tmpLongestSubstringLength <= word.length()) {
                String substring = word.substring(i, i + tmpLongestSubstringLength);
                if (containUniqueCharactersHasTable(substring)) {
                    if (tmpLongestSubstringLength > longestSubstringLength) {
                        longestSubstringLength = tmpLongestSubstringLength;
                    }
                    tmpLongestSubstringLength++;
                } else {
                    break;
                }
            }
        }

        return longestSubstringLength;
    }

    public boolean containUniqueCharactersHasTable(String word) {
        Hashtable<Integer, Character> characterHashtable = new Hashtable<>();
        for (char character : word.toCharArray()) {
            int position = character - 'a';
            if (characterHashtable.containsKey(position)) {
                return false;
            } else {
                characterHashtable.put(position, character);
            }
        }

        return true;
    }

    private int bestSolution(String s) {
        char stringToCharArray[] = s.toCharArray();
        if (stringToCharArray.length == 0) {
            return 0;
        }
        if (stringToCharArray.length == 1) {
            return 1;
        }
        int maxLength = 0;
        int lastStop = 0;
        for (int lastPosition = 0; lastPosition < stringToCharArray.length; lastPosition++){
            char lastChar = stringToCharArray[lastPosition];
            for (int startingPosition = lastStop; startingPosition < lastPosition; startingPosition++) {
                char startingChar = stringToCharArray[startingPosition];
                if (lastChar == startingChar) {
                    lastStop = startingPosition + 1;
                    break;
                }
            }
            if (maxLength < lastPosition - lastStop) {
                maxLength = lastPosition - lastStop;
            }
        }
        return maxLength + 1;
    }

    @Test
    public void test1() {
        // Given
        String input = "abcabcbb";

        // When
        int result = bestSolution(input);

        // Then
        assertEquals(3, result);
    }

    @Test
    public void test2() {
        // Given
        String input = "bbbbb";

        // When
        int result = bestSolution(input);

        // Then
        assertEquals(1, result);
    }

    @Test
    public void test3() {
        // Given
        String input = "pwwkew";

        // When
        int result = bestSolution(input);

        // Then
        assertEquals(3, result);
    }

    @Test
    public void test4() {
        // Given
        String input = "";

        // When
        int result = bestSolution(input);

        // Then
        assertEquals(0, result);
    }

    @Test
    public void test5() {
        // Given
        String input = "   ";

        // When
        int result = bestSolution(input);

        // Then
        assertEquals(1, result);
    }

    @Test
    public void test6() {
        // Given
        String input = "aabaab!bb";

        // When
        int result = bestSolution(input);

        // Then
        assertEquals(3, result);
    }

}