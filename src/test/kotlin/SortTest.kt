import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import sort.bubbleSort2
import sort.insertionSort2

class SortTest {

    @Test
    fun bubbleWhenWorstTest(){

        val input = List(10){ 9-it}
        val expect = List(10){it}
        val actual = bubbleSort2(input.toIntArray())

        assertEquals(expect, actual.toList())
    }

    @Test
    fun bubbleTest(){

        val input = listOf(9,1,8,5,6,4,3,7,2,0)
        val expect = List(10){it}
        val actual = bubbleSort2(input.toIntArray())

        assertEquals(expect, actual.toList())
    }

    @Test
    fun insertWhenWorstTest(){

        val input = List(10){ 9-it}
        val expect = List(10){it}
        val actual = insertionSort2(input.toIntArray())

        assertEquals(expect, actual.toList())
    }

    @Test
    fun insertTest(){

        val input = listOf(9,1,8,5,6,4,3,7,2,0)
        val expect = List(10){it}
        val actual = insertionSort2(input.toIntArray())

        assertEquals(expect, actual.toList())
    }


}