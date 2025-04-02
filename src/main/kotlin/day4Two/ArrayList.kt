package day4Two

fun main() {
    val array = CustomArray<String>()
    array.add("hello")
    array.add("this is the")
    println(array.get(0))
    array.add("this world")
    array.add(("kings"))
    println(array.size())
    println(array.get(2))
    array.removeAt(2)
    println(array.get(2))
    println(array.size())

    val arrayList = arrayListOf(1, 2, 3, 4)
    println(arrayList)
    arrayList.reverseList()
    println(arrayList)
    findMaxMin(arrayList)
}

class CustomArray<T> {
    private var array = arrayOfNulls<Any>(10)
    private var size = 0

    fun add(element: T) {
        if (size == array.size) {
            array = array.copyOf(array.size * 2)
        }
        array[size++] = element
    }

    fun get(index: Int): T {
        if (index < 0 || index >= array.size) throw IndexOutOfBoundsException()

        return array[index] as T
    }

    fun removeAt(index: Int) {
        var ind = index
        if (index < 0 || index >= array.size) throw IndexOutOfBoundsException()
        for (i in index + 1..array.size - 1) {
            array[ind] = array[i]
            ind++
        }
        array = array.copyOf(array.size - 1)
    }

    fun size(): Int {
        return array.size
    }

    fun contains(element: T): Boolean {
        for (i in array) {
            if (i == element)
                return true
        }
        return false
    }

    override fun toString(): String {
        return array.copyOf(size).joinToString()
    }
}

fun <T> ArrayList<T>.reverseList() {
    var left = 0
    var right = this.size -1

    while (left < right) {
        val temp = this[left]
        this[left] = this[right]
        this[right] = temp
        left++
        right--
    }
}

fun findMaxMin(arrayList: ArrayList<Int>) {
    var min = arrayList[0]
    var max = arrayList[0]
    for (i in arrayList.indices) {
        if (max < arrayList[i]) {
            max = arrayList[i]
        }
        if (min > arrayList[i]) {
            min = arrayList[i]
        }
    }
    println("Min: $min || Max: $max")
}

fun removeDuplicates(arrayList: ArrayList<Int>) {

}