package com.jiahaoliuliu.leetcode.strings

import junit.framework.Assert.assertEquals
import org.junit.Test

/**
 * You are given a large integer represented as an integer array digits, where each digits[i] is
 * the ith digit of the integer. The digits are ordered from most significant to least significant
 * in left-to-right order. The large integer does not contain any leading 0's.
 *
 * Increment the large integer by one and return the resulting array of digits.
 *
 * Constraints:
 * - 1 <= digits.length <= 100
 * - 0 <= digits[i] <= 9
 * - digits does not contain any leading 0's.
 */
class PlusOne {

    @Test
    fun example1() {
        val digits = intArrayOf(1,2,3)
        val expectedOutput = intArrayOf(1,2,4)
        val output = plusOne(digits)

        assertEquals(expectedOutput.size, output.size)
        for (position in expectedOutput.indices) {
            assertEquals(expectedOutput[position], output[position])
        }
    }

    @Test
    fun example2() {
        val digits = intArrayOf(4,3,2,1)
        val expectedOutput = intArrayOf(4,3,2,2)
        val output = plusOne(digits)

        assertEquals(expectedOutput.size, output.size)
        for (position in expectedOutput.indices) {
            assertEquals(expectedOutput[position], output[position])
        }
    }

    @Test
    fun example3() {
        val digits = intArrayOf(0)
        val expectedOutput = intArrayOf(1)
        val output = plusOne(digits)

        assertEquals(expectedOutput.size, output.size)
        for (position in expectedOutput.indices) {
            assertEquals(expectedOutput[position], output[position])
        }
    }

    @Test
    fun example4() {
        val digits = intArrayOf(9)
        val expectedOutput = intArrayOf(1, 0)
        val output = plusOne(digits)

        assertEquals(expectedOutput.size, output.size)
        for (position in expectedOutput.indices) {
            assertEquals(expectedOutput[position], output[position])
        }
    }

    @Test
    fun example5() {
        val digits = intArrayOf(9, 9, 9)
        val expectedOutput = intArrayOf(1, 0, 0, 0)
        val output = plusOne(digits)

        assertEquals(expectedOutput.size, output.size)
        for (position in expectedOutput.indices) {
            assertEquals(expectedOutput[position], output[position])
        }
    }

    fun plusOne(digits: IntArray): IntArray {
        for (position in digits.indices.reversed()) {
            if (digits[position] < 9) {
                digits[position] = digits[position] + 1
                return digits
            }
            digits[position] = 0
        }

        val result = IntArray(digits.size + 1)
        result[0] = 1
        return result
    }

//    fun plusOne(digits: IntArray): IntArray {
//        // when they are all nines
//        if (isAllNines(digits)) {
//            // Set one more array
//            val result = IntArray(digits.size + 1)
//            result[0] = 1
//            return result
//        }
//
//        var pos = digits.size - 1
//        var shouldContinue = true
//        while (pos >= 0 && shouldContinue) {
//            when(val value = digits[pos] + 1) {
//                10 -> {
//                    digits[pos] = 0
//                    pos -=1
//                } else ->  {
//                    digits[pos] = value
//                    shouldContinue = false
//                }
//            }
//        }
//
//        return digits
//    }
//
//    fun isAllNines(digits: IntArray): Boolean {
//        for (position in digits.indices) {
//            if (digits[position] != 9) {
//                return false
//            }
//        }
//
//        return true
//    }
}