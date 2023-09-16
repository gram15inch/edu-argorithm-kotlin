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
    input.forEach {
        val N = it.toInt() // 배열의 마지막 수
        val N2 = 2 * N

        if (N == 1)
            result.add("1")
        else {
            val firstInRange = N
            val rangeSize = N2 - N + 1
            val range = IntArray(rangeSize) { it + firstInRange }

            var P: Int = firstInRange // 아직 지우지 않은 수 중 가장 작은 수, 이 수는 소수.
            var countOfDelete = 0

            var pRotaion = 0

            do {
                // 아직 지우지 않은 수 중 가장 작은 수를 찾기
                pRotaion = getSmallestFirstPRotation(range, pRotaion)
                P = range[pRotaion]

                //P의 배수대로 지운다
                countOfDelete = deleteMultipleOfPUntilK(range, P, countOfDelete)
                //todo 카운트 쓰면 안됨 다른방법 연구
            } while (countOfDelete < range.size)
            result.add(range.filter { it != -1 }.size.toString())
        }

    }






    return input
}

private data class State2(val deleteCount: Int, val latestDelete: Int)

private fun deleteMultipleOfPUntilK(range: IntArray, p: Int, countOfDelete: Int): Int {
    var rangeRotation = 0
    var localCountOfDelete = countOfDelete
    do {
        if ((range[rangeRotation] != p) && (range[rangeRotation] % p) == 0) {
            deleteP(range, rangeRotation)
            ++localCountOfDelete
        }
    } while (++rangeRotation < range.size)
    return localCountOfDelete
}


private fun getSmallestFirstPRotation(range: IntArray, currentRotation: Int): Int {
    var isNoPForRotation = true
    var pRotation = currentRotation
    do {
        if (isNotDeleteP(range[pRotation])) {
            isNoPForRotation = false
        }
    } while (isNoPForRotation && ++pRotation < range.size)
    return pRotation
}

private fun isNotDeleteP(p: Int): Boolean {
    return p != -1
}

private fun deleteP(range: IntArray, i: Int) {
    range[i] = -1
}