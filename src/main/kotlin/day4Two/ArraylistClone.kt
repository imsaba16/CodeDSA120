package day4Two

fun main() {
    val array: ArraylistClone<Int> = ArraylistClone<Int>()
    println("IsEmpty:: ${array.isEmpty()}")
    array.add(5)
    array.add(6)
    array.add(3)
    array.add(6)
    array.add(9)
    array.add(5)
    array.add(10)
    println("Size: ${array.size()}")
    println("Array data: ${array.joinToString()}")
    array.removeAt(2)
    println("Size: ${array.size()}")
    println("Array data: ${array.joinToString()}")
    array.addAt(20, 2)
    println("Size: ${array.size()}")
    println("Array Data: ${array.joinToString()}")
    println("Contains 2?: ${array.contains(2)}")
    println("Contains 20?: ${array.contains(20)}")
    println("Index Of 20: ${array.indexOf(20)}")
    println("Last Index: ${array.lastIndexOf(6)}")
    println("IsEmpty:: ${array.isEmpty()}")
    println("2nd Element: ${array[2]}")
}

class ArraylistClone<T> : Iterable<T> {
    private var array = arrayOfNulls<Any>(10)
    private var size = 0

    fun add(element: T) {
        if (size == array.size) {
            array = array.copyOf(array.size * 2)
        }
        array[size++] = element
    }


    fun addAt(element: T, index: Int) {
        if (index < 0 || index > size) throw IndexOutOfBoundsException()
        if (size == array.size) array = array.copyOf(array.size * 2)

        for (i in size downTo index +1) {
            array[i] = array[i -1]
        }
        array[index] = element
        size++
    }

    fun size() = size

    fun contains(element: T) : Boolean {
        for (i in array) {
            if (element == i) {
                return true
            }
        }
        return false
    }

    fun isEmpty() : Boolean {
        return size == 0
    }

    fun indexOf(element: T) : Int {
        for (i in 0..size -1) {
            if (element == array[i]) return i
        }
        return  -1
    }

    fun lastIndexOf(element: T) : Int {
        var temp = -1
        for (i in 0 until size) {
            if (element == array[i]) temp = i
        }
        return temp
    }

    operator fun get(index: Int) : T {
        if (index < 0 || index > size) {
            throw IndexOutOfBoundsException("Index is invalid")
        }
        return array[index] as T
    }

    fun removeAt(index: Int) {
        var i = index
        if (index < 0 || index > size) {
            throw IndexOutOfBoundsException("Index is invalid")
        }
        for (i in index until size - 1) {
            array[i] = array[i + 1]
        }
        array[size - 1] = null
        size--
    }

    fun clear() {
        for (i in 0 until size) {
            array[i] = null
        }
        size = 0
    }

    fun clearShrink() {
        array = arrayOfNulls(10)
        size = 0
    }

    override fun iterator(): Iterator<T> = ArrayListCloneIterator()

    private inner class ArrayListCloneIterator: Iterator<T> {
        var index = 0
        override fun next(): T {
            if (!hasNext()) throw NoSuchElementException()
            return array[index++] as T
        }

        override fun hasNext(): Boolean = index < size

    }

}