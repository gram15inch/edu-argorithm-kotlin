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