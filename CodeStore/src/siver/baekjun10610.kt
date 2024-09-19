package siver

private fun baekjun10610() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val n = br.readLine().toCharArray().sortedDescending().toCharArray()

    var sum = 0
    if(n.last()=='0') {
        for(num in n)
            sum+=num.code-48
        if(sum%3==0) {
            bw.write(n)
            bw.flush()
            return
        }
    }

    bw.write("-1")
    bw.flush()
}