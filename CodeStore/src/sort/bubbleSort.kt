package sort

fun bubbleSort(arr: IntArray): IntArray {
    val n = arr.size
    for (i in 0..<n) {
        for (j in 0..<n - i - 1) {
            if (arr[j] > arr[j + 1]) {
                val temp = arr[j]
                arr[j] = arr[j + 1]
                arr[j + 1] = temp
            }
        }
    }
    return arr
}

private const val MOVE_ONE_FROM_START = 1
fun bubbleSort2(arr: IntArray): IntArray {

   var sortedCount = 0
    do{
        var select = MOVE_ONE_FROM_START
        do{
            if(selectSmallerThanBefore(arr, select))
                switchAtoB(arr, getBeforeIdx(select), select)
        }
        while (++select < arr.size - sortedCount)
    }while (++sortedCount < arr.size)
    return arr
}

fun switchAtoB(arr: IntArray, beforeIdx: Int, selectIdx: Int) {
    val temp = arr[beforeIdx]
    arr[beforeIdx] = arr[selectIdx]
    arr[selectIdx] = temp
}

private fun selectSmallerThanBefore(array:IntArray, select:Int):Boolean{
    return array[getBeforeIdx(select)] > array[select]
}

private fun getBeforeIdx(select:Int):Int{
    return select - MOVE_ONE_FROM_START
}
