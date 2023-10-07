import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import siver.baekjun4948
import siver.baekjun4948B


class MainKtTest {

    @Test
    fun run() {
        val input = "1\n" +
                "10\n" +
                "13\n" +
                "100\n" +
                "1000\n" +
                "10000\n" +
                "100000"

        val output = "1\n" +
                "4\n" +
                "3\n" +
                "21\n" +
                "135\n" +
                "1033\n" +
                "8392"

        val iList= input.toLine()
        val oList= output.toLine()
        val rList = baekjun4948(iList)

        assertEquals(oList, rList)
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