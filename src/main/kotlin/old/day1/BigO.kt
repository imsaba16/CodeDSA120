package day1

fun main() {
    println(constantTime())
    println(linearTime(7))
    logarithmicTime()
    linearithmicTime()
//    quadraticTime()
    exponentialTime()
    factorialTime()
}

fun constantTime(): Int {
    /**
     * Accessing an element by index in a list (or array) is an O(1) operation because it takes the same amount of time, regardless of the size of the list.
     * O(1)
     * */
    val list = listOf<Int>(5, 2, 5, 3, 7, 1, 0, 9)
    return list[5]
}

fun linearTime(target: Int): Int {
    /**
     * O(n)
     * */
    val list = listOf<Int>(5, 2, 5, 3, 7, 1, 0, 9)
    list.forEachIndexed { index, data ->
        if (data == target) return index
    }
    return -1
}

fun logarithmicTime() {
    /**
     * O(log n)
     * Reduces the problem size each step (e.g., binary search).
     * */
    fun binarySearch(target: Int): Int {
        val list = listOf<Int>(5, 2, 1, 3, 7)
        println(list.sorted())
        var left = 0
        var right = list.size - 1
        while (left < right) {
            val mid = left + (right - left) / 2
            when {
                list[mid] == target -> return mid
                list[mid] < target -> left = mid + 1
                else -> right = mid - 1
            }
        }
        return -1
    }
    println(binarySearch(3))
}

fun linearithmicTime() {
    /**
     * 0(n log n)
     * 	Used in efficient sorting algorithms (e.g., merge sort, quicksort).
     * */


    fun merge(left: List<Int>, right: List<Int>): List<Int> {
        var i = 0
        var j = 0
        val result = mutableListOf<Int>()

        while (i < left.size && j < right.size) {
            if (left[i] < right[j]) result.add(left[i++]) else result.add(right[j++])
        }
        result.addAll(left.subList(i, left.size))
        result.addAll(right.subList(j, right.size))
        return result
    }

    fun mergeSort(list: List<Int>): List<Int> {
        if (list.size <= 1) return list
        val mid = list.size / 2
        val left = mergeSort(list.subList(0, mid))
        val right = mergeSort(list.subList(mid, list.size))
        return merge(left, right)
    }

    val list = listOf<Int>(5, 2, 5, 3, 7, 1, 0, 9)
    println(mergeSort(list))
}

fun quadraticTime() {
    /**
     * O(n²)
     * Nested loops lead to O(n²) complexity, meaning that for each element, we perform another full iteration.
     * */
    fun printPairs(list: List<Int>) {
        for (i in list.indices) {
            for (j in list.indices) {
                println("${list[i]}, ${list[j]}")
            }
        }
    }

    val list = listOf<Int>(5, 2, 5, 3, 7, 1, 0, 9)
    printPairs(list)
}

fun exponentialTime() {
    /**
     * O(2ⁿ)
     * Doubles with each additional element (e.g., recursive Fibonacci).
     * */
    fun fibonacci(n: Int): Int {
        if (n <= 1) return n
        return fibonacci(n - 1) + fibonacci(n - 2)
    }

    println(fibonacci(6))
}

fun factorialTime() {
    /**
     * O(n!)
     * Extremely inefficient, used in brute-force permutations.
     * */

    fun permutations(string: String, prefix: String = "") {
        if (string.isEmpty()) {
            println(prefix)
        } else {
            for (i in string.indices) {
                permutations(string.removeRange(i, i + 1), prefix + string[i])
            }
        }
    }
    permutations("No")
}