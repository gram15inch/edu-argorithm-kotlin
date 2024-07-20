import java.io.StreamTokenizer


fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()


    StreamTokenizer(br).apply {
        fun getInt(): Int {
            nextToken()
            return nval.toInt()
        }

        fun getString(): String {
            nextToken()
            return sval.toString()
        }

        val n = getInt()
        val arr = IntArray(n)
        var front = -1
        var back = 0
        repeat(n){
            when(getString()){
                "push"->{
                    val nn = getInt()
                    if(front<0){
                        front++
                        arr[0] = nn
                    }
                    front++
                    arr[front] = nn
                }
                "pop"->{
                    if(front < back && front > 0) {
                        bw.write("${arr[front]}\n")
                        front++
                    } else {
                        bw.write("-1\n")
                    }
                }
                "size"->{
                    bw.write("${back-front+1}\n")
                }
                "empty"->{
                    bw.write("${if(front==-1) 1 else 0}\n")
                }
                "front"->{
                    bw.write("${if(front<0) -1 else arr[front] }\n")
                }
                "back"->{
                    bw.write("${if(front<0) -1 else arr[front] }\n")
                }
            }
        }

    }
    bw.flush()



}



