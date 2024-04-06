package siver

import java.io.StreamTokenizer
import java.util.*

@Suppress("unused")
private fun baekjun2164() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    StreamTokenizer(br).apply {
        fun getInt(): Int {
            nextToken()
            return nval.toInt()
        }

        val num = getInt()
        val q1 = LinkedList<Int>()
        for(n in 1..num)
            q1.add(n)

        if(q1.size>=2)
            q1.pop()
        while(q1.size>=2){
            q1.add(q1.pop())
            q1.pop()
        }

        bw.write("${q1.pop()}")
        bw.flush()

    }
}