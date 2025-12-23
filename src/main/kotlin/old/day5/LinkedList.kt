package day5

fun main() {
    val linkedList = LinkedList<Int>()
    linkedList.push(5).push(1).push(3)
    linkedList.append(2)
    linkedList.push(8)
    println(linkedList)

}

class LinkedList<T> {
    private var head: Node<T>? = null
    private var tail: Node<T>? = null
    private var size = 0

    fun isEmpty(): Boolean {
        return size == 0
    }

    fun push(value: T): LinkedList<T> {
        head = Node(value, head)
        if (tail == null) {
            tail = head
        }
        size++
        return this
    }

    fun append(value: T) {
        if (isEmpty()) {
            push(value)
            return
        }

        tail?.next = Node(value)
        tail = tail?.next
        size++
    }

    fun nodeAt(index: Int): Node<T>? {
        var currentNode = head
        var currentIndex = 0

        while (currentNode != null && currentIndex < index) {
            currentNode = currentNode.next
            currentIndex++
        }
        return currentNode
    }

    override fun toString(): String {
        return if (isEmpty()) {
            "Empty List"
        } else {
            head.toString()
        }
    }

}