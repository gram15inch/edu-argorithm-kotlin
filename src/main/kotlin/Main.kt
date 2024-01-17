import java.util.StringTokenizer

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val n= br.readLine().toInt()
    val st =  StringTokenizer(br.readLine())
    val arr1 = Array(n){st.nextToken().toInt() }
    val arr2 = Array(arr1.size){0}
    var list1 = mutableListOf<Int>()
    var arr3 = IntArray(0)
    for(num1 in 0..< arr1.size) {
        list1.clear()
        arr3 = IntArray(0)
        for (num2 in 0..<arr1.size) {
            val a = arr1[num1]
            val b = arr1[num2]
            if (a > b && !isContains(arr3, b)) {
                arr2[num1]++
                list1.add(b)
                arr3 = list1.toIntArray()
                insertionSort(arr3)
                list1 = arr3.toMutableList()
            }
        }
    }

    for(num in arr2){
        bw.write("$num ")
    }
    bw.flush()
}

private fun isContains(arr:IntArray,num:Int):Boolean{
    arr.forEach {
        if(it<num)
            return false
        if(it==num)
            return true
    }
    return false
}


fun insertionSort(arr: IntArray) {
    val n = arr.size

    for (i in 1 until n) {
        val key = arr[i]
        var j = i - 1

        // 이미 정렬된 부분에서 key보다 큰 원소를 찾아 적절한 위치에 삽입
        while (j >= 0 && arr[j] > key) {
            arr[j + 1] = arr[j]
            j--
        }

        arr[j + 1] = key
    }
}
