package com.jiahaoliuliu.leetcode.strings

import junit.framework.Assert.assertEquals
import org.junit.Test

/**
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/879/
 * Write a function that reverses a string. The input string is given as an array of characters s.
 */
class ReverseString {

    @Test
    fun example1() {
        val input = charArrayOf('h', 'e', 'l', 'l', 'o')
        val output = charArrayOf('o', 'l', 'l', 'e', 'h')
        reverseString(input)

        for (position in input.indices) {
            assertEquals(output[position], input[position])
        }
    }

    fun reverseString(input: CharArray) {
        var currentPosition = 0
        var reversePosition = input.size - 1
        while (currentPosition < reversePosition) {
            reverse(input, currentPosition, reversePosition)
            currentPosition++
            reversePosition--
        }
    }

    private fun reverse(input: CharArray, currentPosition: Int, reversePosition: Int) {
        val tmp = input[currentPosition]
        input[currentPosition] = input[reversePosition]
        input[reversePosition] = tmp
    }

    @Test
    fun example2() {
        val input = charArrayOf('H', 'a', 'n', 'n', 'a', 'h')
        val output = charArrayOf('h','a', 'n', 'n', 'a', 'H')
        reverseString(input)

        for (position in input.indices) {
            assertEquals(output[position], input[position])
        }
    }
}