package com.jiahaoliuliu.leetcode.array

import junit.framework.Assert.assertEquals
import org.junit.Test

/**
 * Determine if a 9 x 9 Sudoku board is valid.
 * Only the filled cells need to be validated according to the following rules:
 * - Each row must contain the digits 1-9 without repetition.
 * - Each column must contain the digits 1-9 without repetition.
 * - Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.

 * Note:
 *  A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 * Only the filled cells need to be validated according to the mentioned rules.
 *
 * Constraints:
 * - board.length == 9
 * - board[i].length == 9
 * - board[i][j] is a digit 1-9 or '.'
 */
class ValidSudoku {

    @Test
    fun example1() {
        // Given
        val row1 = charArrayOf('5','3','.','.', '7','.','.','.','.')
        val row2 = charArrayOf('6','.','.','1','9','5','.','.','.')
        val row3 = charArrayOf('.','9','8','.','.','.','.','6','.')
        val row4 = charArrayOf('8','.','.','.','6','.','.','.','3')
        val row5 = charArrayOf('4','.','.','8','.','3','.','.','1')
        val row6 = charArrayOf('7','.','.','.','2','.','.','.','6')
        val row7 = charArrayOf('.','6','.','.','.','.','2','8','.')
        val row8 = charArrayOf('.','.','.','4','1','9','.','.','5')
        val row9 = charArrayOf('.','.','.','.','8','.','.','7','9')
        val board: Array<CharArray> = arrayOf(row1, row2, row3, row4, row5, row6, row7, row8, row9)
        val expectedOutput = true

        // When
        val output = isValidSudoku2(board)

        // Then
        assertEquals(expectedOutput, output)
    }

    @Test
    fun example2() {
        // Given
        val row1 = charArrayOf('8','3','.','.','7','.','.','.','.')
        val row2 = charArrayOf('6','.','.','1','9','5','.','.','.')
        val row3 = charArrayOf('.','9','8','.','.','.','.','6','.')
        val row4 = charArrayOf('8','.','.','.','6','.','.','.','3')
        val row5 = charArrayOf('4','.','.','8','.','3','.','.','1')
        val row6 = charArrayOf('7','.','.','.','2','.','.','.','6')
        val row7 = charArrayOf('.','6','.','.','.','.','2','8','.')
        val row8 = charArrayOf('.','.','.','4','1','9','.','.','5')
        val row9 = charArrayOf('.','.','.','.','8','.','.','7','9')
        val board: Array<CharArray> = arrayOf(row1, row2, row3, row4, row5, row6, row7, row8, row9)
        val expectedOutput = false

        // When
        val output = isValidSudoku(board)

        // Then
        assertEquals(expectedOutput, output)
    }

    @Test
    fun example3() {
        // Given
        val row1 = charArrayOf('5','3','.','.','7','.','.','.','.')
        val row2 = charArrayOf('6','.','.','1','9','5','.','.','.')
        val row3 = charArrayOf('.','9','8','.','.','.','.','6','.')
        val row4 = charArrayOf('8','.','.','.','6','.','.','.','3')
        val row5 = charArrayOf('4','.','.','8','.','3','.','.','1')
        val row6 = charArrayOf('7','.','.','.','2','.','.','.','6')
        val row7 = charArrayOf('.','6','.','.','.','.','2','8','.')
        val row8 = charArrayOf('.','.','.','4','1','9','.','.','5')
        val row9 = charArrayOf('.','.','.','.','8','.','.','7','9')
        val board: Array<CharArray> = arrayOf(row1, row2, row3, row4, row5, row6, row7, row8, row9)
        val expectedOutput = true

        // When
        val output = isValidSudoku(board)

        // Then
        assertEquals(expectedOutput, output)
    }

    fun isValidSudoku(board: Array<CharArray>): Boolean {
        // Check row
        for (row in board) {
            if (!areNumbersValid(row))
                return false
        }

        // Check column
        for (rowNumber in 0 until 9) {
            val column = ArrayList<Char>()
            for (columnNumber in 0 until 9) {
                column.add(board[columnNumber][rowNumber])
            }
            if (!areNumbersValid(column.toCharArray())) {
                return false
            }
        }

        // Check small square
        for (startRaw in 0 until 9 step 3) {
            for (startColumn in 0 until 9 step 3) {
                val numbers = charArrayOf(
                    board[startRaw][startColumn],
                    board[startRaw][startColumn + 1],
                    board[startRaw][startColumn + 2],
                    board[startRaw + 1][startColumn],
                    board[startRaw + 1][startColumn + 1],
                    board[startRaw + 1][startColumn + 2],
                    board[startRaw + 2][startColumn],
                    board[startRaw + 2][startColumn + 1],
                    board[startRaw + 2][startColumn + 2])
                if (!areNumbersValid(numbers)) {
                    return false
                }
            }
        }

        return true
    }

    private fun areNumbersValid(row: CharArray): Boolean {
        val values = Array(9) {0}
        for(item in row) {
            if (item == '.') {
                continue
            }
            when(values[item - '1']) {
                0 -> values[item - '1'] = 1
                else -> return false
            }
        }

        return true
    }


    fun isValidSudoku2(board: Array<CharArray>): Boolean {
        val seen = HashSet<String>()
        for (i in 0 until 9){
            for (j in 0 until 9){
                val number = board[i][j]
                if (number != '.'){
                    if (
                        !seen.add("$number in row $i")
                        || !seen.add("$number in colm $j")
                        || !seen.add("$number in block ${i/3}-${j/3}")
                    ){
                        return false
                    }
                }
            }
        }
        return true
    }

    @Test
    fun testAreNumbersValid1() {
        // Given
        val row = charArrayOf('5','3','.','.', '7','.','.','.','.')
        val expectedOutput = true

        // When
        val output = areNumbersValid(row)

        // Then
        assertEquals(expectedOutput, output)
    }

    @Test
    fun testAreNumbersValid2() {
        // Given
        val row = charArrayOf('5','3','.','3', '7','.','.','7','.')
        val expectedOutput = false

        // When
        val output = areNumbersValid(row)

        // Then
        assertEquals(expectedOutput, output)
    }

    @Test
    fun testRangeAndSquares() {
        for (startRaw in 0 until 9 step 3) {
            for (startColumn in 0 until 9 step 3) {
                println("[$startRaw, $startColumn], [$startRaw, ${startColumn + 1}], [$startRaw, ${startColumn + 2}]," +
                        "[${startRaw + 1}, $startColumn], [${startRaw + 1}, ${startColumn + 1}], [${startRaw + 1}, ${startColumn + 2}]" +
                        "[${startRaw + 2}, $startColumn], [${startRaw + 2}, ${startColumn + 1}], [${startRaw + 2}, ${startColumn + 2}]")
            }
        }
    }
}