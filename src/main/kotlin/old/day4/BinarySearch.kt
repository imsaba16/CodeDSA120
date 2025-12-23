package day4

fun main() {
    val array = intArrayOf(1, 2, 3, 5, 6)
    println(binarySearch(array, 3))
    println(binarySearchRecursive(array, 0, array.size - 1, 2))
}

fun binarySearch(x: IntArray, y: Int): Int { //Iterative Approach
    var left = 0
    var right = x.size - 1

    while (left <= right) {
        val mid = left + (right - left) / 2
        if (x[mid] == y)
            return mid
        if (x[mid] < y)
            left = mid + 1
        else
            right = mid - 1
    }
    return -1
}

//Recursive Method
fun binarySearchRecursive(array: IntArray, left: Int, right: Int, target: Int): Int {
    if (left > right) return -1

    val mid = left + (right - left) / 2

    return when {
        array[mid] == target -> mid
        array[mid] < target -> binarySearchRecursive(array, mid + 1, right, target)
        else -> binarySearchRecursive(array, left, mid - 1, target)
    }
}