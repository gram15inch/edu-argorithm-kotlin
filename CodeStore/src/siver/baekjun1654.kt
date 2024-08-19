package siver

import java.io.StreamTokenizer

private fun baekjun1654() {
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


        val k = getInt() // 서로다른 길이의 기존 랜선
        val n = getInt() // 알아내야할 같은길이의 갯수
        var max = 0L



        val arr = LongArray(k){getLong()
            .apply {
                if(this>max) {
                    max = this
                }
            }
        }

        var left = 1L
        var right = max

        do{
            val mid = left+(right-left)/2L
            var divCount = 0L

            arr.forEach {
                divCount += it/mid
            }

            when{
                divCount >= n-> left = mid+1
                else -> right = mid-1
            }
        }
        while(left<=right)

        bw.write("$right")
    }

    bw.flush()
}