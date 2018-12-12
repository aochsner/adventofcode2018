class Day04 {
    fun part1(rawValues: List<String>): Int {
        val guardMap = parseAndGroupMinutesByGuard(rawValues)
        return guardMap.maxBy { it.value.size }!!
            .run { key * value.groupBy { it }.maxBy { it.value.size }!!.key }
    }

    private fun parseAndGroupMinutesByGuard(rawValues: List<String>): MutableMap<Int, List<Int>> {
        val guardPattern = """^.+ Guard #(\d+) begins shift$""".toRegex()
        val timePattern = """^\[.+:(\d\d)] .+$""".toRegex()
        var currentGuard = -1
        var startTime = 0
        val guardMap = mutableMapOf<Int, List<Int>>()
        rawValues.sorted().forEach {
            when {
                guardPattern.matches(it) -> currentGuard = guardPattern.find(it)!!.destructured.component1().toInt()
                it.contains("asleep") -> startTime = timePattern.find(it)!!.destructured.component1().toInt()
                else -> {
                    guardMap.put(currentGuard, guardMap.getOrPut(currentGuard) {mutableListOf()}.plus((startTime until timePattern.find(it)!!.destructured.component1().toInt()).toList()))
                }
            }
        }
        return guardMap
    }

    fun part2(rawValues: List<String>): Int {
        val guardMap = parseAndGroupMinutesByGuard(rawValues)
        return guardMap.flatMap {
            it.value.map { minute ->
                it.key to minute // Guard to Minute
            }
        }
            .groupBy { it }.maxBy { it.value.size }!!.key!!
            .run { first * second }
    }
}