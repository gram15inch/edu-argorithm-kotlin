import java.util.StringTokenizer

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val st1= StringTokenizer(br.readLine())
    val arraySize = st1.nextToken().toInt()
    val saveTimes = st1.nextToken().toInt()

    val st2 = StringTokenizer(br.readLine())
    val array =IntArray(arraySize){st2.nextToken().toInt()}

    val sortedArray = mergeSort(array,0,array.size-1,saveTimes)
    bw.write(sortedArray.toList().toString())
    bw.write("\n"+last)
    bw.flush()
}

var count =0
var last = 0
fun mergeSort(array: IntArray, leftIdx:Int, rightIdx:Int, saveTime:Int): IntArray {
    if(leftIdx == rightIdx)
        return IntArray(1){array[leftIdx]}
    val midIdx :Int = (leftIdx + rightIdx)/2

    val leftArray = mergeSort(array, leftIdx, midIdx, saveTime)
    val rightArray = mergeSort(array,midIdx+1, rightIdx, saveTime)

    return merge(leftArray,rightArray, saveTime)
}
fun merge(leftArr:IntArray, rightArr: IntArray, saveTime: Int): IntArray {
    val mergeArr = IntArray(leftArr.size + rightArr.size)
    var lIdx = 0
    var rIdx = 0

    while(lIdx+rIdx <= mergeArr.size-1){
        val result:Int
        if(lIdx < leftArr.size && rIdx< rightArr.size) {
            if (leftArr[lIdx] < rightArr[rIdx]) {
                mergeArr[lIdx + rIdx] = leftArr[lIdx]
                result = leftArr[lIdx++]
            }
            else {
                mergeArr[lIdx + rIdx] = rightArr[rIdx++]
                result = rightArr[rIdx++]
            }
        }else if(lIdx < leftArr.size){
            mergeArr[lIdx + rIdx] = leftArr[lIdx]
            result = leftArr[lIdx++]
        }else {
            mergeArr[lIdx + rIdx] = rightArr[rIdx]
            result = leftArr[lIdx++]
        }

        if(++count == saveTime)
            last = result
    }

    return mergeArr
}