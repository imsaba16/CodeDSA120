package newer.day1

fun <T> permute(nums: List<T>): List<List<T>> {
    val result = mutableListOf<List<T>>()
    if (nums.size == 1) {
        result.add(nums)
        return result
    }

    for (i in nums.indices) {
        val current = nums[i]
        val remaining = nums.filterIndexed { index, _ -> index != i }

        // Recurse to get all permutations of the remaining elements
        for (perm in permute(remaining)) {
            result.add(listOf(current) + perm)
        }
    }

    return result
}

fun main() {
    val nums = listOf(1, 2, 3, 4, 5)
    val permutations = permute(nums)
    println("All permutations of $nums:")
    for (perm in permutations) {
        println(perm)
    }
}