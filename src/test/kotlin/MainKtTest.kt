import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import siver.baekjun2960


class MainKtTest {

    @Test
    fun run() {
        val input = "7 3\n" +
                "15 12\n" +
                "10 7"

        val output = "6\n" +
                "7\n" +
                "9"

        assertEqualLines(input, output){
            baekjun2960(it)
        }
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