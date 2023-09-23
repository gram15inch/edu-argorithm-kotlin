package sort

fun selectionSort(arr: IntArray) {
    val n = arr.size
    for (i in 0..<n - 1) {
        var minIndex = i
        for (j in i + 1..<n) {
            if (arr[j] < arr[minIndex]) {
                minIndex = j
            }
        }
        if (minIndex != i) {
            val temp = arr[i]
            arr[i] = arr[minIndex]
            arr[minIndex] = temp
        }
    }
}


fun selectionSort2(arr: IntArray):IntArray  {

    var select = 0
    do{
        val smallest = getSmallestFromSelectToEnd(arr, select)
        switchAtoB(arr, select, smallest)
    }while (++select < arr.size)

    return arr
}

private fun getSmallestFromSelectToEnd(array:IntArray, select :Int):Int{
    var smallest = select
    var start = select + 1
    if (start >= array.size)
        return start

    do{
        if (array[smallest] > array[start])
            smallest = start
    } while (++start < array.size)

    return smallest
}

