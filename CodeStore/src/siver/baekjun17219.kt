package siver

import java.io.StreamTokenizer

private fun baekjun17219() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    StreamTokenizer(br).apply {
        fun getInt(): Int {
            nextToken()
            return nval.toInt()
        }
        fun getString(): String {
            nextToken()
            return sval
        }

        val n = getInt()
        val m = getInt()
        val hash = HashMap<String,String>()

        repeat(n){
            val s = br.readLine().split(" ")
            hash[s[0]] = s[1]
        }

        repeat(m){
            bw.write("${hash[br.readLine()]}\n")
        }

    }

    bw.flush()
}