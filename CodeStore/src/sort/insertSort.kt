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

@Suppress("LocalVariableName")
fun insertionSort2(arr: IntArray):IntArray {
    val SEARCH_START = 1
    val SEARCH_END = arr.size - SEARCH_START

    var sortedCount = 0
    do{
        val select = SEARCH_START + sortedCount
        var sortedGroupSelect = 0
        var isNotInsert = true
        do {
            if (arr.isSelectSmallerThanSortedGroupSelect(select, sortedGroupSelect)) {
                arr.insertAToB(select, sortedGroupSelect)
                isNotInsert = false
            }
        } while (isNotInsert && ++sortedGroupSelect < select)

    } while (++sortedCount < SEARCH_END)

    return arr
}

private fun IntArray.insertAToB( put:Int, replace:Int) {
    val temp = this[put]
    moveNextStartToEnd(this, replace, put)
    this[replace] = temp
}

private fun moveNextStartToEnd(arr: IntArray, start:Int, end:Int){
    var moveSize = end-start
    do{
        val moveEnd = start + moveSize
        arr[moveEnd] = arr[moveEnd - 1]
    }
    while (--moveSize > 0)
}

private fun IntArray.isSelectSmallerThanSortedGroupSelect( select:Int, target:Int):Boolean{
    return this[select] < this[target]
}