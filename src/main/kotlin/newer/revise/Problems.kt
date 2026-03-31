package newer.revise

import java.util.Stack

fun main() {
    val arr = intArrayOf(5, 6, 7, 9, 10, 19)
    println(binarySearch(arr, 5))
    println(reverseAnArrayInPlace(arr).joinToString())
    println(reverseAnArrayOutPlace(arr).joinToString())
    reverseAnArrayTwoPointerRecursive(arr, 0, arr.lastIndex)
    println(arr.joinToString())
    println(reverseAnArrayPureRecursive(arr).joinToString())
    println(palindromeTwoPointer("racecar"))
    val arr2 = intArrayOf(2, 4, 6, 7, 10)
    println(twoSum(arr2, 11).joinToString())
    val strs = arrayOf("flower","flow","flight")
    println(longestCommonPrefix(strs))
    println(isValidParanthsis("{{()}}"))
}

private fun binarySearch(arr: IntArray, target: Int) : Int {
    var left = 0
    var right = arr.lastIndex

    while (left <= right) {
        val mid = left + (right - left) / 2

        when {
            arr[mid] == target -> return mid
            arr[mid] < target -> left = mid + 1
            arr[mid] > target -> right = mid - 1
        }
    }
    return -1
}

private fun reverseAnArrayInPlace(arr: IntArray) : IntArray {
    var i = 0
    var j = arr.lastIndex

    while (i < j) {
        val temp = arr[i]
        arr[i] = arr[j]
        arr[j] = temp
        i++
        j--
    }
    return arr
}

private fun reverseAnArrayOutPlace(arr: IntArray) : IntArray {
    val _arr = IntArray(arr.size)
    for ((j, i) in (arr.lastIndex downTo 0).withIndex()) {
        _arr[i] = arr[j]
    }
    return _arr
}

private fun reverseAnArrayTwoPointerRecursive(arr: IntArray, i: Int, j: Int) {
    if (i >= j) return
    val temp = arr[i]
    arr[i] = arr[j]
    arr[j] = temp

    reverseAnArrayTwoPointerRecursive(arr, i + 1, j - 1)
}

private fun reverseAnArrayPureRecursive(arr: IntArray) : IntArray {
    if (arr.size <= 1) return arr
    val first = arr[0]
    val last = arr.sliceArray(1 .. arr.lastIndex)
    val reversedList = reverseAnArrayPureRecursive(last)
    return reversedList + first
}


private fun palindromeTwoPointer(string: String) : Boolean {
    var charset = string.toCharArray()
    var i = 0
    var j = charset.size - 1

    while (i < j) {
        if (string[i] != string[j]) {
            return false
        }
        i++
        j--
    }
    return true
}


private fun twoSum(arr: IntArray, target: Int): IntArray {
    val hash = hashMapOf<Int, Int>()
    for (i in arr.indices) {
        val req = target - arr[i]
        if (hash[req] == null) {
            hash[arr[i]] = i
        } else {
            return intArrayOf(hash[req]!!, i)
        }
    }
    return intArrayOf()
}

fun longestCommonPrefix(strs: Array<String>): String {
    if (strs.isEmpty()) return ""
    for (i in strs[0].indices) {
        var char =  strs[0][i]
        for (j in 1 until strs.size) {
            if (i >= strs[j].length || strs[j][i] != char) {
                return strs[0].substring(0, i)
            }
        }
    }
    return strs[0]
}

fun check() {
    val stack = Stack<Int>()
    stack.push(5)
    stack.push(2)
    stack.push(7)
    println(stack.joinToString())
    println(stack.pop())
    println(stack.joinToString())
}

fun isValidParanthsis(s: String): Boolean {
    val sta = Stack<Char>()

    for (ch in s) {
        if (ch == '(' || ch == '{' || ch == '[') {
            sta.push(ch)
        } else {
            if (sta.isEmpty()) return false

            val top = sta.pop()
            if (
                (ch == ')' && top != '(') ||
                (ch == '}' && top != '{') ||
                (ch == ']' && top != '[')
            ) {
                return false
            }
        }
    }

    return sta.isEmpty()
}