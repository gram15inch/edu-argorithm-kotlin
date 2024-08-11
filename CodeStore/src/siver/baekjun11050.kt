package siver

import java.io.StreamTokenizer

private fun baekjun11050() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    StreamTokenizer(br).apply {
        fun getInt(): Int {
            nextToken()
            return nval.toInt()
        }

        fun fac(s:Int,e:Int):Int{
            var mul =1
            for(num in s..e)
                mul *= num
            return mul
        }

        val n = getInt()
        val k = getInt()

        val r = fac((n-k)+1,n) / fac(1,k)
        bw.write("$r\n")
    }

    bw.flush()
}