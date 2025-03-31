package day4

fun main() {
    val array = intArrayOf(1, 2, 3, 5, 6)
    val duplicate = intArrayOf(1, 2, 3, 5, 6, 3, 2, 1)
    val rotation = intArrayOf(40, 50, 60, 70, 10, 20, 30)
    println(findIndexOfTargetUsingLinearSearch(array, 3))
    println(binarySearchOnSortedArray(array, 2))
    println(findFirstDuplicate(duplicate))
    println(findFirstDuplicateBruteForce(duplicate))
    println(findRotatedSortedArray(rotation, 20))
}

fun findIndexOfTargetUsingLinearSearch(array: IntArray, target: Int): Int {
    for (i in array.indices) {
        if (array[i] == target)
            return i
    }
    return -1
}

fun binarySearchOnSortedArray(array: IntArray, target: Int): Int {
    var left = 0
    var right = array.size - 1

    while (left <= right) {
        val mid = left + (right - left) / 2

        if (array[mid] == target)
            return mid

        if (array[mid] < target)
            left = mid + 1
        else
            right = mid - 1
    }
    return -1
}

fun findFirstDuplicate(array: IntArray): Int {
    val duplicate = hashSetOf<Int>()
    for (arr in array) {
        if (!duplicate.contains(arr)) {
            duplicate.add(arr)
        } else {
            return arr
        }
    }
    return -1
}

fun findFirstDuplicateBruteForce(array: IntArray): Int {
    for (i in array.indices) {
        for (j in i + 1 until array.size) {
            if (array[i] == array[j]) {
                return array[i]
            }
        }
    }
    return -1
}

fun findRotatedSortedArray(array: IntArray, target: Int): Int {
    var left = 0
    var right = array.size - 1

    while (left <= right) {
        val mid = (left + right) / 2
        if (array[mid] == target)
            return mid

        if (array[left] <= array[mid]) {
            if (target >= array[left] && target < array[mid]) {
                right = mid - 1
            } else {
                left = mid + 1
            }
        } else {
            if (target > array[mid] && target <= array[right]) {
                left = mid + 1
            } else {
                right = mid - 1
            }
        }
    }
    return -1
}