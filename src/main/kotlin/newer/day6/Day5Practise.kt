package newer.day6

fun main() {
    var arr = intArrayOf(3, 1, 5, 7, 4, 10, 0, 8)
    mergeSort(arr, 0, arr.size - 1)
    println(arr.joinToString())
    println(binarySearchVar2(arr, 7))
}

private fun mergeSort(arr: IntArray, left: Int, right: Int) {
    if (left >= right) return
    val mid = left + (right - left) / 2
    mergeSort(arr, left, mid)
    mergeSort(arr, mid + 1, right)
    merge(arr, left, mid, right)
}

private fun merge(arr: IntArray, left: Int, mid: Int, right: Int) {
    val n1 = mid - left + 1
    val n2 = right - mid

    val leftArr = IntArray(n1)
    val rightArr = IntArray(n2)

    for (i in 0 until n1) leftArr[i] = arr[left + i]
    for (j in 0 until n2) rightArr[j] = arr[mid + 1 + j]

    var i = 0
    var j = 0
    var k = left

    while (i < n1 && j < n2) {
        if (leftArr[i] < rightArr[j]) {
            arr[k++] = leftArr[i++]
        } else {
            arr[k++] = rightArr[j++]
        }
    }

    while (i<n1) arr[k++] = leftArr[i++]
    while (j<n1) arr[k++] = rightArr[j++]
}

private fun binarySearchVar2(arr: IntArray, target: Int) : Int {
    arr.sort()
    var low = 0
    var high = arr.size - 1

    while (low <= high) {
        var mid = low + (high - low) / 2
        when {
            arr[mid] == target -> return mid
            arr[mid] < target -> low = mid + 1
            else -> {
                high = mid - 1
            }
        }
    }
    return -1
}