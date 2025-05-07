package day4Two

fun main() {
    val singlyLinkedList = SinglyLinkedList<Int>()
    singlyLinkedList.addFirst(5)
    singlyLinkedList.addFirst(2)
    singlyLinkedList.addFirst(77)
    singlyLinkedList.addLast(4)
    singlyLinkedList.printList()
}


class SinglyLinkedList<T> : Iterable<T> {

    inner class Node<T>(var data: T) {
        var next: Node<T>? = null
    }

    private var head: Node<T>? = null

    fun addFirst(element: T) {
        val newNode = Node(element)
        newNode.next = head
        head = newNode
    }

    fun addLast(element: T) {
        val newNode = Node(element)
        if (head == null) {
            head = newNode
        } else {
            var current = head
            while (current?.next != null) {
                current = current.next
            }
            current?.next = newNode
        }
    }

    fun removeFirst() : T? {
        val currentData = head?.data
        head = head?.next
        return currentData
    }

    fun printList() {
        var current = head
        while (current != null) {
            println("${current.data} ->")
            current = current.next
        }
        println(null)
    }

    override fun iterator(): Iterator<T> {
        return SingleLinkedListIterator()
    }

    private inner class SingleLinkedListIterator: Iterator<T> {
        var current = head
        override fun next(): T {
            val data = current?.data ?: throw NoSuchElementException()
            current = current?.next
            return data
        }

        override fun hasNext(): Boolean  = current != null

    }
}

