package siver

import java.io.StreamTokenizer

private fun baekjun1010() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    StreamTokenizer(br).apply {
        fun getInt(): Int {
            nextToken()
            return nval.toInt()
        }

        val arr = Array(30 + 1) { IntArray(30+1){-1} }
        arr[2][1]=0

        fun getSite(startRemain: Int, endRemain: Int):Int {
            if (startRemain <= 0 || endRemain <= 0)
                return 0
            if(startRemain==1)
                return endRemain
            if(arr[startRemain][endRemain]!=-1)
                return arr[startRemain][endRemain]
            if(endRemain<startRemain)
                return 0

            var count = 0
            for(end in endRemain-1  downTo  1)
                count += getSite(startRemain-1, end)

            arr[startRemain][endRemain] = count
            return count
        }

        val t = getInt()
        repeat(t) {
            val n = getInt()
            val m = getInt()
            bw.write("${getSite(n, m)}\n")
        }

    }

    bw.flush()
}