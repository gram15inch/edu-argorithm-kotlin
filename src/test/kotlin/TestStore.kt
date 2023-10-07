import bronze.baekjun5086
import org.junit.jupiter.api.Assertions
import siver.baekjun2960
import siver.baekjun4948

@Suppress("unused")
class TestStore {

    private fun test5086(){
        val input = "8 16\n" +
                "32 4\n" +
                "17 5"

        val output = "factor\n" +
                "multiple\n" +
                "neither"

        assertEqualLines(input, output){
            baekjun5086(input)
        }
    }

    private fun test2960(){
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

    private fun test4948(){
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

        Assertions.assertEquals(oList, rList)
    }

}