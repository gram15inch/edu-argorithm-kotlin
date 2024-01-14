package siver

import java.util.StringTokenizer

@Suppress("unused")
private fun baekjun10814() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val n= br.readLine().toInt()
    size =n
    val arr = Array(n){
        val st =  StringTokenizer(br.readLine())
        User(idCount++, st.nextToken().toInt(), st.nextToken())
    }

    mergeSort(arr,0, arr.size-1)

    for(user in arr){
        bw.write("${user.age} ${user.name}\n")
    }
    bw.flush()
}
private var idCount =0

private data class User(val id:Int, val age: Int, val name:String) : Comparable<User> {
    override fun compareTo(other: User): Int {

        return if(this.age != other.age)
            this.age - other.age
        else
            this.id - other.id
    }
}

private fun mergeSort(arr:Array<User>, start:Int, end:Int){
    if(start < end){
        val mid:Int = (start + end) / 2
        mergeSort(arr, start, mid)
        mergeSort(arr, mid+1, end)
        merge(arr, start, mid, end)
    }
}
private var size = 0
private val tmpArr by lazy { Array(size) { User(0,0,"") } }
private fun merge(arr: Array<User>, start: Int, mid: Int, end: Int) {
    var lStart = start
    var rStart = mid+1
    var tmp = 0

    while (lStart <= mid && rStart <= end){
        if(arr[lStart] < arr[rStart])
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
