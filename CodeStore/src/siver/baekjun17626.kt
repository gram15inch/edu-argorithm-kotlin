package siver

import java.io.StreamTokenizer
import kotlin.math.sqrt
@Suppress("unused")
private fun baekjun17626 (){
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    StreamTokenizer(br).apply {
        fun getInt(): Int {
            nextToken()
            return nval.toInt()
        }

        val n = getInt() // ~50000

        val dp = IntArray(n + 4)

        dp[0] = 1
        dp[1] = 1
        dp[2] = 2
        dp[3] = 3

        var min = 500001
        for (num in 4..n) {
            min = 500001
            for (minSqrt in 1..sqrt(num.toFloat()).toInt()) {
                (minSqrt * minSqrt).apply {
                    val before = dp[this] + dp[num-this]
                    if (min > before)
                        min = before
                }
            }
            dp[num] = min
        }

        bw.write("${dp[n]}\n")
    }

    bw.flush()
}