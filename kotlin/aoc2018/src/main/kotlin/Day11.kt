class Day11 {
    fun part1(serialNumber: Int) : Pair<Int, Int> {
        val powerGrid = Array(300) { x ->
            Array(300) { y ->
                getPowerLevel(x+1, y+1, serialNumber)
            }
        }
        return findLargestSquare(powerGrid, 3).key
    }

    private fun findLargestSquare(powerGrid: Array<Array<Int>>, gridSize: Int): Map.Entry<Pair<Int, Int>, Int> {
        val squareMap = mutableMapOf<Pair<Int, Int>, Int>()
        for (x in 0..(300-gridSize)) {
            for (y in 0..(300-gridSize)) {
                var squareSum = 0
                for (rx in 0..(gridSize-1)) {
                    for (ry in 0..(gridSize-1)) {
                        squareSum += powerGrid[x + rx][y + ry]
                    }
                }
                squareMap[Pair(x + 1, y + 1)] = squareSum
            }
        }
        return squareMap.maxBy { it.value }!!
    }

    fun part2(serialNumber: Int) : Triple<Int, Int, Int> {
        val powerGrid = Array(300) { x ->
            Array(300) { y ->
                getPowerLevel(x+1, y+1, serialNumber)
            }
        }
        val tripleMap = mutableMapOf<Triple<Int, Int, Int>, Int>()
        for (size in 1..300) {
            val largeSquare = findLargestSquare(powerGrid, size)
            tripleMap[Triple(largeSquare.key.first, largeSquare.key.second, size)] = largeSquare.value
        }
        return tripleMap.maxBy { it.value }!!.key
    }

    fun getPowerLevel(x: Int, y: Int, serialNumber: Int): Int {
        val rackId = x + 10
        var powerLevel = rackId * y
        powerLevel += serialNumber
        powerLevel *= rackId
        powerLevel = (powerLevel / 100) % 10
        return powerLevel - 5
    }
}