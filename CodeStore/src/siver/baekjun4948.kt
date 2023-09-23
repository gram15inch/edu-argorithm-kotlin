package siver


/*
베르트랑 공준은 임의의 자연수 n에 대하여, n보다 크고, 2n보다 작거나 같은 소수는 적어도 하나 존재한다는 내용을 담고 있다.

이 명제는 조제프 베르트랑이 1845년에 추측했고, 파프누티 체비쇼프가 1850년에 증명했다.

예를 들어, 10보다 크고, 20보다 작거나 같은 소수는 4개가 있다. (11, 13, 17, 19) 또, 14보다 크고, 28보다 작거나 같은 소수는 3개가 있다. (17,19, 23)

자연수 n이 주어졌을 때, n보다 크고, 2n보다 작거나 같은 소수의 개수를 구하는 프로그램을 작성하시오.


input>
입력은 여러 개의 테스트 케이스로 이루어져 있다. 각 케이스는 n을 포함하는 한 줄로 이루어져 있다.

입력의 마지막에는 0이 주어진다.

output>
각 테스트 케이스에 대해서, n보다 크고, 2n보다 작거나 같은 소수의 개수를 출력한다
*/
fun baekjun4948(input: List<String>): List<String> {

    val result = mutableListOf<String>()
    input.forEach {n->
        val N = n.toInt() + 1
        val N2 = 2 * N
        val rangeSize = N2 - N +1
        val range = IntArray(rangeSize){idx-> idx + N}
        if(N==2)
            result.add("1")
        else {
            val count = range.getPrimeCount().toString()
            result.add(count)
        }
    }

    return result
}

fun IntArray.getPrimeCount():Int {
    var firstBeforeDelete = 2
    val last = last()
    do{
        firstBeforeDelete = this.getFirstBeforeDelete(firstBeforeDelete)
        firstBeforeDelete = this.deleteMultipleFrom(firstBeforeDelete)
    }
    while(++firstBeforeDelete <= last && (firstBeforeDelete < this.size))
    return this.filter { isNotDelete(it) }.size
}

private fun IntArray.deleteMultipleFrom(first: Int):Int{
    var idx = 0
    val current = first
    do {
        if (isMultipleNotFirst(current, idx)) {
            this.deleteP(idx)
        }
    } while (++idx < this.size)
    return first
}

private fun IntArray.isMultipleNotFirst(current: Int, first: Int):Boolean {
    val arr = this[first]
    if(arr==-1) return false
    if(current < this[first])
        return current != arr && (arr % current) == 0
    else
        return current != arr && (current % arr) == 0
}


private fun IntArray.getFirstBeforeDelete(before: Int): Int {
    var isNoPForRotation = true
    var current = before
    if(first() > current)
        return current
    do {
        if (isNotDelete(this[current])) {
            isNoPForRotation = false
        }
    } while (isNoPForRotation && ++current < this.size)
    return current
}

private fun isNotDelete(p: Int): Boolean {
    return p != -1
}

private fun IntArray.deleteP( i: Int) {
    this[i] = -1
}