package siver

import java.io.StreamTokenizer

@Suppress("unused")
private fun baekjun13909() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    StreamTokenizer(br).apply {
        fun getInt(): Int {
            nextToken()
            return nval.toInt()
        }

        val max = getInt()
        var count = 0

        var i = 1
        while (i * i <= max) {
            count++
            i++
        }

        bw.write("$count\n")
        bw.flush()

    }
}