
import java.io.BufferedWriter



fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    var line = br.readLine()
    val myStack = MyStack()

    repeat (line.toInt()){
        myStack.baekjun28278(br.readLine()).let{
            if(it!="")
                bw.write("$it\n")
        }
    }




    bw.flush()
}

class MyStack{
    private val MAX_ORDER_SIZE = 1000000
    private val stack = Array(MAX_ORDER_SIZE+1){0}
    private var topIdx = 0

    fun put(p:Int):String{
        if(topIdx<MAX_ORDER_SIZE)
            stack[topIdx++] = p
        return ""
    }

    fun pop() = when {
        topIdx > 0 -> stack[--topIdx]
        else -> -1
    }.toString()


    fun getSize() = topIdx.toString()

    fun isEmpty() = when{
        topIdx >= 0 -> 1
        else -> 0
    }.toString()

    fun getTop()= when{
        topIdx > 0 -> stack[topIdx-1]
        else -> -1
    }.toString()

    fun baekjun28278(order:String):String{
        val orderGroup = order.split(" ").map { it.toInt() }
        val result = when(orderGroup[0]){
            1-> put(orderGroup[1])
            2-> pop()
            3-> getSize()
            4-> isEmpty()
            5-> getTop()
            else-> ""
        }
        return result
    }
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

