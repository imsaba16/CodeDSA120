package day5

fun main() {
    val one = Node(0)
    val two = Node(2)
    val three = Node(65)

    one.next = two
    two.next = three

    println(one)
}

class Node<T>(val value: T, var next: Node<T>? = null) {
    override fun toString(): String {
        return if (next != null) {
            "$value -> $next"
        } else "$value"
    }
}