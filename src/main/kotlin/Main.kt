import java.io.BufferedWriter



fun main(args: Array<String>) {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val result= mutableListOf<String>()

    val line = br.readLine()
   // result.add()

    bw.printLines(result)
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
