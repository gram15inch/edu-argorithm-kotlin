package siver

fun baekjun10773(){
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    var line = br.readLine()
    var sum =0

    val array = Array(100001){0}
    var nextIdx = 0

    repeat (line.toInt()){
        br.readLine().toInt().let {
            if(it!=0) {
                sum += it
                array[nextIdx++] = it
            }
            else
                if(--nextIdx >= 0)
                    sum -= array[nextIdx]
        }

    }
    bw.write("$sum")


    bw.flush()
}