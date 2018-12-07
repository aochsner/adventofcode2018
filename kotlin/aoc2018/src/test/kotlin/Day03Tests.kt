import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.io.File

class Day03Tests {
    @Test
    fun `example part 1`() {
        // act
        val result = Day03().part1(listOf(
            "#1 @ 1,3: 4x4",
            "#2 @ 3,1: 4x4",
            "#3 @ 5,5: 2x2"
        ))

        // assert
        assertThat(result).isEqualTo(4)
    }
    @Test
    fun `do it part 1`() {
        // arrange
        val values = File(this.javaClass.getResource("input_day3").toURI()).readLines()


        // act
        val result = Day03().part1(values)

        // assert
        assertThat(result).isEqualTo(115242)
    }

    @Test
    fun `example part 2`() {
        // act
        val result = Day03().part2(listOf(
            "#1 @ 1,3: 4x4",
            "#2 @ 3,1: 4x4",
            "#3 @ 5,5: 2x2"
        ))

        // assert
        assertThat(result).isEqualTo(3)
    }

    @Test
    fun `do it part 2`() {
        // arrange
        val values = File(this.javaClass.getResource("input_day3").toURI()).readLines()


        // act
        val result = Day03().part2(values)

        // assert
        assertThat(result).isEqualTo(1046)
    }
}