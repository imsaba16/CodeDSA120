package day4

fun main() {
    val array = intArrayOf(1, 2, 3, 5, 6)
    println(linearSearch(array, 5))
}

fun linearSearch(nums: IntArray, target: Int): Int {
    for(i in nums.indices) {
        if (nums[i] == target)
            return i
    }
    return -1
}