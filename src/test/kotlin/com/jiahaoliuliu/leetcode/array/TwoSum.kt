package com.jiahaoliuliu.leetcode.array

import junit.framework.Assert.assertEquals
import org.junit.Test

/**
 * Given an array of integers nums and an integer target, return indices of the two numbers
 * such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same
 * element twice.
 * You can return the answer in any order.
 *
 * Constraints
 * - 2 <= nums.length <= 10^4
 * - -10^9 <= nums[i] <= 10^9
 * - -10^9 <= target <= 10^9
 * - Only one valid answer exists.
 */
class TwoSum {

    @Test
    fun example1() {
        // Given
        val nums = intArrayOf(2,7,11,15)
        val target = 9
        val expectedOutput = intArrayOf(0,1)

        // When
        val output = twoSum(nums, target)

        // Then
        output.sort()
        assertEquals(expectedOutput.size, output.size)
        for (position in expectedOutput.indices) {
            assertEquals(expectedOutput[position], output[position])
        }
    }

    @Test
    fun example2() {
        // Given
        val nums = intArrayOf(3,2,4)
        val target = 6
        val expectedOutput = intArrayOf(1,2)

        // When
        val output = twoSum(nums, target)
        output.sort()

        // Then
        assertEquals(expectedOutput.size, output.size)
        for (position in expectedOutput.indices) {
            assertEquals(expectedOutput[position], output[position])
        }
    }

    @Test
    fun example3() {
        // Given
        val nums = intArrayOf(3,3)
        val target = 6
        val expectedOutput = intArrayOf(0,1)

        // When
        val output = twoSum(nums, target)
        output.sort()

        // Then
        assertEquals(expectedOutput.size, output.size)
        for (position in expectedOutput.indices) {
            assertEquals(expectedOutput[position], output[position])
        }
    }

    @Test
    fun exampleN() {
        // Given
        val nums = intArrayOf(4,7,4,15)
        val target = 8
        val expectedOutput = intArrayOf(0,2)

        // When
        val output = twoSum(nums, target)
        output.sort()

        // Then
        assertEquals(expectedOutput.size, output.size)
        for (position in expectedOutput.indices) {
            assertEquals(expectedOutput[position], output[position])
        }
    }

    fun twoSum(nums: IntArray, target: Int): IntArray {
        val elementCache:MutableMap<Int, Int> = HashMap()
        nums.forEachIndexed{position, element ->
            val diff = target - element
            if (elementCache.containsKey(diff)) {
                return intArrayOf(position, elementCache[diff]!!)
            }
            elementCache[element] = position
        }

        return intArrayOf()
    }
}