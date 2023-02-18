package `dongyeon-lee`.`230218`

/* 귤  고르기 */
class Solution {
    fun solution(k: Int, tangerine: IntArray): Int {
        var answer = 0
        var count = 0
        tangerine.groupBy { it }
            .map { it.value.size }
            .sortedByDescending { it }
            .onEach {
                if (count < k) {
                    count += it ; answer ++
                }
            }
        return answer
    }
}