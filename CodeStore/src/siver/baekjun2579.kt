package siver

import java.io.StreamTokenizer

private fun baekjun2579() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    StreamTokenizer(br).apply {
        fun getInt(): Int {
            nextToken()
            return nval.toInt()
        }

        val stairFloor = getInt()

        val stairScores = IntArray(stairFloor+1){
            if(it==0)
                0
            else
                getInt()
        }


        val maxScores = IntArray(stairFloor+2){-1}
        maxScores[0]= 0
        stairScores.getOrNull(1)?.let {
            maxScores[1]= it
        }
        stairScores.getOrNull(2)?.let{
            maxScores[2] =  stairScores[1] + it
        }

        for(floor in 3..stairFloor){
            maxScores[floor] = maxOf(maxScores[floor-2] + stairScores[floor],
                maxScores[floor-3] + stairScores[floor-1] + stairScores[floor])
        }

        bw.write("${maxScores[stairFloor]}")
    }

    bw.flush()
}