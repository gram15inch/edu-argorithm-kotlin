import java.util.StringTokenizer


fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val n= br.readLine().toInt()
    val st =  StringTokenizer(br.readLine())
    val arr1 = Array(n){st.nextToken().toInt() }
    val arr2 = arr1.toSet().toIntArray()
    arr2.sortDescending()

    for(num1 in arr1) {
       val num = parseNum(arr2, num1)
        bw.write("$num ")
    }

    bw.flush()
}

private fun parseNum(arr2:IntArray, num:Int):Int{
    arr2.forEachIndexed { index, it ->
        if(num >= it) {
            return arr2.size - (index + 1)
        }
    }
    return 0
}




