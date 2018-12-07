import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.io.File

class Day01Tests {
    @Test
    fun `simple test`() {
        // act
        val result = Day01().solvePart1(listOf("+1", "-1"))

        // assert
        assertThat(result).isEqualTo(0)
    }

    @Test
    fun `do it part 1`() {
        // arrange
        val values = File(this.javaClass.getResource("input_day1").toURI()).readLines()

        // act
        val result = Day01().solvePart1(values)

        // assert
        assertThat(result).isEqualTo(547)
    }

    @Test
    fun `part2 +1, -1`() {
        // act
        val result = Day01().solvePart2(listOf("+1", "-1"))

        // assert
        assertThat(result).isEqualTo(0)
    }

    @Test
    fun `part2 +3, +3, +4, -2, -4`() {
        // act
        val result = Day01().solvePart2(listOf("+3", "+3", "+4", "-2", "-4"))

        // assert
        assertThat(result).isEqualTo(10)
    }

    @Test
    fun `part2 -6, +3, +8, +5, -6`() {
        // act
        val result = Day01().solvePart2(listOf("-6", "+3", "+8", "+5", "-6"))

        // assert
        assertThat(result).isEqualTo(5)
    }

    @Test
    fun `do it part 2`() {
        // arrange
        val values = File(this.javaClass.getResource("input_day1").toURI()).readLines()

        // act
        val result = Day01().solvePart2(values)

        // assert
        assertThat(result).isEqualTo(76414)
    }
}