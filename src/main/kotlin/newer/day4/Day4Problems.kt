package newer.day4

fun main() {
    linearSearch()
}

private fun linearSearch() {
    /**
     * Given an array of integers and a target value, return the index of the first occurrence of the target.
     * If not found, return -1.
     * */
    val arr = intArrayOf(4, 2, 6, 1, 4, 6, 7, 7, 5)
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
   /*     for (i in 0..arr.lastIndex) {
            if (arr[i] == target) {
                currentIndex = i
            }
        }*/
        //Provided suggestion
        for (i in arr.lastIndex downTo 0) {
            if (arr[i] == target) {
                return i
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

    /**
     * Find the largest element smaller than X in an unsorted array.
     * */
    fun problem5(arr: IntArray, target: Int): Int {
//        var smallest = arr[0]
        var smallest = Int.MIN_VALUE
        for (i in 0..arr.lastIndex) {
            // Bug in this problem in if condition
//            if (target > arr[i] && smallest < target) {
//                smallest = arr[i]
//            }
            if (arr[i] in (smallest + 1)..<target) {
                smallest = arr[i]
            }
        }
        return smallest
    }
    println(problem5(arr, 6))

    /**
     * Given an array, find the first repeating element.
     * */
    fun problem6(arr: IntArray) : Int {
        var repeatedElement = -1
        for (i in 0..arr.lastIndex) {
            for (j in i + 1 ..arr.lastIndex) {
                if (arr[i] == arr[j]) {
                    repeatedElement = arr[i]
                    return repeatedElement
                }
            }
        }
        return repeatedElement
    }
    println(problem6(arr))

    /**
     * Find the index of the minimum element in an array.
     * */
    fun problem7(arr: IntArray) : Int {
        var index = 0
        for (i in 1 .. arr.lastIndex) {
            if (arr[i] < arr[index]) {
                index = i
            }
        }
        return index
    }
    println(problem7(arr))
}
