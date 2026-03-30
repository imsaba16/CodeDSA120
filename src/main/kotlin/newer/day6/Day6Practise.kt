package newer.day6

fun main() {
    val arr = byteArrayOf(1, 3, 5, 6, 8)
    arr.shuffle()
    println(binarySearch(arr, 8))
}

private fun binarySearch(arr: ByteArray, target: Byte) : Int {
    var left: Int = 0
    var right: Int = arr.size - 1
    while (left <= right) {
        val mid = left + (right - left) / 2
        when {
            arr[mid] == target -> return mid
            arr[mid] < target -> left = mid + 1
            else -> right = mid - 1
        }
    }
    return -1
}