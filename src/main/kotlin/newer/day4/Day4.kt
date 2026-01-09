package newer.day4

import java.util.LinkedList

fun queue(): Unit {
    val deque = LinkedList<Int>()

    deque.offerLast(2)
    deque.offerLast(5)
    deque.offerLast(4)
    deque.offerFirst(3)
    deque.offerFirst(1)

}