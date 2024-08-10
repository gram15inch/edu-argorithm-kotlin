import java.io.StreamTokenizer
import java.util.LinkedList
import java.util.Queue


fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    StreamTokenizer(br).apply {
        fun getInt(): Int {
            nextToken()
            return nval.toInt()
        }


        val n = getInt()
        repeat(n){
            val size = getInt()
            val searchIdx = getInt()
            val que:Queue<Pair<Int,Int>> = LinkedList<Pair<Int,Int>>()

            var max = 9
            repeat(size){
                que.add(Pair(it,getInt()))
            }

            var isWrite = false
            var delete = 0
            while (!isWrite){

                if(max == que.peek().second){
                    delete++
                    que.poll().apply {
                        if(searchIdx==this.first){
                            isWrite=true
                            bw.write("$delete\n")
                        }else{
                            que.add(this)
                        }
                    }
                }
            }


        }
    }

    bw.flush()

}


