class Day01 {
    fun <T> Sequence<T>.repeat() = sequence { while (true) yieldAll(this@repeat) }

    fun solvePart1(rawValues : List<String>): Int {
        return rawValues.map { it.toInt() }.sum()
    }

    fun solvePart2(rawValues: List<String>): Int {
        val frequencies = hashSetOf(0)
        var sum = 0
        return rawValues.asSequence().repeat().map {
            sum += it.toInt()
            sum
        }.first{!frequencies.add(it)}
    }
}