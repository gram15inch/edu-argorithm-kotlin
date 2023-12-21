import java.util.StringTokenizer
var arraySize =0
var saveTimes = 0
var count = 0
var num = -1
var isNotFInd = true
var tmpArr = IntArray(0)
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val st1= StringTokenizer(br.readLine())
    arraySize = st1.nextToken().toInt()
    saveTimes = st1.nextToken().toInt()

    val st2 = StringTokenizer(br.readLine())
    val array =IntArray(arraySize){st2.nextToken().toInt()}

    merge_sort(array,0,array.size-1)
    bw.write("$num")
    bw.flush()
}

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
                isNotFInd = false
                return
            }
            arr[mStart++] = tmpArr[mTmp++]
        }
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