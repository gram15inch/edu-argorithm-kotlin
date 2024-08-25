package siver

import java.io.StreamTokenizer

private fun baekjun1003() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    StreamTokenizer(br).apply {
        fun getInt(): Int {
            nextToken()
            return nval.toInt()
        }


        val t = getInt()
        repeat(t){
            val n = getInt()
            var zero = 1
            var one = 0
            repeat(n){
                one.run {
                    one = zero+this
                    zero = this
                }
            }

            bw.write("${zero} ${one}\n")
        }

    }

    bw.flush()
}