import java.io.StreamTokenizer
import java.util.HashSet
import java.util.StringTokenizer
import kotlin.collections.HashMap
import kotlin.math.sign

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    StreamTokenizer(br).apply {
        fun getInt() : Int{
            nextToken()
            return nval.toInt()
        }

        fun getString():String{
            nextToken()
            return sval.toString()
        }

        var ma =0
        var mb =0
        var mal =0L
        var mbl =0L
        var isLong =false
        getString().apply {
            isLong = this.length > 8
            ma = this.toInt()
            mal = this.toLong()
        }
        getString().apply {
            isLong = this.length > 8
            mb = this.toInt()
            mbl = this.toLong()
        }

        fun<T:Number> test1(pa:T,pb:T) {
            var a = with(pa) { if(this is Int) this.toInt() else this.toLong() }
            var b = with(pb) { if(this is Int) this.toInt() else this.toLong() }
            var gcd :Int
            val ab :Long

            when{
                a==1 -> bw.write("$b\n")
                b==1 -> bw.write("$a\n")
                else->{
                    ab = (a * b).toLong()
                    do{
                        gcd = a%b
                        if(gcd != 0) {
                            a = b
                            b = gcd
                        }
                        else
                            break
                    }
                    while (true)
                    bw.write("${ab/b}\n")
                }
            }
        }

    }
    bw.flush()

}
