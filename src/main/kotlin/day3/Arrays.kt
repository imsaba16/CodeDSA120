package day3

fun main() {
    testInsert()
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