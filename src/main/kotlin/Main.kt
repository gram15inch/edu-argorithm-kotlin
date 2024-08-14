import java.io.StreamTokenizer
import java.util.*


fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    StreamTokenizer(br).apply {
        fun getInt(): Int {
            nextToken()
            return nval.toInt()
        }


        val n = getInt()
        val arr = IntArray(n){getInt()}
        val stack = Stack<Int>()
        var idx = 0
        var num = 1
        var collect = 0
        while (collect<n){
            if(arr[idx]==num){
                stack.push(num++) // todo 계속비교
                bw.write("+\n")

                idx++
                collect++
                stack.pop()
                bw.write("-\n")
            }else{
                if(stack.isEmpty() || stack.peek() < num) {
                    stack.push(num++)
                    bw.write("+\n")
                }
            }
        }
    }

    bw.flush()
}


