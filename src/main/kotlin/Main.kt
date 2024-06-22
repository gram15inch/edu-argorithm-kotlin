import java.io.StreamTokenizer


fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    StreamTokenizer(br).apply {
        fun getInt(): Int {
            nextToken()
            return nval.toInt()
        }

        val n = getInt()
        val chess = Array(n) {-1}

        var count = 0
        var col = 0

        fun bt(stack:Int){
            if(col>n-1) {
                count++
                return
            }

            if(stack>n-1) {
                col++
                bt(0)
                return
            }
            //todo 열우선 초기화 해보기
            chess[stack] = col
            bt(stack+1)
            col = 0

        }
        bt(0)
        bw.write(count.toString())

    }

    bw.flush()

}



