package newer.day6

fun main() {
    val arr = intArrayOf(1, 4, 6, 8, 9, 10, 14, 16)
    println(twoPointer(arr.copyOf(), 18))
    val arr2 = arr.copyOf()
    arr2.reverseArray()
    println(arr2.joinToString())
}

// Two Pointers Concepts
private fun twoPointer(arr: IntArray, k: Int): Boolean {
    var left = 0
    var right = arr.lastIndex

    while (left <= right) {
        val sum = arr[left] + arr[right]

        when {
            sum == k -> return true
            sum < k -> left++
            else -> right--
        }
    }
    return false
}

private fun IntArray.reverseArray() {
    val arr = this
    var i = 0
    var j = arr.lastIndex
    while (i < j) {
        val temp = arr[i]
        arr[i] = arr[j]
        arr[j] = temp
        i++
        j--
    }
}