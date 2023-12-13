import java.util.StringTokenizer

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val st1= StringTokenizer(br.readLine())
    val arraySize = st1.nextToken().toInt()
    val saveTimes = st1.nextToken().toInt()

    val st2 = StringTokenizer(br.readLine())
    val array =IntArray(arraySize){st2.nextToken().toInt()}

    //val sortedArray = mergeSort(array,0,array.size-1, saveTimes)
    //bw.write(sortedArray.toList().toString())
    //bw.write("\n"+last)
    bw.flush()
}

fun merge_sort(arr:IntArray, start:Int, end:Int){
    if(start < end){
        val mid:Int = (start + end) / 2
        merge_sort(arr, start, mid)
        merge_sort(arr, mid+1, end)
        merge(arr, start, end, mid)
    }
}

fun merge(arr: IntArray, start: Int, mid: Int, end: Int) {
    var lStart = start
    var rStart = end+1
    var tmp = 1
    val tmpArr = IntArray(arr.size)
    while (lStart <= end && rStart <= mid){
        if(arr[lStart]<= arr[rStart])
            tmpArr[tmp++] = arr[lStart++]
        else
            tmpArr[tmp++] = arr[rStart++]
    }
}
/*

# A[p..q]와 A[q+1..r]을 병합하여 A[p..r]을 오름차순 정렬된 상태로 만든다.
# A[p..q]와 A[q+1..r]은 이미 오름차순으로 정렬되어 있다.
merge(A[], p, q, r) {
    i <- p; j <- q + 1; t <- 1;
    while (i ≤ q and j ≤ r) {
        if (A[i] ≤ A[j])
        then tmp[t++] <- A[i++]; # tmp[t] <- A[i]; t++; i++;
        else tmp[t++] <- A[j++]; # tmp[t] <- A[j]; t++; j++;
    }
    while (i ≤ q)  # 왼쪽 배열 부분이 남은 경우
        tmp[t++] <- A[i++];
    while (j ≤ r)  # 오른쪽 배열 부분이 남은 경우
        tmp[t++] <- A[j++];
    i <- p; t <- 1;
    while (i ≤ r)  # 결과를 A[p..r]에 저장
        A[i++] <- tmp[t++];
}

merge_sort(A[p..r]) { # A[p..r]을 오름차순 정렬한다.
    if (p < r) then {
        q <- ⌊(p + r) / 2⌋;       # q는 p, r의 중간 지점
        merge_sort(A, p, q);      # 전반부 정렬
        merge_sort(A, q + 1, r);  # 후반부 정렬
        merge(A, p, q, r);        # 병합
    }
}

* */