package siver

import java.io.StreamTokenizer

@Suppress("unused")
private fun baekjun13241 (){
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    StreamTokenizer(br).apply {
        fun getInt(): Int {
            nextToken()
            return nval.toInt()
        }

        fun getLong(): Long {
            nextToken()
            return nval.toLong()
        }

        fun getString(): String {
            nextToken()
            return sval.toString()
        }


        fun gcd(a:Long, b:Long):Long{
            (a % b).apply {
                return when{
                    this == 0L-> b
                    else-> gcd(b, this)
                }
            }
        }

        val a = getLong()
        val b = getLong()
        val gcd = gcd(a,b)
        val lcm = a*b / gcd

        bw.write("$lcm")
        bw.flush()
    }

}