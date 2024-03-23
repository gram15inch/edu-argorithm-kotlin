package siver

import java.io.StreamTokenizer

@Suppress("unused")
private fun baekjun17103(){
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    StreamTokenizer(br).apply {
        fun getInt(): Int {
            nextToken()
            return nval.toInt()
        }

        val numGroup = mutableListOf<Int>()
        repeat (getInt()){
            numGroup.add(getInt())
        }

        val max = numGroup.max()
        var count = 0
        val maxSqrt = kotlin.math.sqrt(max.toDouble()).toInt()
        val arrSieve = BooleanArray(max + 1) { true }

        for (idx in 0..1)
            arrSieve[idx] = false

        for (mul in 2..maxSqrt)
            if (arrSieve[mul])
                for (idx in mul * mul..max step mul)
                    arrSieve[idx] = false

        numGroup.forEach {
            count=0
            for(num in 2..it/2){//it은 항상 짝수
                if(arrSieve[num])
                    if (arrSieve[it - num])
                        count++
            }
            bw.write("$count\n")
        }

        bw.flush()
    }


}