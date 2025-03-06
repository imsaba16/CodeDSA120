package day3

fun main() {
    testInsert()
    testDelete()
    testTraverse()
    testUpdate()
    insertAtFirst()
    deleteElementByValue()
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