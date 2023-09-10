package sort

fun insertionSort(arr: IntArray) {
    val n = arr.size
    for (i in 1..<n) {
        val key = arr[i]
        var j = i - 1
        // key 값을 적절한 위치에 삽입
        while (j >= 0 && arr[j] > key) {
            arr[j + 1] = arr[j]
            j--
        }
        arr[j + 1] = key
    }
}

fun insertionSort2(arr: IntArray):IntArray {
    val searchStart = 1
    val searchEnd = arr.size - searchStart

    var sortedCount = 0
    do{
        val select = searchStart + sortedCount
        var sortedGroupSelect = 0
        var isNotInsert = true
        do {
            if (selectSmallerThanSortedGroupSelect(arr, select, sortedGroupSelect)) {
                insertAToB(arr, select, sortedGroupSelect)
                isNotInsert = false
            }
        } while (isNotInsert && ++sortedGroupSelect < select)

    } while (++sortedCount < searchEnd)

    return arr
}

private fun insertAToB(arr: IntArray, put:Int, replace:Int) {
    val temp = arr[put]
    moveNextStartToEnd(arr, replace, put)
    arr[replace] = temp
}

private fun moveNextStartToEnd(arr: IntArray, start:Int, end:Int){
    var moveSize = end-start
    do{
        val moveEnd = start + moveSize
        arr[moveEnd] = arr[moveEnd - 1]
    }
    while (--moveSize > 0)
}

private fun selectSmallerThanSortedGroupSelect(array:IntArray, select:Int, target:Int):Boolean{
    return array[select] < array[target]
}