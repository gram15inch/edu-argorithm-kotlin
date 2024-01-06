import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()


    val st1= StringTokenizer(br.readLine())
    val M = st1.nextToken().toInt()
    val N = st1.nextToken().toInt()
    val arr = Array(M){br.readLine()}
    val max =2
    val cArr = Array((M-(max-1))*(N-(max-1))){ arrayOf(0,0,0)}
    for(m in 0..M-max)
        for(n in 0..N-max) {
            count=0
            countW=0
            countB=0
            val startM = m
            val startN = n
            for (row in 0..< max) {
                for (col in 0..< max) {
                    val color = arr[startM+row][startN+col]
                    if (row == 0 && col == 0) {
                        when(color){
                            'W'-> {
                                isFirstW = true
                            }
                            'B'-> {
                                isFirstW = false
                            }
                            else-> throw Exception("색오류")
                        }
                    }
                    else {
                        if(isFirstW){
                            countUpWhenNonChess(true,row, col, color)
                            countW = count
                            count=1
                            countUpWhenNonChess(false,row, col, color)
                            countB = count

                        }else{
                            countUpWhenNonChess(false,row, col, color)
                            countB = count
                            count=1
                            countUpWhenNonChess(true,row, col, color)
                            countW = count
                        }
                        if(countW<=countB)
                            count= countW
                        else
                            count= countB
                    }
                }
            }

            cArr[cArrCount][0] = startM
            cArr[cArrCount][1] = startN
            cArr[cArrCount++][2] = count
        }
   // bw.write(cArr.min().toString())
    bw.flush()
}
var isFirstW = true
var count = 0
var countW = 0
var countB = 0
var cArrCount = 0
private fun countUpWhenNonChess(isFirstW:Boolean ,row:Int, col:Int, color:Char){
    if(isFirstW) {
        if ((row % 2) == 0) {
            if(col % 2 ==0) {
                if (color != 'W')
                    count++
            }else{
                if (color != 'B')
                    count++
            }
        } else
            if(col % 2 ==0) {
                if (color != 'B')
                    count++
            }else{
                if (color != 'W')
                    count++
            }
    }else{
        if ((row % 2) ==0) {
            if(col % 2 ==0) {
                if (color != 'B')
                    count++
            }else{
                if (color != 'W')
                    count++
            }
        } else
        {
            if(col % 2 ==0) {
                if (color != 'W')
                    count++
            }else{
                if (color != 'B')
                    count++
            }
        }
    }
}

