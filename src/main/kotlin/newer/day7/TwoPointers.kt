package newer.day7


fun main() {
    var arr = intArrayOf(2, 4, 5, 6, 7, 9, 10, 16)
    println(twoSum(arr, 15).joinToString())
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