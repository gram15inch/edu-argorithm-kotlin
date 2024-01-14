import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ArrayTest {

    @Test
    fun arrayEditByParameter(){
        val a = IntArray(10){0}
        plus(a,0)
        assertEquals(1, a[0])
        plus(a,0)
        assertEquals(2, a[0])
        plus(a,0)
        assertEquals(3, a[0])
    }

    fun plus(a:IntArray,idx:Int){
        a[idx]++
    }

    @Test
    fun compareTest(){
        val arr = arrayOf(
            User(10,"aaa"),
            User(10,"bb"),
            User(20,"aaa"),
            User(20,"cc"),
            User(30,"aaa"),
            User(30,"dd"),
            )
        mergeSort(arr,0,arr.size-1)
        arr.toList().forEach {
            println(it)
        }

        println(User(10,"aaa") < User(10,"bb"))
        println(User(10,"aa") < User(20,"bb"))

    }

    data class User(val age:Int, val name:String):Comparable<User>{
        override fun compareTo(other: User): Int {
            return if(this.age != other.age) {
                this.age - other.age
            }
            else {
                if(this.name > other.name) 1 else -1
            }
        }
    }


    private fun mergeSort(arr:Array<User>, start:Int, end:Int){
            if(start < end){
                val mid:Int = (start + end) / 2
                mergeSort(arr, start, mid)
                mergeSort(arr, mid+1, end)
                merge(arr, start, mid, end)
            }
        }

    private fun merge(arr: Array<User>, start: Int, mid: Int, end: Int) {
        var lStart = start
        var rStart = mid+1
        var tmp = 0
        val tmpArr = Array(arr.size){User(0,"")}
        while (lStart <= mid && rStart <= end){
            if(arr[lStart] < arr[rStart])
                tmpArr[tmp++] = arr[lStart++]
            else
                tmpArr[tmp++] = arr[rStart++]
        }

        while (lStart<mid+1){
            tmpArr[tmp++] = arr[lStart++]
        }

        while (rStart<=end){
            tmpArr[tmp++] = arr[rStart++]
        }

        var mStart = start
        var mTmp = 0
        while (mStart <= end){
            arr[mStart++] = tmpArr[mTmp++]
        }
    }

}