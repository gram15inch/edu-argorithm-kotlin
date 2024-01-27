import java.util.*
import kotlin.collections.HashMap


fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val n= br.readLine().toInt()
    val hash = HashMap<String,Boolean>()

    repeat(n) {
        val st = StringTokenizer(br.readLine())
        val name = st.nextToken()
        val status = st.nextToken()

        hash[name]=when(status){
            "enter" -> true
            else -> false
        }
    }

    hash.asSequence().filter{it.value}.map{it.key}.sortedByDescending { it }.forEach {
        bw.write("${it}\n")
    }

    bw.flush()
}





