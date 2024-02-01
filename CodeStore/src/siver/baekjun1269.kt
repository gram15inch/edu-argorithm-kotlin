package siver

import java.io.StreamTokenizer

@Suppress("unused")
fun baekjun1269() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    StreamTokenizer(br).apply {
        fun getInt() : Int{
            nextToken()
            return nval.toInt()
        }

        val n = getInt()
        val m = getInt()
        val hash1 = hashSetOf<Int>()

        repeat(n) {
            hash1.add(getInt())
        }

        repeat(m){
            getInt().apply {
                if(hash1.contains(this))
                    hash1.remove(this)
                else
                    hash1.add(this)
            }
        }

        bw.write(hash1.size.toString())
    }
    bw.flush()

}
