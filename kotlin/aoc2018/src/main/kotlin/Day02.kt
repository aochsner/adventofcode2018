class Day02 {
    fun solvePart1(rawValues : List<String>): Int {
        val (twos, threes) = rawValues.fold(Pair(0,0)) { sum, element ->
                val counts = element.asSequence().groupingBy { it }.eachCount()
                Pair(sum.first + if (counts.values.contains(2)) 1 else 0, sum.second + if(counts.values.contains(3)) 1 else 0)
        }
        return twos * threes
    }

    fun solvePart2(rawValues : List<String>): String {
        return rawValues.mapIndexed { i, outer ->
            rawValues.drop(i).mapNotNull {
                val diffIndexes = diffIndexes(outer, it)
                if (diffIndexes.first == 1) {
                    outer.removeRange(diffIndexes.second, diffIndexes.second+1)
                } else null
            }
        }
            .flatten()
            .first()
    }

    fun diffIndexes(a: String, b: String): Pair<Int, Int> {
        var index = 0
        val diff = a.mapIndexed { i, char ->
            if (char != b[i]) {
                index = i
                1
            } else 0
        }.sum()
        return Pair(diff, index)
    }
}