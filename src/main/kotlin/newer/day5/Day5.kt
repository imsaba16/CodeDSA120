package newer.day5

fun main() {
    val arr: IntArray = intArrayOf(2, 1, 5, 3, 8, 6, 92, 46, 73, 12, 74, 98, 73, 67)
    val arrMS = arr.copyOf()
    mergeSort(arrMS, 0, arr.lastIndex)
    println("Sorted: ${arrMS.joinToString()}")
    val arrQS = arr.copyOf()
    quickSort(arrQS, 0, arr.lastIndex)
    println("QS: ${arrQS.joinToString()}")
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

    while (i < n1) arr[k++] = leftArr[i++]
    while (j < n2) arr[k++] = rightArr[j++]
}

private fun quickSort(arr: IntArray, left: Int, right: Int) {
    if (left < right) {
        val pi = partition(arr, left, right)
        quickSort(arr, left, pi - 1)
        quickSort(arr, pi + 1, right)
    }
}

private fun partition(arr: IntArray, left: Int, right: Int) : Int {
    val pivot = arr[right]
    var i = left - 1

    for (j in left until right) {
        if (arr[j] <= pivot) {
            i++
            val temp = arr[i]
            arr[i] = arr[j]
            arr[j] = temp
        }
    }

    val temp = arr[i + 1]
    arr[i + 1] = arr[right]
    arr[right] = temp

    return i + 1
}