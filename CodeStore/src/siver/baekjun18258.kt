package siver

@Suppress("unused")
fun baekjun18258() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()


    val count = br.readLine().toInt()

    val queue = IntArray(count)
    var frontIdx = -1
    var backIdx = -1
    repeat(count){
        val line = br.readLine().split(" ")
        when(line[0]){
            "push"->{
                if(frontIdx==-1) {
                    queue[0] = line[1].toInt()
                    frontIdx = 0
                    backIdx = 0
                }else{
                    queue[++backIdx] = line[1].toInt()
                }
            }
            "pop"->{
                if(frontIdx!=-1) {
                    bw.write("${queue[frontIdx++]}\n")
                    if(frontIdx > backIdx) {
                        frontIdx = -1
                        backIdx = -1
                    }
                }
                else
                    bw.write("-1\n")
            }
            "size"->{
                when{
                    frontIdx ==-1->{
                        bw.write("0\n")
                    }
                    else-> bw.write("${backIdx - frontIdx + 1}\n")
                }
            }
            "empty"->{
                if(frontIdx == -1)
                    bw.write("1\n")
                else
                    bw.write("0\n")
            }
            "front"->{
                if(frontIdx == -1)
                    bw.write("-1\n")
                else
                    bw.write("${queue[frontIdx]}\n")
            }
            "back"->{
                if(frontIdx == -1)
                    bw.write("-1\n")
                else
                    bw.write("${queue[backIdx]}\n")
            }
        }
    }

    bw.flush()
}