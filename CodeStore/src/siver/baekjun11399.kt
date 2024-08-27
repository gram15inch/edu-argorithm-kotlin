package siver

import java.io.StreamTokenizer

private fun baekjun11399() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    StreamTokenizer(br).apply {
        fun getInt(): Int {
            nextToken()
            return nval.toInt()
        }

        val n = getInt()
        var arr = IntArray(n){getInt()}.apply { sort() }

        var wait:Int = 0
        var totalTime:Int = 0

        for (time in  arr){
            wait += time + totalTime
            totalTime += time
        }


        bw.write("$wait")
    }

    bw.flush()
}