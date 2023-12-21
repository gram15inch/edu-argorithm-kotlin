import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import sort.bubbleSort2
import sort.insertionSort2
import sort.selectionSort2

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


    @Test
    fun selectTest(){

        val input = listOf(9,1,8,5,6,4,3,7,2,0)
        val expect = List(10){it}
        val actual = selectionSort2(input.toIntArray())

        assertEquals(expect, actual.toList())
    }

    @Test
    fun mergeTest(){
        val input = IntArray(5){5-it+1}
        val expect = IntArray(5){it}
        //todo 범위안맞음
        merge_sort(input,0,4)
        assertEquals(expect.toList(), input.toList())
    }

    @Test
    fun mergeTest2(){
        var start = 1000000000
        val input = IntArray(500000){start - it}
        var start2 = input.last()
        val expect = IntArray(500000){start2 + it}
        assertEquals(input[0], 1000000000)
        assertEquals(input.last(), 999500001)
        assertEquals(expect[0], start2)
        assertEquals(expect.last(), 1000000000)


        merge_sort(input,0,500000-1)
        assertEquals(expect.toList(), input.toList())
    }

}