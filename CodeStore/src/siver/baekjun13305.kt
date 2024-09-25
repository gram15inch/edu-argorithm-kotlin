package siver

import java.io.StreamTokenizer

private fun baekjun13305() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    StreamTokenizer(br).apply {
        fun getInt(): Int {
            nextToken()
            return nval.toInt()
        }

        val n = getInt()// 2 ~ 100000 주유소개수
        // 기름 가격 1~10억

        val routes = IntArray(n-1){getInt()}
        val city = IntArray(n){getInt()}
        val cMap=mutableMapOf<Int,Int>().apply {
            for(idx in city.indices){
                if(this[city[idx]]==null)
                    this[city[idx]]=idx
            }
        }
        val sort= cMap.map {it.key }.sorted()

        var rRight = n-2
        var cost = 0L
        for(t in sort){
            if(cMap[t]==null)
                continue
            if(cMap[t]!!>rRight)
                continue
            var sum=0L
            for(r in cMap[t]!!..rRight){
                sum+= routes[r]
            }
            cost += sum*city[cMap[t]!!]
            rRight=cMap[t]!!-1
        }
        bw.write("$cost")
    }

    bw.flush()
}