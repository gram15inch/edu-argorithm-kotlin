package siver

import java.io.StreamTokenizer
import java.util.*

private fun baekjun10845() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()


    StreamTokenizer(br).apply {
        fun getInt(): Int {
            nextToken()
            return nval.toInt()
        }

        fun getString(): String {
            nextToken()
            return sval.toString()
        }

        val n = getInt()
        val arr = LinkedList<Int>()
        repeat(n){
            when(getString()){
                "push"->{
                    val nn = getInt()
                    arr.addLast(nn)
                }
                "pop"->{
                    try {
                        bw.write("${arr.first}\n")
                        arr.removeFirst()
                    }catch (e:Exception){
                        bw.write("-1\n")
                    }
                }
                "size"->{
                    bw.write("${arr.size}\n")
                }
                "empty"->{
                    bw.write("${if(arr.isEmpty()) 1 else 0}\n")
                }
                "front"->{
                    try {
                        bw.write("${arr.first}\n")
                    }catch (e:Exception){
                        bw.write("-1\n")
                    }
                }
                "back"->{
                    try {
                        bw.write("${arr.last}\n")
                    }catch (e:Exception){
                        bw.write("-1\n")
                    }
                }
            }
        }

    }
    bw.flush()

}