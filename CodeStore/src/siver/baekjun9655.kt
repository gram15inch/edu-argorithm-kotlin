package siver

import java.io.StreamTokenizer

private fun baekjun9655() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    StreamTokenizer(br).apply {
        fun getInt(): Int {
            nextToken()
            return nval.toInt()
        }

        val n = getInt()

        val name = if(n%2==0) "CY" else "SK"

        bw.write("$name")

    }

    bw.flush()
}