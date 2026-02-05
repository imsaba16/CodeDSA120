package newer.day5

fun main() {
    val arr = intArrayOf(3, 2, 7, 5, 10, 59, 75, 47, 69, 234)
    mergeSort(arr, 0, arr.size -1)
    println(arr.joinToString())
}

private fun mergeSort(arr: IntArray, left: Int, right: Int) {
    if (left >= right) return
    val mid = left + (right - left) / 2
    mergeSort(arr, left, mid)
    mergeSort(arr, mid + 1 , right)
    merge(arr, left, mid, right)

}

private fun merge(arr: IntArray, left: Int, mid:Int, right: Int) {
    val n1 = mid - left + 1
    val n2 = right - mid

    val leftArray = IntArray(n1)
    val rightArray = IntArray(n2)

    for (i in 0 until n1) leftArray[i] = arr[left + i]
    for (j in 0 until n2) rightArray[j] = arr[mid + 1 + j]

    var i = 0
    var j = 0
    var k = left

    while (i < n1 && j < n2) {
        if (leftArray[i] < rightArray[j]) {
            arr[k++] = leftArray[i++]
        } else {
            arr[k++] = rightArray[j++]
        }
    }

    while (i < n1) arr[k++] = leftArray[i++]
    while (j < n2) arr[k++] = rightArray[j++]
}
