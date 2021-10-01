package com.jiahaoliuliu.leetcode.strings

import junit.framework.Assert.assertEquals
import org.junit.Test

/**
 * Given two integer arrays nums1 and nums2, return an array of their intersection.
 * Each element in the result must appear as many times as it shows in both arrays
 * and you may return the result in any order.
 *
 * Constraints
 * - 1 <= nums1.length, nums2.length <= 1000
 * - 0 <= nums1[i], nums2[i] <= 1000
 */
class IntersectionOfTwoArraysII {

    @Test
    fun example1() {
        val nums1 = intArrayOf(1,2,2,1)
        val nums2 = intArrayOf(2,2)
        val expectedOutput = intArrayOf(2,2)

        val output = intersect(nums1, nums2)
        assertEquals(expectedOutput.size, output.size)
        output.sort()

        for (position in expectedOutput.indices) {
            assertEquals(expectedOutput[position], output[position])
        }
    }

    @Test
    fun example2() {
        val nums1 = intArrayOf(4,9,5)
        val nums2 = intArrayOf(9,4,9,8,4)
        val expectedOutput = intArrayOf(4,9)

        val output = intersect(nums1, nums2)
        assertEquals(expectedOutput.size, output.size)
        output.sort()

        for (position in expectedOutput.indices) {
            assertEquals(expectedOutput[position], output[position])
        }
    }

    fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
        val big: IntArray
        val small: IntArray
        if (nums1.size > nums2.size) {
            big = nums1
            small = nums2
        } else {
            big = nums2
            small = nums1
        }

        val counts: MutableMap<Int, Int> = HashMap()
        big.forEach {
            val count = counts[it] ?: 0
            counts[it] = count + 1
        }

        val results = ArrayList<Int>()
        small.forEach {
            val count = counts[it] ?: 0
            if (count > 0) {
                counts[it] = count - 1
                results.add(it)
            }
        }

        return results.toIntArray()
    }
}