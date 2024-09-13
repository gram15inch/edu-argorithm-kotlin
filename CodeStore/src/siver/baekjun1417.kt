package siver

import java.io.StreamTokenizer

private fun baekjun1417() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    StreamTokenizer(br).apply {
        fun getInt(): Int {
            nextToken()
            return nval.toInt()
        }

        val n = getInt() //~50
        val arr = IntArray(n + 1)
        for (idx in 1..n)
            arr[idx] = getInt()

        var count =0
        var big = 0
        var bigIdx=0
        if (n > 1){
            while (true) {
                big =0
                bigIdx=0
                for(num in  2..n)
                    if(big<arr[num]) {
                        big = arr[num]
                        bigIdx=num
                    }

                if(arr[1]<=arr[bigIdx]){
                    arr[bigIdx]--
                    arr[1]++
                    count++
                }else break
            }
        }

        bw.write("$count")
    }

    bw.flush()
}