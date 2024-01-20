import java.util.StringTokenizer


fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val n= br.readLine().toInt()
    val st =  StringTokenizer(br.readLine())
    val arr1 = Array(n){st.nextToken().toInt() }
    val arr2 = arr1.distinct().sorted()
    val hash = HashMap<Int,Int>()
    arr2.forEachIndexed { idx, num->
        hash.put(num, idx)
    }

    for(num1 in arr1) {
        bw.write("${hash.get(num1)} ")
    }

    bw.flush()
}





