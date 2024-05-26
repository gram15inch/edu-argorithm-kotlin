package siver
import java.io.StreamTokenizer

@Suppress("unused")
fun baekjun11729() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    StreamTokenizer(br).apply {
        fun getInt(): Int {
            nextToken()
            return nval.toInt()
        }

        val num = getInt()
        val sb = StringBuilder()
        fun hanoi(floor:Int,from:Int,via:Int, to:Int):Int{
            if(floor == 0) return 0

            hanoi(floor-1, from, to, via )
                .run{
                    sb.append("$from $to\n")
                    return this+1 +hanoi(floor-1, via, from, to)
                }
        }

        bw.write("${hanoi(num,1,2,3)}\n")
        bw.write(sb.toString())
    }


    bw.flush()
}
