package siver

import java.util.*
import kotlin.collections.HashMap

@Suppress("unused")
fun baekjun7785(){
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val n= br.readLine().toInt()
    val hash = HashMap<String,Boolean>()

    repeat(n) {
        val st = StringTokenizer(br.readLine())
        val name = st.nextToken()
        val status = st.nextToken()

        hash[name]=when(status){
            "enter" -> true
            else -> false
        }
    }

    hash.asSequence().filter{it.value}.map{it.key}.sortedByDescending { it }.forEach {
        bw.write("${it}\n")
    }

    bw.flush()
}