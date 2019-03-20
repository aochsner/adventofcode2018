import java.io.File

class Day12 {
    fun part1(lines: List<String>): Int {
        val puzzle = Puzzle(lines)
        val pots = puzzle.generate(20)
        return pots.asSequence().mapIndexed { index, char ->
            if (char == '#')
                index-(4*20)
            else
                0
        }.sum()
    }

    fun part2(lines: List<String>): Int {
        val puzzle = Puzzle(lines)
        val pots = puzzle.generate(10000)
        return pots.asSequence().mapIndexed { index, char ->
            if (char == '#')
                index-(4*10000)
            else
                0
        }.sum()
    }
}

class Puzzle(lines: List<String>) {
    val initialState = """^initial state: (.+)$""".toRegex().find(lines[0])!!.destructured.component1()
    val rules = (2 until lines.size).associate {
            val (pattern, plant) = """^(.+) => (.)$""".toRegex().find(lines[it])!!.destructured
            pattern to plant[0]
        }

    fun generate(iterations: Int): String {
        var state = initialState
        repeat(iterations) {
            state = "....$state...."
            val nextGeneration = ".".repeat(state.length).toCharArray()
            (2 until state.length-2).forEach {index ->
                nextGeneration[index] = rules.getOrDefault(state.slice(index-2..index+2), '.')
            }
            state = String(nextGeneration)
            println(state)
        }
        return state
    }
}