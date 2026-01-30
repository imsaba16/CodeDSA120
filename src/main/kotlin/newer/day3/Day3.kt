package newer.day3

import kotlin.random.Random

fun main() {
    val array = arrayOf(5, 3, 2, 5, 3, 7, 9)
    println(randomAccess(array.copyOf()))
    println(array.joinToString())
    println(insertingElement(array.copyOf(), 2, 1).joinToString())
    println(deletingElement(array.copyOf(), 2).joinToString())
    println(findingElement(array.copyOf(), 7))
    expandingArray(array.copyOf(), 5)
}

fun fibonacci(n: Int): Int {
    if (n == 1 || n == 2) return n - 1
    return fibonacci(n - 1) + fibonacci(n - 2)
}

fun randomAccess(n: Array<Int>): Int {
    val randomIndx = Random.nextInt(0, n.size)
    val randomNumber = n[randomIndx]
    Int.MAX_VALUE
    return randomNumber
}

fun insertingElement(array: Array<Int>, index: Int, element: Int): Array<Int> {
    if (index < 0) return arrayOf()
    for (i in array.size - 1 downTo index) {
        array[i] = array[i - 1]
    }
    array[index] = element
    return array
}

fun deletingElement(array: Array<Int>, index: Int): Array<Int> {
    if (index < 0) return arrayOf()
    for (i in index + 1..<array.size) {
        array[i - 1] = array[i]
    }
    array[array.size - 1] = 0
    return array
}

fun findingElement(arr: Array<Int>, element: Int): Int {
    var index = -1
    for (i in arr.indices) {
        if (element == arr[i]) {
            index = i
            break
        }
    }
    return index
}

fun expandingArray(array: Array<Int>, size: Int) {
    val arr = Array(array.size + size) {0}
    for (i in array.indices) {
        arr[i] = array[i]
    }
    println(arr.joinToString())
}