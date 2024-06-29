package siver

import java.io.StreamTokenizer

@Suppress("unused")
private fun baekjun1920() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    StreamTokenizer(br).apply {
        fun getInt(): Int {
            nextToken()
            return nval.toInt()
        }


        val n = getInt()
        val hash1 = HashSet<Int>(n)
        repeat(n){
            hash1.add(getInt())
        }

        val m = getInt()
        repeat(m) {
            val num = getInt()
            bw.write(if (hash1.contains(num)) "1\n" else "0\n")
        }
    }

    bw.flush()

}