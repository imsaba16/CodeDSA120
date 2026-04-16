package sixty

fun main() {
    val sorted = intArrayOf(2, 3, 4, 4, 5, 6, 7, 7, 8, 8, 10, 11, 13, 14, 14, 15)
    println(removeDuplicatesInSortedArray(sorted))
    val zeros = intArrayOf(2, 3, 0, 4, 5, 0, 6, 0, 7, 0, 0, 0, 8, 9)
    moveZeroToEnd(zeros)
    println(zeros.joinToString())
}

private fun removeDuplicatesInSortedArray(arr: IntArray) : Int{
    if (arr.isEmpty()) return 0
    var i = 0

    for (j in 1 until arr.size) {
        if (arr[i] != arr[j]) {
            i++
            arr[i] = arr[j]
        }
    }
    return i + 1
}


private fun moveZeroToEnd(arr: IntArray) {
    if (arr.isEmpty()) return
    var i = 0

    for (j in arr.indices) {
        if (arr[j] != 0) {
            if (arr[i] != arr[j]) {
                val temp = arr[j]
                arr[j] = arr[i]
                arr[i] = temp
            }
            i++
        }
    }
}