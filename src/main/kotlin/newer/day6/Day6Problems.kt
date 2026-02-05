package newer.day6

fun main() {
    val arr = intArrayOf(2, 5, 7, 9, 1, 4, 2, 7, 4, 0, 10)
    val arr2 = arr.copyOf()
    reverseArrayOfInt(arr2)
    println(arr2.joinToString())
    reverseString("Hello World!")
    println(palindromeCheck("level"))
    println(removeDuplicates())
    moveZeroToEnd()
    mergeTwoSortedArray()
}

/**
 * Reverse an Array:
 * Reverse the given array in-place.
 */
private fun reverseArrayOfInt(arr: IntArray) {
    var i = 0
    var j = arr.size - 1

    while (i < j) {
        val temp = arr[i]
        arr[i] = arr[j]
        arr[j] = temp
        i++
        j--
    }
}

/**
 * Reverse a String
 * Reverse a string using two pointers.
 * */

private fun reverseString(str: String) {
    var char = str.toCharArray()
    var i = 0
    var j = char.size - 1
    while (i < j) {
        val temp = char[i]
        char[i] = char[j]
        char[j] = temp
        i++
        j--
    }
    println(char.joinToString(separator = ""))
}

/**
 * Check Palindrome (String)
 * Check if a string is a palindrome.
 * */
private fun palindromeCheck(str: String): Boolean {
    var arr = str.toCharArray()
    var i = 0
    var j = arr.size - 1
    while (i < j) {
        if (arr[i] != arr[j]) {
            return false
        }
        i++
        j--
    }
    return true
}

/**
 * Remove Duplicates from Sorted Array
 * Return the length after removing duplicates in-place.
 * */
private fun removeDuplicates() : Int {
    val arr = intArrayOf(1, 2, 2, 4, 4, 5, 6, 7, 7)
    if (arr.isEmpty()) return 0
    var slow = 0
    for (fast in 1 until arr.size) {
        if (arr[slow] != arr[fast]) {
            slow += 1
            arr[slow] = arr[fast]
        }
    }
    return slow + 1
}

/**
 * Move All Zeros to End
 * Move all zeros to the end while keeping order.
 **/
private fun moveZeroToEnd() {
    val arr = intArrayOf(2, 5, 0, 3, 0, 0, 6, 0, 1, 8, 9, 0)
    var i = 0
    for (j in 0 until arr.size) {
        if (arr[j] != 0) {
            val temp = arr[j]
            arr[j] = arr[i]
            arr[i] = temp
            i += 1
        }
    }
    println(arr.joinToString())
}

/**
 * Merge Two Sorted Arrays
 * Merge two sorted arrays into one sorted array.
 **/
private fun mergeTwoSortedArray() {
    val arr1 = intArrayOf(1, 4, 5, 6, 8)
    val arr2 = intArrayOf(2, 3, 7)
    var i = 0
    var j = 0
    var k = 0
    val resArr = IntArray(arr1.size + arr2.size)
    while (i < arr1.size && j < arr2.size) {
        if (arr1[i] <= arr2[j]) {
            resArr[k] = arr1[i]
            i += 1
        } else {
            resArr[k] = arr2[j]
            j += 1
        }
        k++
    }
    while (i < arr1.size) {
        resArr[k] = arr1[i]
        i += 1
        k++
    }
    while (j < arr2.size) {
        resArr[k] = arr2[j]
        j += 1
        k++
    }
    println(resArr.joinToString())
}