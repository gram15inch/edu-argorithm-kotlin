package siver

import java.util.*
import kotlin.collections.HashMap

@Suppress("unused")
fun baekjun1620(){
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val st = StringTokenizer(br.readLine())
    val n= st.nextToken().toInt()
    val m= st.nextToken().toInt()
    val hash1 = HashMap<String,Int>()
    val hash2 = HashMap<Int,String>()
    var count = 1

    repeat(n) {
        br.readLine().apply {
            hash1[this]=count
            hash2[count]=this
            count++
        }
    }

    repeat(m){
        br.readLine().apply {
            if(this[0].isDigit())
                bw.write("${hash2[this.toInt()]}\n")
            else
                bw.write("${hash1[this]}\n")
        }
    }

    bw.flush()
}