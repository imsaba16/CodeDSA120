package sixty

fun main() {
    val arr = intArrayOf(5, 2, 4, 5, 6, 9, 4, 10, 18, 10)
    println(sumOfArray(arr))
    println(findMinimumInArray(arr))
    println(countEventNumbers(arr))
    println(findDuplicateUsingSet(arr).joinToString())
    val count = frequencyCountUsingHashmap(arr)
    println("Keys: ${count.keys.joinToString()} || Values: ${count.values.joinToString()}")
    println(findSecondLargestInArray(arr))
}

private fun findMinimumInArray(arr: IntArray) : Int? {
    if (arr.isEmpty()) return null
    var minimum = arr[0]

    for (a in 1..arr.lastIndex) {
        if (arr[a] < minimum) {
            minimum = arr[a]
        }
    }
    return minimum
}

private fun countEventNumbers(arr: IntArray) : Int {
    if (arr.isEmpty()) return 0
    var count = 0
    for (i in arr) {
        if (i % 2 == 0) {
            count++
        }
    }
    return count
}

private fun sumOfArray(arr: IntArray): Int {
    var sum = 0
    for (a in arr.indices) {
        sum += arr[a]
    }
    return sum
}

private fun findDuplicateUsingSet(arr: IntArray) : Set<Int> {
    val duplicates: MutableSet<Int> = mutableSetOf()
    val seen: MutableSet<Int> = mutableSetOf()

    for (i in arr.indices) {
        if (!seen.contains(arr[i])) {
            seen.add(arr[i])
        } else {
            duplicates.add(arr[i])
        }
    }
    return duplicates
}

private fun frequencyCountUsingHashmap(arr: IntArray) : MutableMap<Int, Int> {
    val count: MutableMap<Int, Int> = mutableMapOf()

    for (i in arr.indices) {
        count[arr[i]] = (count[arr[i]] ?: 0) + 1
    }
    return count
}

//Problem

private fun findSecondLargestInArray(arr: IntArray) : Int? {
    if (arr.isEmpty()) return null
    var largest = arr[0]
    var secondLargest = largest

    for (a in 1..arr.lastIndex) {
        if (arr[a] > largest) {
            secondLargest = largest
            largest = arr[a]
        } else if (largest > arr[a] && arr[a] > secondLargest) {
            secondLargest = arr[a]
        }
    }
    return secondLargest
}