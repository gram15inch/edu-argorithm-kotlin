package siver

import java.io.StreamTokenizer

private fun baekjun9461() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    StreamTokenizer(br).apply {
        fun getInt(): Int {
            nextToken()
            return nval.toInt()
        }

        val arr =LongArray(101){-1}
        arr[1]=1
        arr[2]=1
        arr[3]=1
        arr[4]=2
        arr[5]=2
        arr[6]=3
        arr[7]=4
        arr[8]=5
        arr[9]=7
        val t = getInt() // ?
        repeat(t){
            val n = getInt() // ~100
            for(num in 10..n){
                if(arr[num]!=-1L) {
                    continue
                }
                else
                    arr[num] = arr[num-1]+arr[num-5]
            }
            bw.write("${arr[n]}\n")
        }
    }

    bw.flush()
}