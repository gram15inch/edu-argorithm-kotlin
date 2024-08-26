package siver

import java.io.StreamTokenizer

private fun baekjun11047() {
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


        val n = getInt()
        val k = getInt()
        val arr = IntArray(n){getInt()}

        fun getCoinCount(balnace:Int, coin:Int){
            if(balnace==0){
                bw.write("$coin\n")
                return
            }else{
                for(idx in n-1 downTo 0){
                    val mok = balnace/arr[idx]
                    if(mok>0){
                        return getCoinCount(balnace%arr[idx],coin+mok)
                    }
                }
            }
        }
        getCoinCount(k,0)
    }

    bw.flush()
}