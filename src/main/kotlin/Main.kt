
import java.io.BufferedWriter


fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val counts = br.readLine().toInt()
    val leftArray = Array<Int>(counts+1){-1}
    var inTop = 0
    var leftIdx = -1
    val peopleInLine = br.readLine().toString()
    val peopleArray = peopleInLine.split(" ")
    var isNotWrite = true
    for(it in peopleArray) {
        val peopleNum = it.toInt()
        when{
            peopleNum == inTop + 1 -> inTop++
            leftIdx == -1 -> leftArray[++leftIdx] = peopleNum

            peopleNum < leftArray[leftIdx] -> { leftArray[++leftIdx] = peopleNum }

            peopleNum > leftArray[leftIdx] && inTop+1 == leftArray[leftIdx] -> {
                inTop++
                leftIdx--
                while (leftIdx !=-1 && inTop+1 == leftArray[leftIdx]){
                    inTop++
                    leftIdx--
                }
                if(peopleNum == inTop+1)
                    inTop++
                else
                    leftArray[++leftIdx] = peopleNum
            }
            else -> {
                bw.write("Sad")
                isNotWrite = false
                break
            }
        }
    }
    if(isNotWrite)
        bw.write("Nice")
    bw.flush()
}


fun BufferedWriter.printLines(lines:List<String>){
    lines.forEach {
        this.write("$it\n")
    }
    this.flush()
}

fun BufferedWriter.printLines(line:String){
    this.write(line)
    this.flush()
}

