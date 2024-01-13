package siver
import java.util.StringTokenizer

@Suppress("unused")
fun baekjun11650() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val n= br.readLine().toInt()
    size
    val arr = Array(n){val st = StringTokenizer(br.readLine())
        Map(st.nextToken().toInt(), st.nextToken().toInt())}
    mergeSort(arr,0, arr.size-1)

    for(num in arr){
        bw.write("${num.x} ${num.y}\n")
    }
    bw.flush()
}

private data class Map(val x:Int, val y :Int) : Comparable<Map> {
    override fun compareTo(other: Map): Int {

        return if(this.x != other.x)
            this.x - other.x
        else
            this.y - other.y
    }
}

private fun mergeSort(arr:Array<Map>, start:Int, end:Int){
    if(start < end){
        val mid:Int = (start + end) / 2
        mergeSort(arr, start, mid)
        mergeSort(arr, mid+1, end)
        merge(arr, start, mid, end)
    }
}
private var size = 0
private val tmpArr by lazy { Array(size) { Map(0, 0) } }
private fun merge(arr: Array<Map>, start: Int, mid: Int, end: Int) {
    var lStart = start
    var rStart = mid+1
    var tmp = 0

    while (lStart <= mid && rStart <= end){
        if(arr[lStart] <= arr[rStart])
            tmpArr[tmp++] = arr[lStart++]
        else
            tmpArr[tmp++] = arr[rStart++]
    }

    while (lStart<mid+1){
        tmpArr[tmp++] = arr[lStart++]
    }

    while (rStart<=end){
        tmpArr[tmp++] = arr[rStart++]
    }

    var mStart = start
    var mTmp = 0
    while (mStart <= end){
        arr[mStart++] = tmpArr[mTmp++]
    }
}
