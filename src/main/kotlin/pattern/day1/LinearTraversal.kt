package pattern.day1

fun main() {
    val arr = intArrayOf(2, 4, 5, 1, 8, 5, 23, 129, 8, 19, 19, 492, 49)
    println(findMaximumElementInArray(arr))
    println(countEvenNumbers(arr))
    println(findSecondLargestElement(arr))
    println(reverseAnArray(arr).joinToString())
    println(findSecondLargestElement(arr))
    println(removeDuplicatesFromArray(arr).joinToString())
}

private fun findMaximumElementInArray(arr: IntArray) : Int? {
    if (arr.isEmpty()) return null
    var maximum = arr[0]

    for (i in arr.indices) {
        if (arr[i] > maximum)
            maximum = arr[i]
    }
    return maximum
}

private fun countEvenNumbers(arr: IntArray) : Int {
    if (arr.isEmpty()) return 0
    var count = 0
    for (i in arr.indices) {
        if (arr[i] % 2 == 0) {
            count += 1
        }
    }
    return count
}

private fun reverseAnArray(arr: IntArray) : IntArray {
    if (arr.isEmpty()) return arr
    var i = 0
    var j = arr.lastIndex

    while (i <= j) {
        val temp = arr[i]
        arr[i] = arr[j]
        arr[j] = temp
        i++
        j--
    }
    return arr
}

private fun findSecondLargestElement(arr: IntArray) : Int {
    var largest = 0
    var secondLargest = largest

    for (i in arr.indices) {
        if (arr[i] > largest) {
            secondLargest = largest
            largest = arr[i]
        } else if (arr[i] < largest && arr[i] > secondLargest) {
            secondLargest = arr[i]
        }
    }
    return secondLargest
}

private fun removeDuplicatesFromArray(arr: IntArray): MutableSet<Int> {
    val seen: MutableSet<Int> = mutableSetOf()

    for (i in arr.indices) {
        if (!seen.contains(arr[i])) {
            seen.add(arr[i])
        }
    }
    return seen
}
