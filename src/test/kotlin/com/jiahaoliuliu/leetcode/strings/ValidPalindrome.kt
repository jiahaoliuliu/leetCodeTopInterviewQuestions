package com.jiahaoliuliu.leetcode.strings

import junit.framework.Assert.assertEquals
import org.junit.Test

/**
 * Given a string s, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 *
 * Constraints
 * - 1 <= s.length <= 2 * 10^5
 * - s consists only of printable ASCII characters.
 */
class ValidPalindrome {

    @Test
    fun example1() {
        // Given
        val s = "A man, a plan, a canal: Panama"
        val expectedOutput = true

        // When
        val output = isPalindrome(s)

        // Then
        assertEquals(expectedOutput, output)
    }

    @Test
    fun example2() {
        // Given
        val s = "race a car"
        val expectedOutput = false

        // When
        val output = isPalindrome(s)

        // Then
        assertEquals(expectedOutput, output)
    }

    @Test
    fun example3() {
        // Given
        val s = "0P"
        val expectedOutput = false

        // When
        val output = isPalindrome(s)

        // Then
        assertEquals(expectedOutput, output)
    }

    @Test
    fun example4() {
        // Given
        val s = "Marge, let's \"[went].\" I await {news} telegram."
        val expectedOutput = true

        // When
        val output = isPalindrome(s)

        // Then
        assertEquals(expectedOutput, output)
    }

    @Test
    fun example5() {
        // Given
        val s = "9,8"
        val expectedOutput = false

        // When
        val output = isPalindrome(s)

        // Then
        assertEquals(expectedOutput, output)
    }

    fun isPalindrome(s: String): Boolean {
        val cleaned = s.toLowerCase().filter {
            (it - 'a' in 0 until 26) || (it - '0' in 0 until 10) }
        return cleaned == cleaned.reversed()
    }
}