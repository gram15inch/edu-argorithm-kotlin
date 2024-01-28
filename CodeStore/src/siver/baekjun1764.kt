package siver

import java.io.StreamTokenizer

@Suppress("unused")
fun baekjun1764() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    StreamTokenizer(br).run{
        fun getInt() : Int{
            nextToken()
            return nval.toInt()
        }

        fun getString():String{
            nextToken()
            return sval.toString()
        }
        val n =getInt()
        val m =getInt()
        val hash1 = HashMap<String,Boolean>()
        repeat(n) {
            getString().apply {
                hash1[this] = false
            }
        }

        repeat(m){
            getString().apply {
                hash1[this] = !(hash1[this]?:true)
            }
        }

        hash1.asSequence().filter { it.value }
            .map { it.key }
            .sorted()
            .toList()
            .apply { bw.write("${this.size}\n") }
            .forEach { bw.write("$it\n") }

        bw.flush()
    }
}

