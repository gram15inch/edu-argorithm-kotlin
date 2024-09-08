package siver

import java.io.StreamTokenizer

private fun baekjun9625() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    StreamTokenizer(br).apply {
        fun getInt(): Int {
            nextToken()
            return nval.toInt()
        }

        val n = getInt() // ~45

        val dpa= IntArray(n+2){-1}
        val dpb= IntArray(n+2){-1}
        dpa[1]=0
        dpb[1]=1
        dpa[2]=1
        dpb[2]=1

        for(num in 3..n){
            dpa[num]= dpa[num-1]+dpa[num-2]
            dpb[num]= dpb[num-1]+dpb[num-2]
        }

        bw.write("${dpa[n]} ${dpb[n]}")
    }

    bw.flush()
}