package siver

import java.io.StreamTokenizer

@Suppress("unused")
private fun baekjun16435() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    StreamTokenizer(br).apply {
        fun getInt(): Int {
            nextToken()
            return nval.toInt()
        }

        val n = getInt() //~1,000
        val l = getInt() //~10,000

        //h ~10,000

        var bam = l
        val arr= IntArray(n){getInt()}.sorted()
        for(num in arr.indices){
            if(arr[num]<=bam){
                bam++
            }else break
        }
        bw.write("$bam")
    }
    bw.flush()
}
