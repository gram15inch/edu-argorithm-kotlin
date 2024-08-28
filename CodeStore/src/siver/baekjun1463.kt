package siver

import java.io.StreamTokenizer

private fun baekjun1463() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    StreamTokenizer(br).apply {
        fun getInt(): Int {
            nextToken()
            return nval.toInt()
        }

        val n = getInt()
        val arr = IntArray(n+4){-1}

        arr[0] = 0
        arr[1] = 0
        arr[2] = 1
        arr[3] = 1
        if(n>3) {
            for (idx in 4..n) {
                var min =arr[idx-1]
                if(idx%2==0)
                    arr[idx/2].run {
                        if(min > this)
                            min = this
                    }

                if(idx%3==0)
                    arr[idx/3].run {
                        if(min > this)
                            min = this
                    }
                arr[idx] = min+1
            }
        }
        bw.write("${arr[n]}")
    }

    bw.flush()
}