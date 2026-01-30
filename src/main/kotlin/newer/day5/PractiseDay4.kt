package newer.day5

fun main() {
    val arr = intArrayOf(2, 4, 6, 7, 8)
    println(binarySearchVar(arr, 6))
    val unArr = intArrayOf(3, 5, 1, 7, 9, 8, 10, 34, 21)
    println(bubbleSortVariation(unArr.copyOf()).joinToString())
    println(insertionSortVariation(unArr.copyOf()).joinToString())
    println(selectionSortVariation(unArr.copyOf()).joinToString())
}
private fun binarySearchVar(arr: IntArray, target: Int) : Int {
    var low = 0
    var high = arr.lastIndex

    while (low <= high) {
        val mid = low + (high - low) / 2
        when {
            arr[mid] == target -> return mid
            arr[mid] < target -> low = mid + 1
            else -> high = mid - 1
        }
    }
    return -1
}

private fun bubbleSortVariation(arr: IntArray) : IntArray {
    val n = arr.size

    for (i in 0 until n - 1) {
        var swapped = false
        for (j in 0 until n - i - 1) {
            if (arr[j] > arr[j +1]) {
                val temp = arr[j]
                arr[j] = arr[j + 1]
                arr[j + 1] = temp
                swapped = true
            }
        }
        if (!swapped) break
    }
    return arr
}

private fun insertionSortVariation(arr: IntArray) : IntArray {
    val n = arr.size

    for (i in 1 until n) {
        val key = arr[i]
        var j = i -1
        while (j >= 0 && arr[j] > key) {
            arr[j+1] = arr[j]
            j--
        }
        arr[j+1] = key
    }
    return arr
}

private fun selectionSortVariation(arr: IntArray) : IntArray {
    val n = arr.size

    for (i in 0 until n -1) {
        var minIndex = i
        for (j in i + 1 until n) {
            if (arr[j] < arr[minIndex]) {
                minIndex = j
            }
        }
        val temp = arr[i]
        arr[i] = arr[minIndex]
        arr[minIndex] = temp
    }
    return arr
}