package siver

import java.io.StreamTokenizer

private fun baekjun1676() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()


    StreamTokenizer(br).apply {
        fun getInt(): Int {
            nextToken()
            return nval.toInt()
        }

        val n = getInt()

        var five = 0
        for(pack in 1..n){
            var na = pack
            while (na>0){
                when{
                    na%5 == 0 -> {
                        five++
                        na/=5
                    }
                    else->{
                        break
                    }
                }
            }
        }


        bw.write("$five")

    }

    bw.flush()

}