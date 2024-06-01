package siver

import java.io.StreamTokenizer

@Suppress("unused")
private fun baekjun15650() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    StreamTokenizer(br).apply {
        fun getInt(): Int {
            nextToken()
            return nval.toInt()
        }

        val n = getInt()
        val m = getInt()
        fun track(arr:List<Int>, prev:String ,size:Int) {
            if(size==m) {
                bw.write("${prev.trim()} \n")
                return
            }
            for (num in arr) {
                track(arr.filter { it > num },"$prev $num", size + 1)
            }

        }

        track(List(n){it+1},"",0)
    }

    bw.flush()

}