package siver

import java.io.StreamTokenizer

private fun baekjun1789() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    StreamTokenizer(br).apply {
        fun getInt(): Int {
            nextToken()
            return nval.toInt()
        }

        nextToken()
        var s = nval.toLong()
        var num =0L
        var count = 0
        while (s>0){
            s-=++num
            count++
        }
        if(s==0L)
            bw.write("$count")
        else
            bw.write("${count-1}")
    }
    bw.flush()
}