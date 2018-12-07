class Day03 {
    fun part1(rawValues : List<String>): Int {
        return rawValues
            .flatMap{ it.toClaim().area() }
            .groupingBy { it }
            .eachCount()
            .count { it.value > 1 }
    }

    fun part2(rawValues : List<String>): Int{
        val claimed = mutableMapOf<Pair<Int, Int>, Int>()
        val noOverlap = mutableSetOf<Int>()
        rawValues.forEach { string ->
            val claim = string.toClaim()
            noOverlap.add(claim.id)
            claim.area().forEach { point ->
                val found = claimed.putIfAbsent(point, claim.id)
                if (found != null) {
                    noOverlap.remove(claim.id)
                    noOverlap.remove(found)
                }
            }
        }
        return noOverlap.first()
    }

    fun String.toClaim(): Claim {
        val pattern = """^#(\d+) @ (\d+),(\d+): (\d+)x(\d+)$""".toRegex()
        return pattern.find(this)?.let {
            val (id, left, top, w, h) = it.destructured
            Claim(id.toInt(), left.toInt(), top.toInt(), w.toInt(), h.toInt())
        } ?: throw Exception()
    }
}

data class Claim(val id: Int, val left: Int, val top: Int, val width: Int, val height: Int) {
    fun area(): List<Pair<Int, Int>> =
        (0 + left until width + left).flatMap { w ->
            (0 + top until height + top).map { h ->
                Pair(w, h)
            }
        }
}