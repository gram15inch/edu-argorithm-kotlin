import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import sort.bubbleSort
import sort.bubbleSort2

class SortTest {

    @Test
    fun bubbleTest(){

        val input = List(10){ 9-it}
        val expect = List(10){it}
        val actual = bubbleSort2(input.toIntArray())

        assertEquals(expect, actual.toList())
    }

}