package siver

import java.io.StreamTokenizer

private fun baekjun1049() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    StreamTokenizer(br).apply {
        fun getInt(): Int {
            nextToken()
            return nval.toInt()
        }

        val n = getInt() //~100
        val m = getInt() //~50

        var boxMin= Int.MAX_VALUE
        var itemMin=Int.MAX_VALUE
        repeat(m) {
            getInt().apply {
                if(boxMin>this)
                    boxMin=this
            }// 0~1000 box
            getInt().apply {
                if(itemMin>this)
                    itemMin=this
            } // 0~1000 item
        }
        val div = n/6
        val mod = n%6
        val roundUpOfBox = if(mod==0) div else div+1
        val mixMin = boxMin*div + itemMin*mod
        boxMin *= roundUpOfBox
        itemMin *= n
        val min = minOf(mixMin,boxMin,itemMin)
        bw.write("$min")
    }
    bw.flush()
}