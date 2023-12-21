package sort


fun mergeSort(arr:IntArray, start:Int, end:Int){
    if(start < end){
        val mid:Int = (start + end) / 2
        mergeSort(arr, start, mid)
        mergeSort(arr, mid+1, end)
        merge(arr, start, mid, end)
    }
}

private fun merge(arr: IntArray, start: Int, mid: Int, end: Int) {
    var lStart = start
    var rStart = mid+1
    var tmp = 0
    val tmpArr = IntArray(arr.size)
    while (lStart <= mid && rStart <= end){
        if(arr[lStart]<= arr[rStart])
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