import java.io.StreamTokenizer
import java.util.LinkedList

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
        val k = getInt()
        var q1 = LinkedList<Int>()
        var count = 0
        for(no in 1 ..  n)
            q1.add(no)
        while (q1.size>1){
          count = (count+k)%q1.size
            bw.write("${q1.get(if(count==0) q1.size else count-1)}\n")
            q1.remove(count)
        }
        bw.flush()

    }


}
