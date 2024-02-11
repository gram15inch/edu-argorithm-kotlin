package siver

import java.io.StreamTokenizer

@Suppress("unused")
private fun baekjun1735() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    StreamTokenizer(br).apply {
        fun getInt(): Int {
            nextToken()
            return nval.toInt()
        }

        fun gcd(a: Int, b: Int): Int {
            (a % b).apply {
                return when {
                    this == 0 -> b
                    else -> gcd(b, this)
                }
            }
        }

        fun lcm(gcd: Int, a: Int, b: Int): Int = a * b / gcd

        val aa = getInt()
        val ab = getInt()
        val ba = getInt()
        val bb = getInt()

        val bLcm = lcm(gcd(ab, bb), ab, bb)

        var ra = ((bLcm / ab) * aa) + ((bLcm / bb) * ba)
        var rb = bLcm
        val gcd = gcd(ra, rb)

        ra /= gcd
        rb /= gcd

        bw.write("$ra $rb")
        bw.flush()
    }

}
