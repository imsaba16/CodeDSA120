package day3

fun main() {
    testInsert()
    testDelete()
    testTraverse()
    testUpdate()
    insertAtFirst()
    deleteElementByValue()
    sumOfAllElements()
    smallestAndLargest()
    reverseAnArray()
    countOccurrence()
    checkIfArrayContainsElement()
    moveEvenNumbersToStart()
    findSecondLargestElement()
    rotateLeftByK()
    rotateRightByK()
}

fun testInsert() {
    fun insertElement(arr: IntArray, index: Int, value: Int): IntArray {
        if (arr.size < index || index < 0) {
            println("Invalid Index")
            return arr
        }
        val array = IntArray(arr.size + 1)

        for (i in 0 until index) {
            array[i] = arr[i]
        }
        array[index] = value

        for (i in index until arr.size) {
            array[i + 1] = arr[i]
        }
        return array
    }

    val array = intArrayOf(1, 2, 3, 5, 6)
    val newArray = insertElement(array, 3, 4)
    println(newArray.joinToString())
}

fun testDelete() {
    fun deleteElement(array: IntArray, index: Int): IntArray {
        if (index < 0 || index >= array.size) {
            println("Invalid index")
            return array
        }
        val arr = IntArray(array.size - 1)
        for (i in 0 until index) {
            arr[i] = array[i]
        }
        for (i in (index + 1) until array.size) {
            arr[i - 1] = array[i]
        }
        return arr
    }

    val array = intArrayOf(1, 2, 3, 4, 5)
    val newArray = deleteElement(array, 2)
    println(newArray.joinToString())
}

fun testTraverse() {
    val array = intArrayOf(10, 20, 30, 40, 50)
    for (element in array) {
        println("Element: $element")
    }
}

fun testUpdate() {
    fun updateElement(arr: IntArray, index: Int, value: Int): IntArray {
        if (index < 0 || index > arr.size) {
            println("Invalid Index")
            return arr
        }
        arr[index] = value
        return arr
    }

    val array = intArrayOf(1, 2, 3, 5, 6)
    val newArray = updateElement(array, 3, 4).apply { updateElement(array, 4, 5) }
    println(newArray.joinToString())
}

fun insertAtFirst() {
    // O (n) Space
    // O (n) Time
    val array = intArrayOf(2, 3, 4, 5)
    val dupe = IntArray(array.size + 1)
    dupe[0] = 1
    for (i in 0 until array.size) {
        dupe[i + 1] = array[i]
    }
    println(dupe.joinToString())
}

fun deleteElementByValue() {
    val target = 30
    val array = intArrayOf(10, 20, 30, 40, 30, 50)
    val count = array.count { it == target }

    if (count == 0) {
        println("Element not found")
        return
    }

    val dupe = IntArray(array.size - count)
    var index = 0
    for (e in array) {
        if (e != target) {
            dupe[index] = e
            index++
        }
    }
    println(dupe.joinToString())
}

fun sumOfAllElements() {
    val array = intArrayOf(1, 2, 3, 4, 5)
    var sum = 0
    for (e in array) {
        sum += e
    }
    println("Sum: $sum")
}

fun smallestAndLargest() {
    val array = intArrayOf(7, 2, 9, 1, 5, -10, -20, 100, 394, 4245, -3294)
    var smallest = array[0]
    var largest = array[0]

    for (e in array) {
        if (e < smallest) {
            smallest = e
        }
        if (e > largest) {
            largest = e
        }
    }
    println("Smallest: $smallest || Largest: $largest")
}

fun reverseAnArray() {
    val array = intArrayOf(1, 2, 3, 4, 5)
    var left= 0
    var right = array.size -1

    while (left < right) {
        val temp = array[left]
        array[left] = array[right]
        array[right] = temp
        left++
        right--
    }
    println(array.joinToString())
}

fun countOccurrence() {
    val array = intArrayOf(1, 2, 3, 2, 4, 2)
    val target = 2
    var count = 0
    for (element in array) {
        if (element == target)
            count++
    }
    println("Count: $count")
}

fun checkIfArrayContainsElement() {
    val array = intArrayOf(4, 7, 1, 9)
    val value = 7
    for(element in array) {
        if ( element == value) {
            println("Value is Available")
            break
        }
    }
}

fun moveEvenNumbersToStart() {
    // var left = 0
    // var right = array.size -1

    // while(left < right) {
    //     if (array[left] % 2 == 0) {
    //         left++
    //     }
    //     if(array[right] % 2 != 0) {
    //         right--
    //     }
    //     if(array[left] % 2 != 0 && array[right]% 2 == 0) {
    //         val temp = array[left]
    //         array[left] = array[right]
    //         array[right] = temp
    //         left++
    //         right--
    //     }
    // }
    // println(array.joinToString())

    //Issue with a code fix later
    val array = intArrayOf(1, 2, 3, 4, 5, 6)
    var index = 0
    for (i in array.indices) {
        if (array[i] % 2 == 0) {
            if (i != index) {
                val temp = array[i]
                array[i] = array[index]
                array[index] = temp
            }
            index++
        }
    }
    println(array.joinToString())
}

fun findSecondLargestElement() {
    val array = intArrayOf(12, 35, 1, 10, 34, 1)
    var largest = Int.MIN_VALUE
    var secondLargest = Int.MIN_VALUE

    for(i in array) {
        if (i > largest) {
            largest = i
        } else if (i < largest && i > secondLargest) {
            secondLargest = i
        }
    }

    println("Largest: $largest || Second: $secondLargest")
}   

fun rotateLeftByK() {
    val array = intArrayOf(1, 2, 3, 4, 5)
    var k = 2
    val n = array.size
    k = k % n
    rotate(array, 0, k -1)
    rotate(array, k, n -1)
    rotate(array, 0, n-1)
    println(array.joinToString())    
}

fun rotateRightByK() {
    val array = intArrayOf(1, 2, 3, 4, 5)
    var k = 2
    val n = array.size
    k = k%n
    rotate(array, 0, n - 1)
    rotate(array, 0, k - 1) 
    rotate(array, k, n - 1)
    println(array.joinToString())
    println(2%5)
}

fun rotate(arr: IntArray, start: Int, end: Int) {
    var left = start
    var right = end

    while(left< right) {
        val temp = arr[left]
        arr[left] = arr[right]
        arr[right] = temp
        left++
        right--
    }
}