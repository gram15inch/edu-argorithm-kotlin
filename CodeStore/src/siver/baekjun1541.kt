package siver

import java.io.StreamTokenizer

private fun baekjun1541() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    StreamTokenizer(br).apply {
        fun getInt(): Int {
            nextToken()
            return nval.toInt()
        }

        val str = br.readLine()

        var min =0
        var tmpNum=""
        var tmpOpp=' '
        for(num in str.indices){
            when(str[num]){
                '-'->{
                    if(tmpOpp=='-')
                        min-=tmpNum.toInt()
                    else
                        min+=tmpNum.toInt()
                    tmpOpp='-'
                    tmpNum=""
                }
                '+'->{
                    if(tmpOpp=='-')
                        min-=tmpNum.toInt()
                    else
                        min+=tmpNum.toInt()
                    tmpNum=""
                }
                else -> {tmpNum+=str[num]}
            }
        }
        if(tmpOpp=='-')
            min-=tmpNum.toInt()
        else
            min+=tmpNum.toInt()
        bw.write("$min")
    }

    bw.flush()
}