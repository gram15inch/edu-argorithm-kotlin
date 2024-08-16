package siver

import java.io.StreamTokenizer
import java.util.*

private fun baekjun1874() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val sb = StringBuilder()
    StreamTokenizer(br).apply {
        fun getInt(): Int {
            nextToken()
            return nval.toInt()
        }


        val n = getInt()
        val findArr = IntArray(n){getInt()}
        val stack = Stack<Int>()
        var findIdx = 0
        var numOfAsc = 1

        while (findIdx<=n){
            if(stack.isEmpty() && numOfAsc<=n) {
                stack.push(numOfAsc++)
                sb.append("+\n")
            } else {
                if(stack.isNotEmpty()){
                    if(stack.peek() == findArr[findIdx]){
                        stack.pop()
                        sb.append("-\n")
                        findIdx++
                    }else{
                        if(stack.peek() < numOfAsc && numOfAsc<=n){
                            stack.push(numOfAsc++)
                            sb.append("+\n")
                        }else{
                            sb.clear()
                            sb.append("NO\n")
                            break
                        }
                    }
                }else{
                    break
                }
            }
        }
    }
    bw.write(sb.toString())
    bw.flush()
}