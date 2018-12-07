import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.io.File

class Day02Tests {
    @Test
    fun `example`() {
        // act
        val result = Day02().solvePart1(listOf("abcdef", "bababc", "abbcde", "abcccd", "aabcdd", "abcdee", "ababab"))

        // assert
        assertThat(result).isEqualTo(12)
    }

    @Test
    fun `part1`() {
        // arrange
        val values = File(this.javaClass.getResource("input_day2").toURI()).readLines()

        // act
        val result = Day02().solvePart1(values)

        // assert
        assertThat(result).isEqualTo(4980)
    }

    @Test
    fun `example part 2`() {
        // act
        val result = Day02().solvePart2(listOf("abcde", "fghij", "klmno", "pqrst", "fguij", "axcye", "wvxyz"))

        // assert
        assertThat(result).isEqualTo("fgij")
    }

    @Test
    fun `doit part 2`() {
        // arrange
        val values = File(this.javaClass.getResource("input_day2").toURI()).readLines()

        // act
        val result = Day02().solvePart2(values)

        // assert
        assertThat(result).isEqualTo("qysdtrkloagnfozuwujmhrbvx")
    }
}