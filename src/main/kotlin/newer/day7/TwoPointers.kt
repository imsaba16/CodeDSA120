package newer.day7


fun main() {
    var arr = intArrayOf(2, 2, 3, 4, 4, 6, 7, 9, 10, 16)
    println(twoSum(arr, 15).joinToString())
    twoSlowPointers(arr)
    println(arr.joinToString())
    println(twoPointerSlidingWindow(arr, 29))
    println(twoPointersFindTwoNumbersSum(arr, 10).joinToString())
}

private fun twoSum(arr: IntArray, target: Int) : IntArray {
    var i = 0
    var j = arr.size - 1

    while (i < j) {
        when {
            arr[i] + arr[j] > target -> j--
            arr[i] + arr[j] < target -> i++
            else -> return intArrayOf(i, j)
        }
    }
    return intArrayOf()
}
private fun twoSlowPointers(arr: IntArray)  {
    var i = 0
    for (j in 1 until arr.size) {
        if (arr[i] != arr[j]) {
            i++
            arr[i] = arr[j]
        }
    }
}

private fun twoPointerSlidingWindow(arr: IntArray, target: Int): Int {
    var left = 0
    var sum = 0
    var maxLength = 0

    for (right in arr.indices) {
        sum += arr[right]

        while (sum > target) {
            sum -= arr[left]
            left++
        }

        val currentLength = right - left + 1
        maxLength = maxOf(maxLength, currentLength)
    }
    return maxLength
}

private fun twoPointersFindTwoNumbersSum(arr: IntArray, target: Int) : IntArray {
    var i = 0
    var j = arr.lastIndex

    while (i < j) {
        if (arr[i] + arr[j] > target) {
            j--
        } else if (arr[i] + arr[j] < target) {
            i++
        } else {
            return intArrayOf(arr[i], arr[j])
        }
    }

    return intArrayOf()
}