import java.util.StringTokenizer


fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()



    val n= br.readLine().toInt()
    val hash = HashMap<Int,String>()

    repeat(n) {
        val st = StringTokenizer(br.readLine())
        val name = st.nextToken()
        val status = st.nextToken()

         if(hash.getOrDefault(name.hashCode(),"")=="")
             hash[name.hashCode()] = name
         else
             when(status){
                "enter"->{ hash[name.hashCode()] = name }
                "leave"->{ hash.remove(name.hashCode()) }
             }
    }

    hash.map{it.value}.sortedByDescending { it }.forEach {
        bw.write("${it}\n")
    }

    bw.flush()
}





