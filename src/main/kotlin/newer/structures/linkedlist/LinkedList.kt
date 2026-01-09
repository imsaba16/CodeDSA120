package newer.structures.linkedlist

class LinkedList<T> {
   private var head: Node<T>? = null

    fun insertAtHead(data: T) {
        val newNode = Node(data = data)
        newNode.next = head
        head = newNode
    }

    fun insertAtEnd(data: T) {
        val newNode = Node(data = data)

        if (head == null) {
            head = newNode
            return
        }
        var current = head
        while (current?.next != null) {
            current = current.next
            return
        }
    }

    fun insertAfter(d1: Node<T>, e: Node<T>) {
        val d2 = d1.next
        e.next = d2
        d1.next = e
    }

    fun remove(n0: Node<T>) {
        if (n0.next == null) {
            return
        }
        val p = n0.next
        val n1 = p?.next
        n0.next = n1
    }
}