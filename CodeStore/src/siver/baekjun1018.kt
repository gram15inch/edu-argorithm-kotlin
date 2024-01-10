package siver

import java.util.*

fun baekjun1018() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()


    val st1 = StringTokenizer(br.readLine())
    val M = st1.nextToken().toInt()
    val N = st1.nextToken().toInt()
    val arr = Array(M) { br.readLine() }

    splitSearch(arr,M,N)

    bw.write("$countSmallest")
    bw.flush()
}

val board = 8
var countSearch = 0
var countSmallest = 999999999

private fun splitSearch(arr:Array<String>, M:Int, N:Int) {

    for (firstRowM in 0..M - board)
        for (firstColN in 0..N - board) {
            var countOfReverseFalse = 0
            var countOfReversTrue = 0
            val first = arr[firstRowM][firstColN]

            when(first){
                'W'->{
                    countOfReverseFalse = search(arr, firstRowM, firstColN, true, false)
                    countOfReversTrue = search(arr, firstRowM, firstColN, false, true)
                }
                'B'->{
                    countOfReverseFalse = search(arr, firstRowM, firstColN, false, false)
                    countOfReversTrue = search(arr, firstRowM, firstColN, true, true)
                }
                else-> Exception("색 오류")
            }
            val countSmall = if(countOfReverseFalse<countOfReversTrue) countOfReverseFalse else countOfReversTrue
            if(countSmall <= countSmallest )
                countSmallest = countSmall
            if(countSmallest==0)
                return
        }
}


private fun search(arr: Array<String>, startM: Int, startN: Int, isFirstW: Boolean, isReverse:Boolean):Int{
    countSearch=0
    if(isReverse)
        countSearch++
    for (row in 0..< board)
        for (col in 0..< board){
            if(!(row == 0 && col == 0)){
                val color = arr[startM+row][startN+col]
                countUpWhenNonChess(isFirstW, row , col , color)
            }
        }
    return countSearch
}

private fun countUpWhenNonChess(isFirstW:Boolean ,row:Int, col:Int, color:Char){
    if(isFirstW) {
        if ((row % 2) == 0) {
            if(col % 2 ==0) {
                if (color != 'W')
                    countSearch++
            }else{
                if (color != 'B')
                    countSearch++
            }
        } else
            if(col % 2 ==0) {
                if (color != 'B')
                    countSearch++
            }else{
                if (color != 'W')
                    countSearch++
            }
    }else{
        if ((row % 2) ==0) {
            if(col % 2 ==0) {
                if (color != 'B')
                    countSearch++
            }else{
                if (color != 'W')
                    countSearch++
            }
        } else
        {
            if(col % 2 ==0) {
                if (color != 'W')
                    countSearch++
            }else{
                if (color != 'B')
                    countSearch++
            }
        }
    }
}

