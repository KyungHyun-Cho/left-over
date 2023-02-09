package `jaeguk-cho`.`주차 요금 계산`

/**
 * @author Jaeguk Cho
 */

class `주차 요금 계산` {
    fun solution(fees: IntArray, records: Array<String>): List<Int> {
        return (0 until 10000).map { carNo ->
            records.filter { it.substringAfter(' ').substringBefore(' ').toInt() == carNo }
                .map { it.substringBefore(' ').toUnit() }
                .let { if (it.size % 2 == 1) it + 1439 else it }
                .let { it.chunked(2) { -it.reduce(Int::minus) }.sum() }
        }.filter { it > 0 }.map { calculate(fees, it) }
    }

    fun calculate(fees: IntArray, time: Int): Int {
        return fees[1] + if (time <= fees[0]) 0 else (time - fees[0] + fees[2] - 1) / fees[2] * fees[3]
    }

    fun String.toUnit(): Int {
        return split(':').map { it.toInt() }.let { (h, m) -> h * 60 + m }
    }
}
