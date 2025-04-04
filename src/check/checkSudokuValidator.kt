package check

import kotlin.math.sqrt

fun main() {
    checkSudoku(
        name = "should return true when valid Sudoku",
        result = checkIsValidSudoku(
            listOf(
                listOf('5', '3', '-', '-', '7', '-', '-', '-', '-'),
                listOf('6', '-', '-', '1', '9', '5', '-', '-', '-'),
                listOf('-', '9', '8', '-', '-', '-', '-', '6', '-'),
                listOf('8', '-', '-', '-', '6', '-', '-', '-', '3'),
                listOf('4', '-', '-', '8', '-', '3', '-', '-', '1'),
                listOf('7', '-', '-', '-', '2', '-', '-', '-', '6'),
                listOf('-', '6', '-', '-', '-', '-', '2', '8', '-'),
                listOf('-', '-', '-', '4', '1', '9', '-', '-', '5'),
                listOf('-', '-', '-', '-', '8', '-', '-', '7', '9')
            )
        ),
        correctResult = true
    )

    checkSudoku(
        name = "should return false when invalid Sudoku with duplicate in row",
        result = checkIsValidSudoku(
            listOf(
                listOf('5', '3', '3', '-', '7', '-', '-', '-', '-'), // Duplicate '3' in row
                listOf('6', '-', '-', '1', '9', '5', '-', '-', '-'),
                listOf('-', '9', '8', '-', '-', '-', '-', '6', '-'),
                listOf('8', '-', '-', '-', '6', '-', '-', '-', '3'),
                listOf('4', '-', '-', '8', '-', '3', '-', '-', '1'),
                listOf('7', '-', '-', '-', '2', '-', '-', '-', '6'),
                listOf('-', '6', '-', '-', '-', '-', '2', '8', '-'),
                listOf('-', '-', '-', '4', '1', '9', '-', '-', '5'),
                listOf('-', '-', '-', '-', '8', '-', '-', '7', '9')
            )
        ),
        correctResult = false
    )

    checkSudoku(
        name = "should return false when invalid Sudoku with duplicate in column",
        result = checkIsValidSudoku(
            listOf(
                listOf('5', '3', '-', '-', '7', '-', '-', '-', '-'),
                listOf('6', '-', '-', '1', '9', '5', '-', '-', '-'),
                listOf('-', '9', '8', '-', '-', '-', '-', '6', '-'),
                listOf('8', '-', '-', '-', '6', '-', '-', '-', '3'),
                listOf('4', '-', '-', '8', '-', '3', '-', '-', '1'),
                listOf('7', '-', '-', '-', '2', '-', '-', '-', '6'),
                listOf('-', '6', '-', '-', '-', '-', '2', '8', '-'),
                listOf('5', '-', '-', '4', '1', '9', '-', '-', '5'), // Duplicate '5' in column
                listOf('-', '-', '-', '-', '8', '-', '-', '7', '9')
            )
        ),
        correctResult = false
    )

    checkSudoku(
        name = "should return false when invalid Sudoku with duplicate in sub-box",
        result = checkIsValidSudoku(
            listOf(
                listOf('5', '3', '-', '-', '7', '-', '-', '-', '-'),
                listOf('6', '-', '-', '1', '9', '5', '-', '-', '-'),
                listOf('-', '9', '8', '-', '-', '-', '-', '6', '-'),
                listOf('8', '-', '-', '-', '6', '-', '-', '-', '3'),
                listOf('4', '-', '-', '8', '-', '3', '-', '-', '1'),
                listOf('7', '-', '-', '-', '2', '-', '-', '-', '6'),
                listOf('-', '6', '-', '-', '-', '-', '2', '8', '-'),
                listOf('-', '-', '-', '4', '1', '9', '8', '-', '5'), // Duplicate '8' in sub-box
                listOf('-', '-', '-', '-', '8', '-', '-', '7', '9')
            )
        ),
        correctResult = false
    )

    checkSudoku(
        name = "should return true when empty Sudoku board",
        result = checkIsValidSudoku(
            List(9) { List(9) { '-' } }
        ),
        correctResult = true
    )

    checkSudoku(
        name = "should return false when Sudoku board with a single duplicate number",
        result = checkIsValidSudoku(
            listOf(
                listOf('5', '3', '-', '-', '7', '-', '-', '-', '-'),
                listOf('6', '-', '-', '1', '9', '5', '-', '-', '-'),
                listOf('-', '9', '8', '-', '-', '-', '-', '6', '-'),
                listOf('8', '-', '-', '-', '6', '-', '-', '-', '3'),
                listOf('4', '-', '-', '8', '-', '3', '-', '-', '1'),
                listOf('7', '-', '-', '-', '2', '-', '-', '-', '6'),
                listOf('-', '6', '-', '-', '-', '-', '2', '8', '-'),
                listOf('-', '-', '-', '4', '1', '9', '-', '-', '5'),
                listOf('-', '-', '-', '-', '8', '-', '-', '7', '5') // Duplicate '5'
            )
        ),
        correctResult = false
    )
}


fun checkIsValidSudoku(board: List<List<Char>>): Boolean {
    val size = board.size
    val boxSize = sqrt(size.toDouble()).toInt()

    if (board.any { it.size != size }) return false

    if (boxSize * boxSize != size) return false

    val rows = Array(size) { HashSet<Char>() }
    val cols = Array(size) { HashSet<Char>() }
    val boxes = Array(size) { HashSet<Char>() }

    for (i in board.indices) {
        for (j in board[i].indices) {
            val num = board[i][j]
            if (num == '-') continue

            val boxIndex = (i / boxSize) * boxSize + (j / boxSize)

            if (!rows[i].add(num) || !cols[j].add(num) || !boxes[boxIndex].add(num)) {
                return false
            }
        }
    }
    return true
}



fun checkSudoku(name: String, result: Boolean, correctResult: Boolean) {
    if (result == correctResult) {
        println("Pass - $name ")
    } else {
        println("Fail -$name")
    }
}

