package siver

import java.io.StreamTokenizer

private fun baekjun1783() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    StreamTokenizer(br).apply {
        fun getInt(): Int {
            nextToken()
            return nval.toInt()
        }

        val n = getInt()//~20억
        val m = getInt()//~20억

        when (n) {
            1 -> {
                bw.write("1")
            }

            2 -> when (m) {
                in 1..2 -> bw.write("1")
                in 3..4 -> bw.write("2")
                in 5..6 -> bw.write("3")
                else -> bw.write("4")
            }

            else -> {
                when (m) {
                    in 1..3 -> bw.write("$m")
                    in 4..6 -> bw.write("4")
                    7 -> bw.write("5")
                    else -> bw.write("${m - 2}")
                }
            }
        }

    }

    bw.flush()
}