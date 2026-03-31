package newer.leetcode.arrays

fun main() {
    val arr = intArrayOf(1,3,2,1)
    println(getConcatenation(arr).joinToString())
    println(shuffle(arr, 2).joinToString())
}

/*
* n == nums.length
1 <= n <= 1000
1 <= nums[i] <= 1000
* */

fun getConcatenation(nums: IntArray): IntArray {
    val n = nums.size
    val ans = IntArray(2 * n)

    for (i in 0 until n) {
        ans[i] = nums[i]
        ans[i + n] = nums[i]
    }

    return ans
}

/*
* [1, 2, 3, 4]
* [1, 3, 2, 4]
* */

fun shuffle(nums: IntArray, n: Int): IntArray {
    val ans = IntArray(nums.size)
    for (i in 0 until n) {
        ans[2 * i] = nums[i]
        ans[2 * i + 1] = nums[i + n]
    }
    return ans
}