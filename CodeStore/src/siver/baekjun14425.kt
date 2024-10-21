package siver
import java.util.StringTokenizer

@Suppress("unused")
fun baekjun14425() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()


    val st =  StringTokenizer(br.readLine())
    val n= st.nextToken().toInt()
    val m= st.nextToken().toInt()

    var count=0
    val hash = HashMap<Int,Boolean>()
    repeat(n) {
        hash[br.readLine().hashCode()] = true
    }

    repeat(m){
        if(hash[br.readLine().hashCode()] == true)
            count++
    }
    bw.write("$count")
    bw.flush()
}
