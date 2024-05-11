package siver

import java.io.StreamTokenizer
import java.util.*
import java.util.ArrayDeque


@Suppress("unused")
private fun baekjun2346(){
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    StreamTokenizer(br).apply {
        fun getInt(): Int {
            nextToken()
            return nval.toInt()
        }

        val num = getInt()
        val deque : Deque<Pair<Int,Int>> = ArrayDeque()
        for(i in 1 .. num) {
            deque.add(Pair(i, getInt()))
        }

        while (true) {
            val cur = deque.removeFirst()
            bw.write("${cur.first} ")
            val move = cur.second

            if(deque.isEmpty()) break

            if(move > 0) {
                for(i in 1 until move) {
                    deque.addLast(deque.removeFirst())
                }
            } else {
                for(i in move until 0) {
                    deque.addFirst(deque.removeLast())
                }
            }
        }

        bw.flush()
    }

}