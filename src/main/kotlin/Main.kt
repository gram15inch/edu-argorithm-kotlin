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

        fun isPut(array: IntArray, put :Int):Boolean{
            return false
        }

        fun findCase(chessArr:IntArray, start:Int):Int{
            for (idx in start..<n){
                if(isPut(chessArr,start)){
                    return 0
                }

                chessArr[idx] = 1
                findCase(chessArr, idx+1)
                chessArr[idx] = 0

            }

            return 0
        }

        fun getChessCase(size:Int):Int{
            val chessArr = IntArray(size){0}

            return findCase(chessArr,0)
        }



        bw.write("${getChessCase(n)}")

    }

    bw.flush()
}


