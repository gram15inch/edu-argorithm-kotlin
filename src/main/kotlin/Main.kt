import java.io.StreamTokenizer
import java.util.*
import kotlin.math.abs


fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    fun three(num:Int):Int{
        val mod= num%3
        return if(mod==0) 3 else mod
    }
    StreamTokenizer(br).apply {
        fun getInt(): Int {
            nextToken()
            return nval.toInt()
        }
        data class NameStack(val name:Int,val stack:Stack<Int>)

        val num = getInt()
        val sb = StringBuilder()
        fun hanoi(floor:Int,from:Int, to:Int):Int{ // 1 2 / 3 2 / 2 3
            if(floor == 0) return 0
            when(abs(from - to)){
                1->{
                    //todo n-1을 옮기는 경우가 다름
                    hanoi(floor-1, from, three(to+1)) // 1 3 / 3 1 / 2 1
                        .run{
                            sb.append("$from $to\n")
                            return this+1 +hanoi(floor-1, three(from+2), three(to)) // 3 2 / 2 3 / 1 2
                        }
                }
                2->{
                    hanoi(floor-1, from, three(from+1)) // 1 2
                    .run{
                        sb.append("$from $to\n")
                      return this +1 + hanoi(floor-1, three(from+1), three(from+2)) // 2 3
                    }
                }
            }
            return 0
        }

        bw.write("${hanoi(num,3,2)}\n")
        bw.write(sb.toString())
    }


    bw.flush()


}

