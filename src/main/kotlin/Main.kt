import java.io.StreamTokenizer
import java.util.HashSet
import java.util.StringTokenizer
import kotlin.collections.HashMap
import kotlin.math.sign

fun main() {
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

        fun getString(): String {
            nextToken()
            return sval.toString()
        }


        fun gcd(a: Long, b: Long): Long {
            (a % b).apply {
                return when {
                    this == 0L -> b
                    else -> gcd(b, this)
                }
            }
        }

        fun gcd(a: Int, b: Int): Int {
            (a % b).apply {
                return when {
                    this == 0 -> b
                    else -> gcd(b, this)
                }
            }
        }

        fun lcm(gcd: Long, a: Long, b: Long): Long = a * b / gcd
        fun lcm(gcd: Int, a: Int, b: Int): Int = a * b / gcd

        //todo 21억 넘을시 나는 오류부터 찾아보기
        fun isPrime(limit: Long): Boolean {
            var i =2
            when(limit){
                1L,2L-> return true
                else->{
                    while (i*i<=limit){
                        if(limit%i.toLong()==0L)
                            return false
                        i++
                    }
                }
            }

            return true
        }

        repeat(getInt()) {
            getLong().apply {
                for (i in this downTo 2L)
                    if (isPrime(i)){
                        bw.write("$i\n")
                        break
                    }
            }
        }


        bw.flush()



    }


}
