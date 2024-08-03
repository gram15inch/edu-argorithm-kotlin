package siver

import java.io.StreamTokenizer
import kotlin.math.abs

private fun baekjun7568() {



    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()


    StreamTokenizer(br).apply {

        fun getInt(): Int {
            nextToken()
            return nval.toInt()
        }

        data class Body(val key:Int, val mom:Int) : Comparable<Body> {
            override fun compareTo(other: Body): Int {
                return when{
                    this.key > other.key && this.mom > other.mom-> 1
                    this.key < other.key && this.mom < other.mom-> -1
                    else -> 0
                }
            }
        }
        val n = getInt()
        val list1 = mutableListOf<Body>()
        repeat(n){
            list1.add(Body(getInt(), getInt()))
        }
        list1.forEach{ nomal->
            var grade = 1
            list1.forEach { sort->
                if(nomal < sort){
                    grade++
                }
            }
            bw.write("$grade ")
        }

    }

    bw.flush()
}