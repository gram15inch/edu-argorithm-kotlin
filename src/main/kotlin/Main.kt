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
        val m = getInt()

        fun track(arr:CharArray,size:Int) {
            if(size==m) {
                bw.write("\n")
                return
            }
            else {
                for (num in arr) {
                    bw.write("$num ")
                    track(arr.copyOf().filter { it != num }.toCharArray(), size + 1)
                }
            }

        }

        val sb = StringBuilder()
        for(num in 1..n)
            sb.append(num)
        track(sb.toString().toCharArray(),0)
        //todo 4 2 오류잡기

    }


    bw.flush()


}



