package siver

import java.io.StreamTokenizer

@Suppress("unused")
private fun baekjun1929() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    StreamTokenizer(br).apply {
        fun getInt(): Int {
            nextToken()
            return nval.toInt()
        }

        val min = getInt()
        val max = getInt()
        val maxSqrt = kotlin.math.sqrt(max.toDouble()).toInt()
        val arrSieve = Array(max+1){true}

        for (idx in 0..1)
            arrSieve[idx]=false

        for(mul in 2..maxSqrt){
            for(idx in mul*mul..max step mul)
                if(arrSieve[idx])
                    arrSieve[idx]=false
        }

        for(idx in  min..max) {
            if(arrSieve[idx])
                bw.write("$idx\n")
        }

        bw.flush()

    }


}