package siver

import java.util.*
import kotlin.collections.HashMap

@Suppress("unused")
private fun baekjun10815(){
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val n= br.readLine().toInt()
    val st =  StringTokenizer(br.readLine())
    val arr1 = Array(n){st.nextToken().toInt() }
    val hash = HashMap<Int,Boolean>()
    arr1.forEach {
        hash[it] = true
    }

    val m = br.readLine().toInt()
    val st2 =  StringTokenizer(br.readLine())
    val arr2 = Array(m){st2.nextToken().toInt() }


    arr2.forEach { num2->
        if(hash[num2] == true)
            bw.write("1 ")
        else
            bw.write("0 ")
    }
    bw.flush()
}