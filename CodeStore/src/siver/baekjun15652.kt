package siver
import java.io.StreamTokenizer

@Suppress("unused")
fun baekjun15652() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    StreamTokenizer(br).apply {
        fun getInt(): Int {
            nextToken()
            return nval.toInt()
        }

        val n = getInt()
        val m = getInt()
        val group = IntArray(m)

        fun dfs(digit:Int, at:Int) {
            if(digit==m) {
                for (num in group)
                    bw.write("$num ")
                bw.write("\n")
                return
            }

            for (nord in at..< n) {
                group[digit] = nord + 1
                dfs(digit + 1, nord)
            }

        }

        dfs(0,0)
    }

    bw.flush()
}
