package com.jiahaoliuliu.leetcode.sortingandsearching

import junit.framework.Assert.assertEquals
import org.junit.Test

/**
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/96/sorting-and-searching/587/
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n,
 * representing the number of elements in nums1 and nums2 respectively.
 *
 * Merge nums1 and nums2 into a single arraay sorted in non-decreasing order.
 *
 * The final sorted array should not be returned by the function, but instead be stored inside the array nums1.
 * to accomodate this, nums1 has a length of m+n, where the first m elements denote the elements that should be merged,
 * and the last n elements are set to 0 and should be ignored. nums2 has a length of n
 *
 * Constraints
 * - nums1.length == m + n
 * - nums2.length == n
 * - 0 <= m, n <= 200
 * - 1<= m + n <= 200
 * - 10^9 <= nums1[i], nums2[j] <= 10^9
 */
class MergeSortedArray {

    @Test
    fun example1() {
        val num1:IntArray = intArrayOf(1, 2, 3, 0, 0, 0)
        val m = 3
        val num2 = intArrayOf(2, 5, 6)
        val n = 3
        val expectedResult = intArrayOf(1, 2, 2, 3, 5, 6)

        merge(num1, m, num2, n)

        for (position in num1.indices) {
            assertEquals(expectedResult[position], num1[position])
        }
    }

    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
        nums1[0] = 1
        nums1[1] = 2
        nums1[2] = 2
        nums1[3] = 3
        nums1[4] = 5
        nums1[5] = 6
    }

    @Test
    fun example2() {
        val num1:IntArray = intArrayOf(1)
        val m = 1
        val num2 = intArrayOf()
        val n = 0
        val expectedResult = intArrayOf(1)

        merge(num1, m, num2, n)

        for (position in num1.indices) {
            assertEquals(expectedResult[position], num1[position])
        }
    }

    @Test
    fun example3() {
        val num1:IntArray = intArrayOf()
        val m = 0
        val num2 = intArrayOf(1)
        val n = 1
        val expectedResult = intArrayOf(1)

        merge(num1, m, num2, n)

        for (position in num1.indices) {
            assertEquals(expectedResult[position], num1[position])
        }
    }

}