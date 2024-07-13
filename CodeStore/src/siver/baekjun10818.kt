package siver

import java.io.StreamTokenizer
import kotlin.math.abs

fun baekjun10818() {
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
        val arr = IntArray(n)
        var top = -1
        repeat(n){
            when(getString()){
                "push"->{
                    top++
                    val nn = getInt()
                    arr[top] = nn
                }
                "pop"->{
                    bw.write("${if(top<0) -1 else arr[top] }\n")
                    if(top>=0)
                        top--
                }
                "size"->{
                    bw.write("${top+1}\n")
                }
                "empty"->{
                    bw.write("${if(top==-1) 1 else 0}\n")
                }
                "top"->{
                    bw.write("${if(top<0) -1 else arr[top] }\n")
                }
            }
        }

    }
    bw.flush()
}