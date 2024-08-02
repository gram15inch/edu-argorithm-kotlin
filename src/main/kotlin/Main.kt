import java.io.StreamTokenizer


fun main() {

    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()


    StreamTokenizer(br).apply {

        fun getInt(): Int {
            nextToken()
            return nval.toInt()
        }

        data class Body(val key:Int, val mom:Int)
        val n = getInt()
        val list1 = mutableListOf<Body>()
        repeat(n){
            list1.add(Body(getInt(), getInt()))
        }

        // 7568 진행중
    }

    bw.flush()

}



