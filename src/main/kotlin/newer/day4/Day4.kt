package newer.day4

fun main() {
    draft()
    arrayPitfall()
    arrayTraversal()
    arraySearching()
    arrayLowerAndUpperBounds()
    arraySorting()
}

fun draft() {
    println("\n \n")
    println("-----------------------------------------------------------")
    println("--------------------------DRAFT----------------------------")
    println(0 + (9-0) /2)

    println("-----------------------------------------------------------")
    println("\n \n")
}

//Common Pitfalls in Kotlin Based DSA in Array Concepts
fun arrayPitfall() {
    /**
     * Use this IntArray instead of Array<Int>
     * IntArray create primitive Int, where Array<Int> create
     * Object<Integer>
     * */
    val arr = IntArray(5)

    println(arr[3]) // Default Values can trick
    println("Array Size: ${arr.size}")
    for (i in 0 until arr.size ) {
        arr[i] = i + 1
    }

    // can use arr.size with until or arr.indices directly
    // both are same
    for (i in 0  until arr.size) {
        print(arr[i])
    }
    println()
    for (i in arr.indices) {
        print(arr[i])
    }
    println()

    // arrays are mutable reference are shared
    val b = arr
    b[2] = 10
    println(arr[2])
    // correct way to do it
    val c = arr.copyOf()
    c[2] = 11
    println(arr[2])

    val arrSorted = arr.sorted() // returns list<int>, extra memory and lose array form
    val arrSort = arr.sort() // In-Place sort = low memory

    // Don't use collection instead of array
    val coll = mutableListOf<Int>()

    // Careful when using arr.size - 1 or instead use arr.lastIndex
    val lastElement = arr.lastIndex

}

fun arrayTraversal() {
    val arr = IntArray(5)
    for (i in arr.indices) {
        arr[i] = i * i + 1
    }
    println("Array: ${arr.joinToString()}")

    // access first
    println(arr.first())
    println(arr[0])
    // access last
    println(arr.last())
    println(arr[arr.size - 1])
    println(arr[arr.lastIndex])
    // traverse through array using for
    for (i in 0 until arr.size) {
        print("${arr[i]} ")
    }
    println()
    for (i in arr) {
        print("$i ")
    }
    println()
    arr.forEach { e -> //Avoid using this for each
        print("$e ")
    }
    println()
    // traverse array through while loop
    var index = 0
    while (index < arr.size) {
        print("${arr[index]} ")
        index++
    }
    println()

    /**
     * Array has fixed size so adding new element or deleting an element was not possible
     * instead when adding a new element to an array it creates a new array and copy all the old element array to it
     * deleting the element in array doesn't actually delete the element instead it change the element to zero.
     * */
}

fun arraySearching() {
    val arr = intArrayOf(2, 7, 6, 89, 11)
    fun linearSearchReturnsIndex(arr: IntArray, target: Int): Int {
        for (i in arr.indices) {
            if (arr[i] == target) {
                return i
            }
        }
        return -1
    }
    println(linearSearchReturnsIndex(arr, 6))

    fun binarySearch(arr: IntArray, target: Int): Int {
        arr.sort()
        var left = 0
        var right = arr.lastIndex

        while (left <= right) {
            val mid = left + (right - left) / 2
            when {
                arr[mid] == target -> return mid
                arr[mid] < target -> left = mid + 1
                else -> {
                    right = mid - 1
                }
            }
        }
        return  -1
    }
    println(binarySearch(arr, 89))

    fun firstOccurrencesInBinarySearch(target: Int): Int {
        val arr = intArrayOf(1, 2, 2, 2, 3)
        var left = 0
        var right = arr.size - 1
        var ans = -1
        while (left <= right) {
            val mid = left + (right - left) / 2
            when {
                arr[mid] == target -> {
                    ans = mid
                    right = mid -1
                }
                arr[mid] < target -> left = mid + 1
                else -> right = mid -1
            }
        }
        return ans
    }
    println(firstOccurrencesInBinarySearch(2))

    fun lastOccurrencesInBinarySearch(target: Int): Int {
        val arr = intArrayOf(1, 2, 2, 2, 3)
        var left = 0
        var right = arr.size - 1
        var ans = -1

        while (left <= right) {
            val mid = left + (right - left) / 2
            when {
                arr[mid] == target -> {
                    ans = mid
                    left = mid + 1
                }
                arr[mid] < target -> left = mid + 1
                else -> {
                    right = mid - 1
                }
            }
        }
        return ans
    }
    println(lastOccurrencesInBinarySearch(2))
}

fun arrayLowerAndUpperBounds() {
    println("--------------arrayLowerAndUpperBounds-----------------")
    val arr = intArrayOf(1, 2, 4, 4, 4, 6, 8)
    fun lowerBound(arr: IntArray, target: Int) : Int {
        var low = 0
        var high = arr.size
        while (low < high) {
            val mid = low + (high - low) / 2

            if (arr[mid] < target) {
                low = mid + 1
            } else {
                high = mid
            }
        }
        return low
    }
    println(lowerBound(arr, 4))

    fun upperBound(arr: IntArray, target: Int) : Int {
        var low = 0
        var high = arr.size

        while (low < high) {
            val mid = low + (high - low) / 2
            if (arr[mid] <= target) {
                low = mid + 1
            } else {
                high = mid
            }
        }
        return low
    }

    println(upperBound(arr, 4))
    println("Count Duplicate: ${upperBound(arr, 4) - lowerBound(arr, 4)}")
}

fun arraySorting() {
    println("--------------arraySorting-----------------")
    val array = intArrayOf(1, 5, 4, 2, 7, 2, 8, 3)

    fun bubbleSort(arr: IntArray) : IntArray {
        val n = arr.size
        for (i in 0 until n - 1) {
            for (j in 0 until n - i - 1) {
                if (arr[j] > arr[j + 1]) {
                    val temp = arr[j]
                    arr[j] = arr[j + 1]
                    arr[j + 1] = temp
                }
            }
        }
        return arr
    }
    println(bubbleSort(array.copyOf()).joinToString())

    fun selectionSort(arr: IntArray) : IntArray {
        val n = arr.size
        for (i in 0 until n - 1) {
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
    println(selectionSort(array.copyOf()).joinToString())

    fun insertionSort(arr: IntArray) : IntArray {
        val n = arr.size
        for (i in 1 until n) {
            val key = arr[i]
            var j = i - 1
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j]
                j--
            }
            arr[j + 1] = key
        }
        return arr
    }
    println(insertionSort(array.copyOf()).joinToString())
}