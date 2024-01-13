package siver

import java.util.*

fun baekjun1436() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()


    val st1 = StringTokenizer(br.readLine())
    val N = st1.nextToken().toInt()
    var step = 0
    var latestNum = 665
    while(step < N){
        latestNum++
        if(latestNum.toString().contains("666"))
            step++
    }

    bw.write("$latestNum")
    bw.flush()
}