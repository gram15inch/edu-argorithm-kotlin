package siver

import java.io.StreamTokenizer
import java.util.*

@Suppress("unused")
private fun baekjun11866(){
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    StreamTokenizer(br).apply {
        fun getInt(): Int {
            nextToken()
            return nval.toInt()
        }

        val n = getInt()
        val k = getInt()
        val q1: Queue<Int> = LinkedList()
        for(no in 1 ..  n)
            q1.add(no)
        bw.write("<")
        repeat(n){
            for(idx in (1..<k))
                q1.offer(q1.poll())

            if(it==n-1)
                bw.write("${q1.poll()}>")
            else
                bw.write("${q1.poll()}, ")

        }
        bw.flush()

    }
}