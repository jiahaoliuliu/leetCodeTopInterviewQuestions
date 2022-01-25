package com.jiahaoliuliu.leetcode.strings;

import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.assertEquals;

/**
 * Given two non-negative integers num1 and num2 represented as strings, return the product of
 * num1 and num2, also represented as a string.
 *
 * Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.
 * <ul>Example 1:
 *  <li> Input: num1 = "2", num2 = "3"</li>
 *  <li> Output: "6"</li>
 * </ul>
 * <ul>Example 2:
 *  <li> Input: num1 = "123", num2 = "456"</li>
 *  <li> Output: "56088"</li>
 * </ul>
 *
 */
public class MultiplyStrings {

    public String multiply(String num1, String num2) {
        // Corner cases
        if (num1.equals("0") || num2.equals("0")) return "0";
        if (num1.equals("1")) return num2;
        if (num2.equals("1")) return num1;

        int num1Length = num1.length();
        int num2Length = num2.length();

        int[] result = new int[num1Length + num2Length];

        for (int i = num1Length - 1; i >= 0; i--) {
            for (int j = num2Length -1; j >= 0; j--) {
                int multi = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j;
                int p2 = i + j + 1;
                int sum = multi + result[p2];

                result[p1] += sum / 10;
                result[p2] = sum % 10;
            }
        }

        // Convert result to String
        StringBuilder sb = new StringBuilder();
        for (int number : result) {
            if (!(sb.length() == 0 && (number == 0))){
                sb.append(number);
            }
        }

        return sb.toString();
    }

    @Test
    public void test1() {
        // Given
        String num1 = "2";
        String num2 = "3";

        // When
        String result = multiply(num1, num2);

        // Then
        assertEquals("6", result);
    }

    @Test
    public void test2() {
        // Given
        String num1 = "7";
        String num2 = "8";

        // When
        String result = multiply(num1, num2);

        // Then
        assertEquals("56", result);
    }

    @Test
    public void test3() {
        // Given
        String num1 = "11";
        String num2 = "8";

        // When
        String result = multiply(num1, num2);

        // Then
        assertEquals("88", result);
    }

    @Test
    public void test4() {
        // Given
        String num1 = "123";
        String num2 = "456";

        // When
        String result = multiply(num1, num2);

        // Then
        assertEquals("56088", result);
    }

}
