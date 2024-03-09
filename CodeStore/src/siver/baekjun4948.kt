package siver

import java.io.StreamTokenizer
import java.lang.Math.sqrt


/*
베르트랑 공준은 임의의 자연수 n에 대하여, n보다 크고, 2n보다 작거나 같은 소수는 적어도 하나 존재한다는 내용을 담고 있다.

이 명제는 조제프 베르트랑이 1845년에 추측했고, 파프누티 체비쇼프가 1850년에 증명했다.

예를 들어, 10보다 크고, 20보다 작거나 같은 소수는 4개가 있다. (11, 13, 17, 19) 또, 14보다 크고, 28보다 작거나 같은 소수는 3개가 있다. (17,19, 23)

자연수 n이 주어졌을 때, n보다 크고, 2n보다 작거나 같은 소수의 개수를 구하는 프로그램을 작성하시오.


input>
입력은 여러 개의 테스트 케이스로 이루어져 있다. 각 케이스는 n을 포함하는 한 줄로 이루어져 있다.

입력의 마지막에는 0이 주어진다.

output>
각 테스트 케이스에 대해서, n보다 크고, 2n보다 작거나 같은 소수의 개수를 출력한다
*/

fun baekjun4948(input: List<String>): List<String> {

    val result = mutableListOf<String>()
    input.forEach {n->
        val N = n.toInt()
        val N2 = 2 * N
        val rangeSize = N2
        val range = IntArray(rangeSize){idx-> idx +1}
        if(N==1)
            result.add("1")
        else {
            var allElementPos = 1
            do {
                if(range[allElementPos] != -1) {
                    var deletePos = allElementPos
                    val firstPos = deletePos
                    do {
                        if(range[deletePos]!=-1 && firstPos!= deletePos && range[deletePos] % range[firstPos] == 0)
                            range[deletePos] = -1
                    } while (++deletePos < rangeSize)
                }
            }while(++allElementPos < sqrt(rangeSize.toDouble()))
            val count = range.getPrimeCount(N,N2).toString()
            result.add(count)
        }
    }

    return result
}


private fun IntArray.getPrimeCount(N:Int,N2:Int): Int {
    var count =0
    for(idx in N until N2){
        if(this[idx]!=-1)
            count++
    }
    return count
}

@Suppress("unused")
private fun baekjun4948no2() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    StreamTokenizer(br).apply {
        fun getInt(): Int {
            nextToken()
            return nval.toInt()
        }

        while (true) {
            val min = getInt()
            if (min == 0)
                break
            val max = 2 * min
            var count = 0
            val maxSqrt = kotlin.math.sqrt(max.toDouble()).toInt()
            val arrSieve = BooleanArray(max + 1) { true }

            for (idx in 0..1)
                arrSieve[idx] = false

            for (mul in 2..maxSqrt)
                if (arrSieve[mul])
                    for (idx in mul * mul..max step mul)
                        arrSieve[idx] = false

            for (idx in min + 1..max)
                if (arrSieve[idx])
                    count++

            bw.write("$count\n")

        }

        bw.flush()
    }
}

