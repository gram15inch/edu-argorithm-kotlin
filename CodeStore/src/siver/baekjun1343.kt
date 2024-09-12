package siver

private fun baekjun1343() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val line = br.readLine()
    var xLength = 0
    val sb = StringBuilder()
    for(idx in line.indices){
        when(line[idx]){
            'X'->{
                xLength++
                if(xLength==4) {
                    sb.append("AAAA")
                    xLength=0
                }
            }
            '.'->{
                if(xLength==2) {
                    sb.append("BB.")
                    xLength=0
                } else if(xLength>0) {
                    bw.write("-1")
                    bw.flush()
                    return
                }else{
                    sb.append(".")
                }
            }
        }
    }

    if(xLength==2) {
        sb.append("BB")
    } else if(xLength>0) {
        bw.write("-1")
        bw.flush()
        return
    }

    bw.write(sb.toString())


    bw.flush()
}