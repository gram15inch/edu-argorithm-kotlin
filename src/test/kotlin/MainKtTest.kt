import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import siver.baekjun28278


class MainKtTest {

    @Test
    fun run() {
        val input = "4\n" +
                "1 3\n" +
                "1 5\n" +
                "3\n" +
                "2\n" +
                "5\n" +
                "2\n" +
                "2\n" +
                "5"

        val output = "1\n" +
                "2\n" +
                "5\n" +
                "3\n" +
                "3\n" +
                "-1\n" +
                "-1"

        val iList= input.toLine()
        val oList= output.toLine()
        val eList = mutableListOf<String>()
        iList.forEach {input->
            baekjun28278(input).let {
                if(it!= "")
                    eList.add(it) }
            }


        assertEquals(oList, eList)
    }
}

fun assertEqualLines(input:String, output:String, funCallBack : (String)->String){
    val input = input.toLine()
    val expected = output.toLine()

    val actual = input.map {line-> funCallBack(line) }

    expected.forEachIndexed {i, _->
        assertEquals(expected[i],actual[i])
    }
}

fun String.toItem(): List<String> {
    return this.split(" ")
}
fun String.toLine(): List<String> {
    return this.split("\n")
}