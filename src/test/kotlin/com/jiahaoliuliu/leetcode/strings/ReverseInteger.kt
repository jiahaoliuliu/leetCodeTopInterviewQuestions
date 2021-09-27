package com.jiahaoliuliu.leetcode.strings

import junit.framework.Assert.assertEquals
import org.junit.Test

/**
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/880/
 * Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside
 * the signed 32-bit integer range [-2^31, 2^31-1], then return 0
 *
 * // Limit = 1534236469
 * Constraints
 * - -2^31 <= x <= 2^31 - 1
 * -2,147,483,648 to 2,147,483,647
 */
class ReverseInteger {

    @Test
    fun example1() {
        val input = 123
        val expectedResult = 321

        val result = reverse(input)

        // Limt
        assertEquals(expectedResult, result)
    }

    @Test
    fun exampleN() {
        val input = 1_534_236_469
        val expectedResult = 0

        val result = reverse(input)

//        print (0 - (2.0.pow(31).toInt() + 1))
//        print (2.0.pow(31).toInt())
        assertEquals(expectedResult, result)
    }

    fun reverse(x: Int): Int {
        var number = x
        var reversed = 0
        var afterConversion: Long
        while (number != 0) {
            val digit = number % 10
            afterConversion = reversed.toLong() * 10 + digit.toLong()
            if (afterConversion < Integer.MIN_VALUE || afterConversion > Integer.MAX_VALUE) {
                return 0
            }
            reversed = reversed * 10 + digit
            number /= 10
        }
        return reversed
    }

    @Test
    fun example2() {
        val input = -123
        val expectedResult = -321

        val result = reverse(input)

        assertEquals(expectedResult, result)
    }

    @Test
    fun example3() {
        val input = 120
        val expectedResult = 21

        val result = reverse(input)

        assertEquals(expectedResult, result)
    }

    @Test
    fun example4() {
        val input = 0
        val expectedResult = 0

        val result = reverse(input)

        assertEquals(expectedResult, result)
    }

}