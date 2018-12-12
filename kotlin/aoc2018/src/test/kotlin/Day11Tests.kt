import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat

class Day11Tests {
    @Test
    fun `power levels`() {
        assertThat(Day11().getPowerLevel(122, 79, 57)).isEqualTo(-5)
        assertThat(Day11().getPowerLevel(217, 196, 39)).isEqualTo(0)
        assertThat(Day11().getPowerLevel(101, 153, 71)).isEqualTo(4)
    }

    @Test
    fun `part 1`() {
        // act
        val result = Day11().part1(3628)

        // assert
        assertThat(result).isEqualTo(Pair(216,12))
    }

    @Test
    fun `example`() {
        assertThat(Day11().part2(18)).isEqualTo(Triple(90,269,16))
        assertThat(Day11().part2(42)).isEqualTo(Triple(232,251,12))
    }

    @Test
    fun `part 2`() {
        assertThat(Day11().part2(3628)).isEqualTo(Triple(236, 175, 11))
    }
}