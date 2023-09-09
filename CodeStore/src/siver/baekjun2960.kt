package siver


/*

에라토스테네스의 체는 N보다 작거나 같은 모든 소수를 찾는 유명한 알고리즘이다.

이 알고리즘은 다음과 같다.

2부터 N까지 모든 정수를 적는다.
아직 지우지 않은 수 중 가장 작은 수를 찾는다. 이것을 P라고 하고, 이 수는 소수이다.
P를 지우고, 아직 지우지 않은 P의 배수를 크기 순서대로 지운다.
아직 모든 수를 지우지 않았다면, 다시 2번 단계로 간다.
N, K가 주어졌을 때, K번째 지우는 수를 구하는 프로그램을 작성하시오.

*/

fun baekjun2960(input:String):String {
    val items = input.split(" ")

    // (1 ≤ K < N, max(1, K) < N ≤ 1000)
    val N = items[0].toInt() // 배열의 마지막 수
    val K = items[1].toInt() // 찾아야 할 삭제된 횟수
    val firstInRange = 2
    val rangeSize = N-2 + 1
    val range = IntArray(rangeSize){it + firstInRange}

    var P :Int = firstInRange // 아직 지우지 않은 수 중 가장 작은 수, 이 수는 소수.
    var countOfDelete = 0
    var latestDelete = 0

    var pRotaion = 0
    //모든수를 지우거나 K번째까지 지우거나
    while ((countOfDelete < K) &&
        (countOfDelete < range.size)) {

        // 아직 지우지 않은 수 중 가장 작은 수를 찾기
        pRotaion = getSmallestFirstPRotation(range, pRotaion)
        P = range[pRotaion]

        val current = State(countOfDelete, latestDelete)
        //P의 배수대로 K번쨰까지 지운다
        val result = deleteMultipleOfPUntilK(range, P, K , current)

        countOfDelete = result.deleteCount
        latestDelete = result.latestDelete
    }

    return latestDelete.toString()
}

private data class State(val deleteCount:Int, val latestDelete:Int)

private fun deleteMultipleOfPUntilK(range: IntArray, p:Int, k:Int, current: State): State {
    var rangeRotation = 0
    var countOfDelete =current.deleteCount
    var latestDelete = current.latestDelete
    do{
        if ((range[rangeRotation] % p) == 0) {
            latestDelete = range[rangeRotation]
            deleteP(range,rangeRotation)
            countOfDelete++
        }
    }
    while (countOfDelete < k && ++rangeRotation < range.size)

    return State(countOfDelete, latestDelete)
}

private fun getSmallestFirstPRotation(range: IntArray, currentRotation: Int):Int{
    var isNoPForRotation = true
    var pRotation = currentRotation
    do{
        if(isNotDeleteP(range[pRotation])) {
            isNoPForRotation = false
        }
    }
    while (isNoPForRotation && ++pRotation < range.size)
    return pRotation
}

private fun isNotDeleteP(p: Int):Boolean {
    return p != -1
}

private fun deleteP(range: IntArray, i: Int) {
    range[i] = -1
}