package core

fun main() {
    println(process(null))
    println(process("H I "))
    println(process("He l LO"))
    println(firstUniqueChar("Hhello"))
    println(firstUniqueChar("aaaccdcc"))
    println(getValidLength("hello"))
    println(getValidLength("  helloo   "))
    println(getValidLength("   "))
    println(getValidLength(null))

    val result = "Kotlin"
        .also { println("A: $it") }
        .let { it.length }
        .also { println("B: $it") }

    println("C: $result")
}

private fun process(input: String?) : String {
    if (input == null) return "EMPTY"
    val res = input.replace(" ", "").lowercase()
    return if (res.length < 3) {
        "TOO_SHORT"
    } else {
        res
    }
}

private fun firstUniqueChar(input: String): Char? {
    val charArr = input.lowercase().toCharArray()
    val mem: HashMap<Char, Int> = hashMapOf()
    for (i in charArr) {
        mem[i] = (mem[i] ?: 0) + 1
    }
    for (l in charArr) {
        if (mem[l] == 1) {
            return l
        }
    }
    return null
}

private fun getValidLength(input: String?): Int {
    if (input.isNullOrBlank()) return 0
    val trimmed  = input.trim()
     return if (trimmed.length > 10) 10 else trimmed.length
}