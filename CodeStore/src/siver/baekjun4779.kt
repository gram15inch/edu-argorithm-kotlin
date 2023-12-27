package siver

import kotlin.math.pow

@Suppress("unused")
fun baekjun4779(){
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    var line = ""
    while (br.readLine().run {
            if(this!=null) {
                line = this
                line.isNotEmpty()
            }else
                false
        }) {
        val n = line.toInt()
        val barLength = (3.0).toFloat().pow(n)
        val bar = Array(barLength.toInt()){"-"}
        kantorSet(bar,0,barLength.toInt()-1)
        bar.forEach {
            if(it.isBlank())
                bw.write(" ")
            else
                bw.write(it)
        }
        bw.write("\n")
    }

    bw.flush()
}
fun kantorSet(arr:Array<String>,start:Int, end:Int){
    val lMid:Int = ((end -start +1)/3) - 1 + start
    val rMid:Int = (((end -start +1)/3) * 2) + start
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