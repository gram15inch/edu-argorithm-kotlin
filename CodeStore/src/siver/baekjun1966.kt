package siver

import java.io.StreamTokenizer
import java.util.*

private fun baekjun1966() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    StreamTokenizer(br).apply {
        fun getInt(): Int {
            nextToken()
            return nval.toInt()
        }

        fun isDelete(pri:Int,arr:IntArray):Boolean{
            if(pri==9 && arr[pri]>0){
                return true
            }else{
                for (num in pri+1..<arr.size){
                    if(arr[num]>0)
                        return false
                }
            }
            return true
        }

        val n = getInt()
        repeat(n){
            val size = getInt()
            val searchIdx = getInt()
            val que: Queue<Pair<Int, Int>> = LinkedList()
            val hash = IntArray(10){0}

            repeat(size){
                val num = getInt()
                que.add(Pair(it,num))
                hash[num]++
            }

            var delete = 0
            var isWrite = false
            while (!isWrite){
                que.poll().apply {
                    if(isDelete(this.second, hash)){
                        delete++
                        hash[this.second]--
                        if(this.first==searchIdx) {
                            bw.write("$delete\n")
                            isWrite=true
                        }
                    }else{
                        que.add(this)
                    }
                }

            }
        }
    }

    bw.flush()
}