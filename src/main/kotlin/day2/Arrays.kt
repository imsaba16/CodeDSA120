package day2

import kotlin.math.max

fun main() {
    findMaximumElement()
    reverseAnArray()
    println(checkSortedInAscending())
    secondLargestElement()
    moveZeroToEnd()
    rotateArrayByLeft()
//    rotateArrayByRight()
}

fun findMaximumElement() {
    val array = arrayOf(3, 7, 2, 9, 5)
    var temp = array[0] // o(1) space complexity
    for (i in array) { // O(n) time complexity
        if (temp < i) {
            temp = i
        }
    }
    println("Maximum: $temp")
}

fun reverseAnArray() {
    val array = arrayOf(1, 2, 3, 4, 5)
    var left = 0
    var right = array.size - 1
    while (left < right) { // O(log n) time complexity
//        val temp = array[left]
//        array[left] = array[right]
//        array[right] = temp
        array[left] = array[right].also { array[right] == array[left] }
        left++
        right--
    }
    println(array.joinToString())
}

fun checkSortedInAscending(): Boolean {
    val array = intArrayOf(1, 3, 3, 5, 7, 9)
    for (i in 1 until array.size) {
        if (array[i - 1] > array[i]) {
            return false
        }
    }
    return true
}

//Medium
fun secondLargestElement() {
    val array = intArrayOf(-10, -20, -30, -40)
    if (array.size < 2) {
        println("No second largest element")
        return
    }
    var largest = Int.MIN_VALUE
    var secondLargest = Int.MIN_VALUE
    for (i in array) {
        if (i > largest) {
            secondLargest = largest
            largest = i
        } else if (i > secondLargest && i != largest) {
            secondLargest = i
        }
    }
    if (secondLargest == Int.MIN_VALUE) {
        println("No second largest element exists")
    } else {
        println("Second Largest: $secondLargest")
    }
}

fun moveZeroToEnd() {
    val array = intArrayOf(0, 1, 0, 3, 12)
    var nonZeroIndex = 0
    for (i in 0..array.size - 1) {
        if (array[i] != 0) {
            val temp = array[nonZeroIndex]
            array[nonZeroIndex] = array[i]
            array[i] = temp
            nonZeroIndex++
        }
    }
    println(array.joinToString())
}

fun rotateArrayByLeft() {
    var k = 3
    val array = intArrayOf(1, 2, 3, 4, 5)
    var n = array.size
    k = k % n
    fun reverse(array: IntArray, start: Int, end: Int) {
        var left = start
        var right = end
        while (left < right) {
            val temp = array[left]
            array[left] = array[right]
            array[right] = temp
            left++
            right--
        }
    }
    reverse(array, 0, k -1)
    reverse(array, k, n -1)
    reverse(array, 0, n -1)
    println(array.joinToString())
}

fun rotateArrayByRight() {
    TODO()
    var k = 3
    val array = intArrayOf(1, 2, 3, 4, 5)
    var n = array.size
    k = k % n
    fun reverse(array: IntArray, start: Int, end: Int) {
        var left = start
        var right = end
        while (left < right) {
            val temp = array[left]
            array[left] = array[right]
            array[right] = temp
            left++
            right--
        }
    }
    reverse(array, 0, k -1)
    reverse(array, k, n -1)
    reverse(array, 0, n -1)
    println(array.joinToString())
}