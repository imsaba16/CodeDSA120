package day4

fun main() {
    val matrix = arrayOf(
        intArrayOf(1, 2, 3),
        intArrayOf(4, 10, 61),
        intArrayOf(17, 8, 9)
    )
    println(findMaximumNumberIn2DArray(matrix))
    print2DArrayInSpiralOrder(matrix)
}

fun findMaximumNumberIn2DArray(arr: Array<IntArray>): Int {
    var max = Int.MIN_VALUE
    for (i in arr.indices) {
        for (j in arr[i].indices) {
            if (arr[i][j] > max) {
                max = arr[i][j]
            }
        }
    }
    return max
}

fun print2DArrayInSpiralOrder(arr: Array<IntArray>) {
    if (arr.isEmpty()) return

    var top = 0
    var bottom = arr.size - 1
    var left = 0
    var right = arr[0].size - 1

    while (top <= bottom && left <= right) {
        for (i in left..right) print("${arr[top][i]} ")
        top++

        for (i in top.. bottom) print("${arr[i][right]} ")
        right--

        if (top <= bottom) {
            for (i in right downTo left) print("${arr[bottom][i]} ")
            bottom--
        }

        if (left <= right) {
            for (i in bottom downTo top) print("${arr[i][left]} ")
            left++
        }
    }
}