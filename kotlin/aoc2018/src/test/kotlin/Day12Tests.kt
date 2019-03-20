import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.io.File

class Day12Tests {
    @Test
    fun `puzzle example`() {
        // arrange
        val resource = this.javaClass.getResource("example_day12")
        val toURI = resource.toURI()
        val lines = File(toURI).readLines()

        // act
        val puzzle = Puzzle(lines)

        // assert
        assertThat(puzzle.generate(1)).contains("#...#....#.....#..#..#..#")
    }

    @Test
    fun `part 1 example`() {
        // arrange
        val resource = this.javaClass.getResource("example_day12")
        val toURI = resource.toURI()
        val lines = File(toURI).readLines()

        // act
        val result = Day12().part1(lines)

        // assert
        assertThat(result).isEqualTo(325)
    }

    @Test
    fun `part 1`() {
        // arrange
        val resource = this.javaClass.getResource("input_day12")
        val toURI = resource.toURI()
        val lines = File(toURI).readLines()

        // act
        val result = Day12().part1(lines)

        // assert
        assertThat(result).isEqualTo(2571)
    }
    @Test
    fun `part 2`() {
        // arrange
        val resource = this.javaClass.getResource("input_day12")
        val toURI = resource.toURI()
        val lines = File(toURI).readLines()

        // act
        val result = Day12().part2(lines)

        // assert
        assertThat(result).isEqualTo(2571)
    }
}