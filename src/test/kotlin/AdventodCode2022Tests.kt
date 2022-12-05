import nl.roseit.adventofcode2022.Day1
import nl.roseit.adventofcode2022.Day2
import nl.roseit.adventofcode2022.Day3
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class AdventodCode2022Tests {

    @Test
    fun Day1() {
        assertEquals(66719,Day1.getResultPart1() )
        assertEquals(198551,Day1.getResultPart2() )
    }

    @Test
    fun Day2() {
        assertEquals(11767, Day2.getResultPart1() )
        assertEquals(13886, Day2.getResultPart2() )
    }

    @Test
    fun Day3() {
        assertEquals(8493, Day3.getResultPart1() )
        assertEquals(2552, Day3.getResultPart2() )
    }
}
