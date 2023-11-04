package siver

@Suppress("unused")
fun baekjun12789 (){
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    br.readLine()
    val peopleInLine = br.readLine().toString()
    val peopleArray = peopleInLine.split(" ").map { it.toInt() }
    val stack = Array(peopleArray.size + 1){-1}
    var peopleIdx = -1
    var passNum = 1
    var stackIdx = -1
    var isWrite = false

    do{
        val peopleOrder = if(peopleIdx + 1 < peopleArray.size)
            peopleArray[peopleIdx + 1]
        else
            -1

        when{
            // 라인에서 패스
            passNum == peopleOrder ->{
                passNum++
                peopleIdx++
            }
            // 스택이 비었을떄
            stackIdx == -1->{
                stackIdx=0
                stack[stackIdx] = peopleOrder
                peopleIdx++
            }
            //스택에서 패스
            passNum == stack[stackIdx] -> {
                passNum++
                stack[stackIdx--] = -1
            }

            //스택보다 라인이 클떄
            stack[stackIdx] < peopleOrder -> {
                bw.write("Sad")
                isWrite = true
            }
            //스택보다 라인이 작을떄
            stack[stackIdx] > peopleOrder -> {
                stack[++stackIdx] = peopleOrder
                peopleIdx++
            }
            // 라인, 스택의 모든 수를 확인했을떄
            passNum == peopleArray.size+1->{
                bw.write("Nice")
                isWrite = true
            }
            // 라인의 모든 수를 확인했을때
            peopleOrder == -1 ->{
                passNum++
                stack[stackIdx--] = -1
            }
            else-> {
                bw.write("Sad")
                isWrite = true
            }
        }
    }while (!isWrite)

    bw.flush()





}