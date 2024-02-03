package siver

import java.io.StreamTokenizer

@Suppress("unused")
private fun baekjun11478() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    StreamTokenizer(br).apply {
        fun getInt() : Int{
            nextToken()
            return nval.toInt()
        }

        fun getString():String{
            nextToken()
            return sval.toString()
        }
        val hash1 = hashSetOf<String>()

        getString().apply {
            for(step in 1..this.length)
                for (start in 0..<this.length - (step -1 ))
                    hash1.add(this.substring(start, start+step))
        }
        bw.write(hash1.size.toString())
    }
    bw.flush()

}

