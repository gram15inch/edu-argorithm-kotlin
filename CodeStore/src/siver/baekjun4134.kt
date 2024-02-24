package siver

import java.io.StreamTokenizer

@Suppress("unused")
private fun baekjun4134(){
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    StreamTokenizer(br).apply {
        fun getInt(): Int {
            nextToken()
            return nval.toInt()
        }

        fun getLong(): Long {
            nextToken()
            return nval.toLong()
        }

        fun isPrime(limit: Long): Boolean {
            when(limit){
                0L,1L-> return false
                else->{
                    for (a in  2.. kotlin.math.sqrt(limit.toDouble()).toInt()){
                        if(limit%a.toLong()==0L)
                            return false
                    }
                }
            }

            return true
        }

        repeat(getInt()) {
            getLong().apply {
                var i = this
                while(true) {
                    if (isPrime(i)) {
                        bw.write("$i\n")
                        break
                    }
                    i++
                }
            }
        }
        bw.flush()
    }
}