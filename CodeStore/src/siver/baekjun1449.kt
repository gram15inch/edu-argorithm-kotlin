package siver

import java.io.StreamTokenizer

private fun baekjun1449() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    StreamTokenizer(br).apply {
        fun getInt(): Int {
            nextToken()
            return nval.toInt()
        }

        val n = getInt()
        val l = getInt()
        var count = 0
        if(n==1)
            count=1
        val arr = IntArray(n) { getInt() }.sorted()
        var cur = l

        var idx = 0
        while (idx+1 < n) {
            (arr[idx+1]-arr[idx]).apply{
                when{
                    this < cur->{
                        cur-=this
                        idx++
                    }
                    this >= cur->{
                        idx++
                        cur=l
                        count++
                    }
                }
            }
            if(idx+1==n)
                count++
        }
        bw.write("$count")
        bw.flush()
    }
}