package siver

import java.io.StreamTokenizer
import java.util.*

@Suppress("unused")
private fun baekjun1018() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    StreamTokenizer(br).apply {
        fun getInt(): Int {
            nextToken()
            return nval.toInt()
        }

        fun gcd(a: Int, b: Int): Int {
            (a % b).apply {
                return when {
                    this == 0 -> b
                    else -> gcd(b, this)
                }
            }
        }

        val hash1: HashMap<Int, Int> = hashMapOf()
        var prev = -1

        repeat(getInt()) {
            getInt().apply {
                if (prev > 0) {
                    (this - prev).let {
                        if (hash1.get(it) == null)
                            hash1[it] = 1
                        else
                            hash1[it] = hash1[it]!! + 1
                    }
                }
                prev = this
            }
        }

        var gcdPrev = -1
        var sum = 0

        hash1.forEach {
            if(gcdPrev>0)
                gcdPrev = gcd(gcdPrev, it.key)
            else
                gcdPrev = it.key
        }

        hash1.forEach {
            sum += ((it.key / gcdPrev ) -1) * it.value
        }

        bw.write("$sum")
        bw.flush()
    }
}

