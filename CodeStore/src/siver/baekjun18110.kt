package siver

import java.io.StreamTokenizer
import kotlin.math.abs

private fun baekjun18110() {



    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()


    StreamTokenizer(br).apply {
        fun getInt(): Int {
            nextToken()
            return nval.toInt()
        }
        fun getRound(num:Double):Int{
            val numInt = num.toInt()
            val na = num-numInt
            return when{
                na >= 0.5  -> numInt+1
                else ->numInt
            }
        }


        val list = mutableListOf<Int>()
        val n = getInt()
        if (n==0){
            bw.write("0")
        } else {
            repeat(n){
                list.add(getInt())
            }
            list.sort()
            val min = getRound(n*0.15)
            val max = getRound(n-(n*0.85))
            var sum = 0
            for(idx in (0+min) ..< (n-max)){
                sum += list[idx]
            }
            bw.write("${getRound(sum / (n-(min+max).toDouble()))}")
        }

    }

    bw.flush()
}