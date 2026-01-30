package newer.day4

fun main() {
    linearSearch()
}

private fun linearSearch() {
    /**
     * Given an array of integers and a target value, return the index of the first occurrence of the target.
     * If not found, return -1.
     * */
    val arr = intArrayOf(1, 4, 2, 6, 4, 6, 7, 7, 5)
    val arrSorted = intArrayOf(1, 2, 4, 6, 6, 7, 9)
    fun problem1(arr: IntArray, target: Int) : Int {
//         For loop implementation
        for (i in 0 ..arr.lastIndex) {
            if (arr[i] == target) {
                return i
            }
        }
        // While loop implementation
//        var index = 0
//        while (index < arr.size) {
//            if (arr[index] == target) {
//                return index
//            }
//            index++
//        }
        return -1
    }
    println(problem1(arr, 7))

    /**
     * Find the last occurrence of a given element using linear search.
     * */
    fun problem2(arr: IntArray, target: Int): Int {
        var currentIndex = -1
        for (i in 0..arr.lastIndex) {
            if (arr[i] == target) {
                currentIndex = i
            }
        }
        return currentIndex
    }
    println(problem2(arr.copyOf(), 7))

    /**
     * Check whether an array is sorted or not using linear traversal.
     * */
    fun problem3(arr: IntArray) : Boolean {
        for (i in 1 until arr.size) {
            if (arr[i-1] > arr[i]) {
                return false
            }
        }
        return true
    }
    println(problem3(arrSorted))

    /**
     * Count the number of occurrences of a given element in an array.
     * */
    fun problem4(arr: IntArray, target: Int) : Int {
        var occurrences = 0
        for (i in 0 ..arr.lastIndex) {
            if (arr[i] == target) {
                occurrences++
            }
        }
        return occurrences
    }
    println(problem4(arr, 6))
}
