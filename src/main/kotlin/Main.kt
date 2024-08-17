import java.io.StreamTokenizer



fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    StreamTokenizer(br).apply {
        fun getInt(): Int {
            nextToken()
            return nval.toInt()
        }
        //todo 시간초과
        val k = getInt() // 서로다른 길이의 기존 랜선
        val n = getInt() // 알아내야할 같은길이의 갯수
        var lanLength = 0
        val arr = IntArray(k){getInt().apply {
            if(this>lanLength)
                lanLength=this
        }}
        while (lanLength>0){
            var count = 0
            arr.forEach {
                count += it/lanLength
            }
            if(count>=n)
                break
            lanLength--
        }
        bw.write("$lanLength\n")
    }

    bw.flush()
}


