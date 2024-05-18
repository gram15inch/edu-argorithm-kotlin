package siver

import java.io.StreamTokenizer
import java.util.*
import java.util.ArrayDeque


@Suppress("unused")
private fun baekjun24511() {

    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    StreamTokenizer(br).apply {
        fun getInt(): Int {
            nextToken()
            return nval.toInt()
        }

        val num = getInt()
        val list : List<Int> = List(num){getInt()}
        val deque : Deque<Int> = ArrayDeque()

        for(i in 0 ..< num) {
            getInt().apply {
                if(list[i]==0)
                    deque.add(this)
            }
        }

        repeat(getInt()){
            deque.addFirst(getInt())
            bw.write("${deque.pollLast()} ")
        }


        bw.flush()
    }

}