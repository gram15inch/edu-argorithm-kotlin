package siver

@Suppress("unused")
fun baekjun4949(){
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    while (true){
        val line = br.readLine()
        if(line==".") {
            break
        }
        val array = Array(101){' '}
        var lineIdx = -1
        var psIdx = -1
        var isNotWrite = true
        while (isNotWrite) {
            val a= line[++lineIdx]
            when(a){
                '('-> array[++psIdx] = '('
                '['-> array[++psIdx] = '['
                ')'-> {
                    if(psIdx > -1 && array[psIdx]=='(') {
                        psIdx--
                    } else {
                        bw.write("no\n")
                        isNotWrite = false
                    }
                }
                ']'-> {
                    if(psIdx > -1 &&  array[psIdx]=='[') {
                        psIdx--
                    } else {
                        bw.write("no\n")
                        isNotWrite = false
                    }
                }
                '.'-> {
                    if(psIdx < 0)
                        bw.write("yes\n")
                    else
                        bw.write("no\n")
                    isNotWrite = false
                }
            }

        }
    }

    bw.flush()
}