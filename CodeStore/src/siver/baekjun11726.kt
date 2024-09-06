package siver

import java.io.StreamTokenizer

private fun baekjun11726() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    StreamTokenizer(br).apply {
        fun getInt(): Int {
            nextToken()
            return nval.toInt()
        }

        val n = getInt() // ~1000

        val arr = IntArray(n+4){-1}

        arr[1]=1
        arr[2]=2
        arr[3]=3

        for(num in 4..n){
            arr[num] = (arr[num-1] + arr[num-2])%10007
        }
        bw.write("${arr[n]}\n")

    }

    bw.flush()
}