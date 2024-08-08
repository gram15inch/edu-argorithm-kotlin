package siver

import java.io.StreamTokenizer
import kotlin.math.abs

private fun baekjun2108() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    StreamTokenizer(br).apply {
        fun getInt(): Int {
            nextToken()
            return nval.toInt()
        }

        fun getRoundUp(num :Double):Int{
            val intNum = num.toInt()
            return if(abs(num) - abs(intNum) <0.5){
                intNum
            }else{
                intNum + if(num>0) 1 else -1
            }
        }

        val n = getInt()
        val arr = IntArray(n){getInt()}
        val hash = HashMap<Int,Int>()
        var sum = 0
        var max = -5000
        var min = 5000
        for(num in arr){
            val hNum = hash.getOrElse(num){
                -1
            }
            if(hNum==-1){
                hash[num]=1
            }else{
                hash[num]= hash[num]!!+1
            }
            if(max < num)
                max = num
            if(min>num)
                min = num
            sum += num
        }

        var countMax = 0
        var idx = -1

        for(num in hash){
            if(countMax<num.value) {
                idx = num.key
                countMax = num.value
            }
        }

        val fh = hash.filter { it.value==countMax }
        if(fh.size>1){
            val a = fh.toSortedMap()
            val it = a.iterator()
            it.next()
            idx = it.next().key
        }
        arr.sort()

        val div :Double = sum.toDouble()/arr.size
        val one = getRoundUp(div)
        val two = arr[(arr.size/2)]
        val three = idx
        val four = max-min

        bw.write("$one\n$two\n$three\n$four")
    }

    bw.flush()
}