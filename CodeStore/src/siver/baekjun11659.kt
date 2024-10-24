package siver

import java.io.StreamTokenizer
@Suppress("unused")
private fun baekjun11659() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    StreamTokenizer(br).apply {
        fun getInt(): Int {
            nextToken()
            return nval.toInt()
        }

        val n = getInt() // ~10만
        val m = getInt() // ~10만
        val arr= IntArray(n+1) // 1000
        val nuArr = IntArray(n+1)
        for(idx in 1 .. n)
            arr[idx]=getInt()

        nuArr[1] = arr[1]
        for(idx in 1 .. n)
            nuArr[idx]= nuArr[idx-1] + arr[idx]
        repeat(m){
            val i = getInt() // ~n
            val j = getInt() // ~n
            val r = if(i!=1)
                nuArr[j] - nuArr[i-1]
            else
                nuArr[j]
            bw.write("$r\n")
        }

    }

    bw.flush()
}