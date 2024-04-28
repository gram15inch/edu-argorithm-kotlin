import java.io.StreamTokenizer
import java.util.Deque
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
        val dec :Deque<Int> = LinkedList()
        repeat(n){
            dec.add(getInt())
        }

        var position = 1
        fun Deque<Int>.next(isRemove:Boolean){
            if(++position>size)
                position-=size
            if(isRemove)
                removeFirst()
            else
                addLast(removeFirst())
        }

        fun Deque<Int>.prev(isRemove:Boolean){
            if(--position<=0)
                position+=size
            if(isRemove)
                removeLast()
            else
                addFirst(removeLast())
        }



        repeat(n){
            if(it!=0) {
               val isNext = dec.first>0
               val step = if(dec.first>0) dec.first else dec.first *-1
                for (r in 1..step) {
                    if (isNext)
                        dec.next(r == 1)
                    else
                        dec.prev(r == 1)
                }
                bw.write("$position ")
            }
            else{
                bw.write("$position ")
            }

        }


        bw.flush()
    }


}
