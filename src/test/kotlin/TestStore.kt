import bronze.baekjun5086
import siver.baekjun2960

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

}