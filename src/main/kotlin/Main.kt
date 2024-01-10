import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()


    val st1 = StringTokenizer(br.readLine())
    val N = st1.nextToken().toInt()
    var step = 1
    var latestNumString = "666"
    var preInt =0
    while(step <= N){
        when{
            isNoDigitAfter666(latestNumString) || isNearest9After666(latestNumString)->{
                preInt = 0
                while(preInt == '5') {

                    step++
                }
            }
            isNearest5Before666(latestNumString)->{

            }
        }
    }

    bw.write("")
    bw.flush()
}

private fun isNoDigitAfter666(num:String):Boolean{
    return true
}


private fun isNearest9After666(num:String):Boolean{
    return true
}

private fun isNearest5Before666(num:String):Boolean{
    return true
}


