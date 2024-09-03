package siver

import java.io.StreamTokenizer

private fun baekjun14916() {

    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    //TODO 커밋
    StreamTokenizer(br).apply {
        fun getInt(): Int {
            nextToken()
            return nval.toInt()
        }

        val n = getInt() // ~10만
        val arr = IntArray(n + 8) { -2 }

        arr[1] = -1
        arr[2] = 1
        arr[3] = -1
        arr[4] = 2
        arr[5] = 1
        arr[6] = 3
        arr[8] = 4

        for (num in 1..n) {
            if (arr[num] != -2)
                continue
            arr[num] = 1 + minOf(arr[num - 2], arr[num - 5])
        }
        bw.write("${arr[n]}")

    }

    bw.flush()

}