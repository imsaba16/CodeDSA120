package day1

fun main() {
    getLargestNumber()
    sumOfAllElement()
    println("Find Number in Array: ${findNumberInArray(9)}")
}

fun findFirstElement() {
    val list = listOf<Int>(3, 5, 2, 5, 6, 7, 2, 6, 1, 0)
    println(list[0]) // O(1)
}

fun getLargestNumber() { // O(n)
    //Method 1
    val list = listOf<Int>(3, 5, 2, 5, 6, 7, 2, 9, 6, 1, 0)
    val sortedList = list.sorted()
    println("Largest Item: ${sortedList.last()}")
    //Method 2
    var largest = 0
    for (i in list) {
        if (i > largest) {
            largest = i
        }
    }
    println("Largest Item: $largest")
}

fun sumOfAllElement() { // O(n)
    val list = listOf<Int>(3, 5, 2, 5, 6, 7, 2, 9, 6, 1, 0)
    var temp = 0
    for (i in list) {
        temp += i
    }
    println(temp)
}

fun findNumberInArray(target: Int) {
    // Method One
    val list = listOf<Int>(3, 5, 2, 5, 6, 7, 2, 9, 6, 1, 0)
    fun methodOne(): Boolean { // O(n)
        for (i in list) {
            if (i == target) {
                return true
                break
            }
        }
        return false
    }
    println("method1: ${methodOne()}")
    fun binarySearch(list: List<Int>, target: Int): Int {
        val sortedList = list.sorted() // O(n log n)
        var left = 0
        var right = sortedList.size - 1
        while (left <= right) {
            val mid = left + (right - left) / 2
            when {
                sortedList[mid] == target -> return mid
                sortedList[mid] < target -> left = mid + 1
                else -> right = mid - 1
            }
        }
        return -1
    }

    println("method2: ${binarySearch(list, 7)}")
}