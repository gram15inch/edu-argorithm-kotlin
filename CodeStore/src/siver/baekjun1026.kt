package siver

import java.io.StreamTokenizer

private fun baekjun1026() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    StreamTokenizer(br).apply {
        fun getInt(): Int {
            nextToken()
            return nval.toInt()
        }

        val n = getInt()

        val a = IntArray(n) { getInt() }.apply { sortDescending() }
        val b = IntArray(n) { getInt() }.apply { sort() }
        var sum = 0
        for (num in 0..n - 1)
            sum += a[num] * b[num]
        bw.write("$sum")

    }
}