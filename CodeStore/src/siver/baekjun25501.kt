package siver

fun baekjun25501 (){

    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()


    val times = br.readLine().toInt()

    repeat(times){
        val str = br.readLine()
        bw.write("${Fibo.isPalindrome(str)} ${Fibo.count}\n")
    }

    bw.flush()
}
object Fibo{
    var count = 0
    fun recursion(s: String, l: Int, r: Int): Int {
        count++
        return when{
            (l >= r)-> 1
            (s[l] != s[r])-> 0
            else-> recursion(s, l + 1, r - 1)
        }
    }

    fun isPalindrome(s: String): Int {
        count = 0
        return recursion(s, 0, s.length - 1)
    }
}