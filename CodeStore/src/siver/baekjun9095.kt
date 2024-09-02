package siver

import java.io.StreamTokenizer

private fun baekjun9095() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    StreamTokenizer(br).apply {
        fun getInt(): Int {
            nextToken()
            return nval.toInt()
        }

        val t = getInt()
        val conMaxArr = IntArray(12) { -1 }
        conMaxArr[0] = 0
        fun getConditionCount(remain: Int, max: Int): Int {
            if (remain < 0 || remain > max)
                return 0
            if (remain == 0)
                return 1
            if (conMaxArr[remain] != -1)
                return conMaxArr[remain]

            var count = 0
            for (num in 1..3) {
                count += getConditionCount(remain - num, max)
            }
            conMaxArr[remain] = count
            return count
        }

        repeat(t) {
            val n = getInt()
            bw.write("${getConditionCount(n, n)}\n")
        }

    }

    bw.flush()
}