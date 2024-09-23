package siver

import java.io.StreamTokenizer

private fun baekjun2828() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    StreamTokenizer(br).apply {
        fun getInt(): Int {
            nextToken()
            return nval.toInt()
        }

        val n = getInt() // ~10
        val m = getInt() // ~n-1
        val j = getInt() // ~20
        var left=1
        var right=left+m-1
        var move =0
        repeat(j){
            val apple =getInt()
            when{
                apple<left->{
                    (left-apple).apply {
                        left-=this
                        right-=this
                        move+=this
                    }
                }
                apple>right->{
                    (apple-right).apply {
                        left+=this
                        right+=this
                        move+=this
                    }
                }
            }
        }
        bw.write("$move")
    }


    bw.flush()
}