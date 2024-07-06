package siver

import java.io.StreamTokenizer
import kotlin.math.abs

@Suppress("unused")
private fun baekjun1259(){
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()



    StreamTokenizer(br).apply {
        fun getInt(): Int {
            nextToken()
            return nval.toInt()
        }

        while (true){
            val line = br.readLine()
            if(line=="0")
                break

            fun isPal(a:Int,b:Int):Boolean{
                return line[a] == line[b]
            }

            if(line.length%2==0){
                var a: Int = (line.length / 2) - 1
                var b = a + 1
                var result = "yes"
                while (a>=0 && b < line.length){
                    if(!isPal(a--,b++)) {
                        result = "no"
                        break
                    }
                }
                bw.write("$result\n")
            } else {
                var a: Int = (line.length / 2) - 1
                var b = a + 2
                var result ="yes"
                while (a>=0 && b < line.length){
                    if(!isPal(a--,b++)) {
                        result = "no"
                        break
                    }
                }
                bw.write("$result\n")
            }

        }
    }


    bw.flush()


}
