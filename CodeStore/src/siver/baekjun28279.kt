package siver

import java.io.StreamTokenizer
import java.util.*

@Suppress("unused")
private fun baekjun28279() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    StreamTokenizer(br).apply {
        fun getInt(): Int {
            nextToken()
            return nval.toInt()
        }

        val n = getInt()
        val deque1: Deque<Int> = LinkedList()
        repeat(n){
            val order = getInt()
            try{
                when(order){
                    1->{deque1.addFirst(getInt())}
                    2->{deque1.addLast(getInt())}
                    3->{bw.write("${deque1.removeFirst()}\n")}
                    4->{bw.write("${deque1.removeLast()}\n")}
                    5->{bw.write("${deque1.size}\n")}
                    6->{bw.write("${if(deque1.isEmpty()) 1 else 0}\n")}
                    7->{bw.write("${deque1.first}\n")}
                    8->{bw.write("${deque1.last}\n")}
                }
            }catch (e: NoSuchElementException){
                bw.write("-1\n")
            }
        }

        bw.flush()
    }
}