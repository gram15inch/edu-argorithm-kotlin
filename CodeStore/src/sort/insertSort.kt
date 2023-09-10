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