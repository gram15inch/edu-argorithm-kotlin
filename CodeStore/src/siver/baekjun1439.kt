package siver

private fun baekjun1439() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()


    val line =br.readLine()
    var one = 0
    var zero = 0
    var latest =-1
    for(num in line.indices)
        when(line[num]) {
            '0' -> {
                if(latest==1||latest==-1) {
                    zero++
                    latest=0
                }
            }

            '1' -> {
                if(latest==0||latest==-1) {
                    one++
                    latest=1
                }
            }
        }
    bw.write("${if(one>zero)zero else one}")


    bw.flush()
}