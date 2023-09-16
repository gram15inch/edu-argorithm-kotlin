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
        val smallest = getSmallestFromStart(arr, select)
        switchAtoB(arr, select, smallest)
    }while (++select < arr.size)

    return arr
}

private fun getSmallestFromStart(array:IntArray, start :Int):Int{
    var smallest = start
    var select = start + 1
    if (select >= array.size)
        return start

    do{
        if (array[smallest] > array[select])
            smallest = select
    } while (++select < array.size)

    return smallest
}

