package siver

import java.util.*

@Suppress("unused")
fun baekjun24060() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val st1= StringTokenizer(br.readLine())
    val arraySize = st1.nextToken().toInt()
    val saveTimes = st1.nextToken().toInt()
    val ms = NumInMergeSort(arraySize, saveTimes)
    val st2 = StringTokenizer(br.readLine())
    val array =IntArray(arraySize){st2.nextToken().toInt()}

    ms.merge_sort(array,0,array.size-1)
    bw.write("${ms.num}")
    bw.flush()
}

class NumInMergeSort(arraySize :Int, val saveTimes:Int){
    var count = 0
    var num = -1
    var isNotFInd = true
    var tmpArr = IntArray(arraySize)

    fun merge_sort(arr:IntArray, start:Int, end:Int){
        if(start < end && isNotFInd){
            val mid:Int = (start + end) / 2
            merge_sort(arr, start, mid)
            if(!isNotFInd)
                return
            merge_sort(arr, mid+1, end)
            if(!isNotFInd)
                return
            merge(arr, start, mid, end)
        }
    }

    fun merge(arr: IntArray, start: Int, mid: Int, end: Int) {
        if(isNotFInd){
            var lStart = start
            var rStart = mid + 1
            var tmp = 0

            while (lStart <= mid && rStart <= end) {
                if (arr[lStart] <= arr[rStart])
                    tmpArr[tmp++] = arr[lStart++]
                else
                    tmpArr[tmp++] = arr[rStart++]
            }

            while (lStart < mid + 1) {
                tmpArr[tmp++] = arr[lStart++]
            }

            while (rStart <= end) {
                tmpArr[tmp++] = arr[rStart++]
            }

            var mStart = start
            var mTmp = 0
            while (mStart <= end) {
                count++
                if (count == saveTimes) {
                    num = tmpArr[mTmp]
                    //  isNotFInd = false
                    //  return
                }
                arr[mStart++] = tmpArr[mTmp++]
            }
        }
    }
}