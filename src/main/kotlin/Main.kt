import java.io.StreamTokenizer

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
        val numGroup = mutableListOf<Int>()
        repeat (getInt()){
            numGroup.add(getInt())
        }
        val max = numGroup.max()
        var count = 0
        val maxSqrt = kotlin.math.sqrt(max.toDouble()).toInt()
        val arrSieve = BooleanArray(max + 1) { true }

        for (idx in 0..1)
            arrSieve[idx] = false

        for (mul in 2..maxSqrt)
            if (arrSieve[mul])
                for (idx in mul * mul..max step mul)
                    arrSieve[idx] = false
        //실패ㅠ
        numGroup.forEach {
            count=0
            for(num in 2..it){
                if(arrSieve[num])
                    if(arrSieve[it-num])
                        count++
            }
            bw.write("$count\n")
        }

        bw.flush()
    }


}
