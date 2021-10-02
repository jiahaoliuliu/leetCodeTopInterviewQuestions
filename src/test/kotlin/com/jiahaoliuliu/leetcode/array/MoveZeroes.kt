package com.jiahaoliuliu.leetcode.array

import junit.framework.Assert.assertEquals
import org.junit.Test

/**
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of
 * the non-zero elements.
 *
 * Note that you must do this in-place without making a copy of the array.
 *
 * Constraints
 * - 1 <= nums.length <= 104
 * - -2^31 <= nums[i] <= 2^31 - 1
 */
class MoveZeroes {

    @Test
    fun example1() {
        // Given
        val nums = intArrayOf(0,1,0,3,12)
        val expectedOutput = intArrayOf(1,3,12,0,0)

        // When
        moveZeroes(nums)

        // Then
        assertEquals(expectedOutput.size, nums.size)
        for (pos in expectedOutput.indices) {
            assertEquals(expectedOutput[pos], nums[pos])
        }
    }

    @Test
    fun example2() {
        // Given
        val nums = intArrayOf(0)
        val expectedOutput = intArrayOf(0)

        // When
        moveZeroes(nums)

        // Then
        assertEquals(expectedOutput.size, nums.size)
        for (pos in expectedOutput.indices) {
            assertEquals(expectedOutput[pos], nums[pos])
        }
    }

    @Test
    fun example3() {
        // Given
        val nums = intArrayOf(0, 0)
        val expectedOutput = intArrayOf(0,0)

        // When
        moveZeroes(nums)

        // Then
        assertEquals(expectedOutput.size, nums.size)
        for (pos in expectedOutput.indices) {
            assertEquals(expectedOutput[pos], nums[pos])
        }
    }

    @Test
    fun example4() {
        // Given
        val nums = intArrayOf(0, 0, 1)
        val expectedOutput = intArrayOf(1, 0,0)

        // When
        moveZeroes(nums)

        // Then
        assertEquals(expectedOutput.size, nums.size)
        for (pos in expectedOutput.indices) {
            assertEquals(expectedOutput[pos], nums[pos])
        }
    }

    fun moveZeroes(nums: IntArray) {
        if (nums.isEmpty() || nums.size == 1) return
        var i = 0
        var j = nums.size - 1

        while (i <= j) {
            // if the number is zero, then move the elements from the back to front
            if (nums[i] == 0) {
                for (index in i until j) {
                    nums[index] = nums[index+1]
                }
                nums[j--] = 0
            } else {
                i++
            }
        }
    }
}