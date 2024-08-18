import java.io.StreamTokenizer



fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    StreamTokenizer(br).apply {
        fun getInt(): Int {
            nextToken()
            return nval.toInt()
        }

        val k = getInt() // 서로다른 길이의 기존 랜선
        val n = getInt() // 알아내야할 같은길이의 갯수
        var lanLength = 0



        val arr = IntArray(k){getInt().apply {
            if(this>lanLength)
                lanLength=this
        } }

        fun getMaxDivLength(left:Int, right:Int, step:Int):Int{
            val mid = left+(right-left) / 2
            val lLength = mid-left+1
            val rLength = right-mid+1
            val small = if(lLength>rLength) rLength else lLength
            if(step<1)
                return small
            else {
                getMaxDivLength(left,mid-1,step,)
            }
            return -1
        }

        var count = 0
        while (count<=11){
            arr.forEach {

            }
        }

        bw.write("${getMaxDivLength(0,799,200)}")
    }

    bw.flush()
}


