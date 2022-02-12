package com.jiahaoliuliu.leetcode.strings;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * https://leetcode.com/explore/interview/card/google/67/sql-2/3046/
 * You are visiting a farm that has a single row of fruit trees arranged from left to right.
 * The trees are represented by an integer array fruits where fruits[i] is the type of fruit the
 * ith tree produces.
 *
 * You want to collect as much fruit as possible. However, the owner has some strict rules that you must follow:
 *
 * - You only have two baskets, and each basket can only hold a single type of fruit.
 * There is no limit on the amount of fruit each basket can hold.
 *
 * - Starting from any tree of your choice, you must pick exactly one fruit from every tree (including the start tree)
 * while moving to the right. The picked fruits must fit in one of your baskets.
 *
 * Once you reach a tree with fruit that cannot fit in your baskets, you must stop.
 * Given the integer array fruits, return the maximum number of fruits you can pick.
 *
 * Example 1
 * Input: fruits = [1,2,1]
 * Output: 3
 * Explanation: We can pick from all 3 trees.
 *
 * Example 2
 * Input: fruits = [0,1,2,2]
 * Output: 3
 * Explanation: We can pick from trees [1,2,2].
 * If we had started at the first tree, we would only pick from trees [0,1].
 *
 * Example 3
 * Input: fruits = [1,2,3,2,2]
 * Output: 4
 * Explanation: We can pick from trees [2,3,2,2].
 * If we had started at the first tree, we would only pick from trees [1,2].
 *
 * Constraints*
 * 1 <= fruits.length <= 10^5
 * 0 <= fruits[i] < fruits.length
 */
public class FruitsIntoBaskets {
    // This is a typical worm problem, where the type of content that the worm covers is 2,
    // the worm can be as long as possible
    // O(n), where n is the size of the array
    public int totalFruit(int[] fruits) {
        int maxNumberOfFruits = 0;
        int tmpMax = 0;
        Map<Integer, Integer> fruitType = new HashMap<>(2);
        int maxNumberOfFruitsAllowed = 2;
        int fruitBasketToRemove = 0;

        for (int left = 0, right = 0; right < fruits.length; right++) {
            // Conditions to put the fruits in the basket
            if (fruitType.keySet().size() <= 1 || fruitType.containsKey(fruits[right])) {
                fruitType.putIfAbsent(fruits[right], 0);
                fruitType.put(fruits[right], fruitType.get(fruits[right]) + 1);
                tmpMax += 1;
            }

            fruitBasketToRemove = fruits[left];
            // If we had all the fruits and the next fruit is not the same as the one on the right
            while (fruitType.keySet().size() == maxNumberOfFruitsAllowed && right < fruits.length - 1 &&
                    !fruitType.containsKey(fruits[right+1]) && fruitType.containsKey(fruitBasketToRemove)) {

                // Update max
                if (tmpMax > maxNumberOfFruits) {
                    maxNumberOfFruits = tmpMax;
                }

                // Remove the fruits
                if (fruitType.containsKey(fruits[left])) {
                    int fruitsLeft = fruitType.get(fruits[left]);
                    fruitsLeft--;
                    if (fruitsLeft == 0) {
                        fruitType.remove(fruits[left]);
                    } else {
                        fruitType.put(fruits[left], fruitsLeft);
                    }
                }

                // Move left
                tmpMax -= 1;
                left++;
            }
        }

        // We have reached to the end of the string, the tmp max might be bigger than max
        if (tmpMax > maxNumberOfFruits) {
            maxNumberOfFruits = tmpMax;
        }

        return maxNumberOfFruits;
    }

    @Test
    public void test1() {
        // Given
        int[] fruits = new int[] {1,2,1};

        // When
        int result = totalFruit(fruits);

        // Then
        assertEquals(3, result);
    }

    @Test
    public void test2() {
        // Given
        int[] fruits = new int[] {3,3,3,1,2,1,1,2,3,3,4};

        // When
        int result = totalFruit(fruits);

        // Then
        assertEquals(5, result);
    }

    @Test
    public void test3() {
        // Given
        int[] fruits = new int[] {3,3,3,1,2,2,2,2,3,3,4};

        // When
        int result = totalFruit(fruits);

        // Then
        assertEquals(6, result);
    }

    @Test
    public void test4() {
        // Given
        int[] fruits = new int[] {1,2,3,2,2};

        // When
        int result = totalFruit(fruits);

        // Then
        assertEquals(4, result);
    }

    /**
     * A better solution
     * https://www.youtube.com/watch?v=za2YuucS0tw
     */
    public int betterSolTotalFruit(int[] fruits) {
        if (fruits == null || fruits.length == 0) {
            return 0;
        }

        int max = 1;
        HashMap<Integer, Integer> contentsMap = new HashMap<>();
        int left = 0;
        int right = 0;
        while (right < fruits.length) {
            if (contentsMap.size() <= 2) {
                contentsMap.put(fruits[right], right++);
            }

            if (contentsMap.size() > 2) {
                // Jump left
                // Max min is the maximum position of the fruits
                int min = fruits.length - 1;
                for (int value: contentsMap.values()) {
                    min = Math.min(min, value);
                }

                left = min + 1;

                // Remove the previous left
                contentsMap.remove(fruits[min]);
            }

            // Update max if needed
            max = Math.max(max, right - left);
        }

        return max;
    }

    @Test
    public void testBetterSolTotalFruit1() {
        // Given
        int[] fruits = new int[] {1,2,3,2,2};

        // When
        int result = betterSolTotalFruit(fruits);

        // Then
        assertEquals(4, result);
    }

    @Test
    public void testBetterSolTotalFruit2() {
        // Given
        int[] fruits = new int[] {1,2,3,2,2};

        // When
        int result = betterSolTotalFruit(fruits);

        // Then
        assertEquals(4, result);
    }

    @Test
    public void testBetterSolTotalFruit3() {
        // Given
        int[] fruits = new int[] {1,2,1,1,2,3,3,4,4,4,4};

        // When
        int result = betterSolTotalFruit(fruits);

        // Then
        assertEquals(6, result);
    }

}
