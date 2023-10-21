package siver

@Suppress("unused")
fun baekjun9012 (){
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    var line = br.readLine()



    repeat (line.toInt()){
        var left = 0
        var right = 0
        val line = br.readLine()
        var idx = -1
        var isNotWrite = true
        while (isNotWrite && ++idx<line.length) {
            when(line[idx]){
                '('-> left++
                ')'-> right++
            }
            if(left<right) {
                bw.write("NO\n")
                isNotWrite =false
            }
        }
        if(isNotWrite)
            if(left==right)
                bw.write("YES\n")
            else
                bw.write("NO\n")
    }

    bw.flush()
}