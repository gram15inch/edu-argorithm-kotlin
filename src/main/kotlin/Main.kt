import siver.baekjun4948
import java.io.BufferedWriter



fun main(args: Array<String>) {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    var line = br.readLine()
    val lines = mutableListOf<String>()

    while (line!="0"){
        lines.add(line)
        line = br.readLine()
    }

    bw.printLines(baekjun4948(lines))
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
