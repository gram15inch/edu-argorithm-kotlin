import java.util.StringTokenizer
import kotlin.math.pow

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val st1= StringTokenizer(br.readLine())
    val n = st1.nextToken().toInt()
    val barLength = (3.0).pow(n)
    val bar = Array(barLength.toInt()){"-"}
    kantorSet(bar,0,barLength.toInt()-1)

    bw.write("${bar.toList()}")
    bw.flush()
}

//4779
fun kantorSet(arr:Array<String>,start:Int, end:Int){
    val lMid:Int = ((end+1)/3) -1
    val rMid:Int = (((end+1)/3)*2) -1
    if(end-start >= 2 && lMid < end && rMid>start){
        kantorSet(arr,start, lMid)
        kantorSet(arr, rMid, end)
        deleteBar(arr,lMid+1, rMid-1)
    }
}

fun deleteBar(arr:Array<String>, start: Int, end:Int) {
    (start..end).forEach {
        arr[it] =""
    }
}
