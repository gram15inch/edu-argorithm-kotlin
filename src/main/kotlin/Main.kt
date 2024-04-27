import java.io.StreamTokenizer
import java.util.Deque
import java.util.LinkedList
import java.util.NoSuchElementException
import java.util.Queue

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

        fun isPrime(limit: Long): Boolean {
            when(limit){
                0L,1L-> return false
                else->{
                    for (a in  2.. kotlin.math.sqrt(limit.toDouble()).toInt()){
                        if(limit%a.toLong()==0L)
                            return false
                    }
                }
            }

            return true
        }

        val n = getInt()
        val deque1:Deque<Int> = LinkedList()
        repeat(n){
            val order = getInt()
            try{
                when(order){
                    1->{deque1.addFirst(getInt())}
                    2->{deque1.addLast(getInt())}
                    3->{bw.write("${deque1.removeFirst()}\n")}
                    4->{bw.write("${deque1.removeLast()}\n")}
                    5->{bw.write("${deque1.size}\n")}
                    6->{bw.write("${if(deque1.isEmpty()) 1 else 0}\n")}
                    7->{bw.write("${deque1.first}\n")}
                    8->{bw.write("${deque1.last}\n")}
                }
            }catch (e:NoSuchElementException){
                bw.write("1\n")
            }

        }

        bw.flush()
    }


}
