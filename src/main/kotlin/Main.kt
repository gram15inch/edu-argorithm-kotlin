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
        val deq :Deque<Short> = LinkedList()
        repeat(n){
            getInt().toShort().apply {
                deq.add(this)
            }
        }

        // todo 4mb 안에서 방법 찾아보기
        // todo 없어진 원소에대한 위치처리 방법 찾기

        var position = 1
        fun Deque<Short>.next(){
            position++
            if(position > deq.size)
                position-=deq.size
            addLast(removeFirst())
        }

        fun Deque<Short>.prev(){
            position--
            if(position < 1)
                position+=deq.size
            addFirst(removeLast())
        }


        while (deq.size>1){
            val boom =deq.first
            bw.write("$position ")
            deq.removeFirst()
            position++
            if(boom>0)
                repeat(boom-1){
                    deq.next()
                }
            else
                repeat((boom*-1)){
                    deq.prev()
                }
        }
        bw.write("$position")
        bw.flush()
    }


}
