package siver

import java.io.StreamTokenizer

private fun baekjun2217() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    StreamTokenizer(br).apply {
        fun getInt(): Int {
            nextToken()
            return nval.toInt()
        }

        val n = getInt()

        val arr= IntArray(n){getInt()}.apply { sort() }

        var backNum=n
        var max = -1
        if(n>1)
            for(num in arr.indices){
                (arr[num]*backNum--).apply {
                    if(max<this)
                        max=this
                }
            }
        else
            max=arr[0]

        bw.write("${max}")
    }
    bw.flush()
}