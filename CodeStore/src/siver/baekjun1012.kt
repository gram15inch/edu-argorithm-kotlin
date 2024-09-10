package siver

import java.io.StreamTokenizer

private fun baekjun1012() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    StreamTokenizer(br).apply {
        fun getInt(): Int {
            nextToken()
            return nval.toInt()
        }

        fun Array<BooleanArray>.getFirstNotVisit(): Pair<Int, Int> {
            for (y in 0..<this.size)
                for (x in 0..<this[y].size)
                    if (this[y][x])
                        return Pair(x, y)
            return Pair(-1, -1)
        }

        fun Array<BooleanArray>.isExist(x: Int, y: Int): Boolean {
            if (y < 0 || y >= this.size || x < 0 || x >= this[y].size) {
                return false
            }
            return this[y][x]
        }

        fun Array<BooleanArray>.dfs(x: Int, y: Int) {
            if (y < 0 || y >= this.size || x < 0 || x >= this[y].size)
                return
            this[y][x] = false
            for (move in -1..1)
                if (this.isExist(x, y + move))
                    dfs(x, y + move)

            for (move in -1..1)
                if (this.isExist(x + move, y))
                    dfs(x + move, y)
        }

        val t = getInt()
        repeat(t) {
            val m = getInt() // ~50 가로
            val n = getInt() // ~50 세로
            val k = getInt() // ~2500 배추개수

            var min = 0 // 최소 배추 개수

            val visit = Array(n) { BooleanArray(m) }
            repeat(k) {
                getInt().apply {
                    visit[getInt()][this] = true
                }
            }

            while (true) {
                val pair = visit.getFirstNotVisit()
                if(pair.second!=-1){
                    min++
                    visit.dfs(pair.first, pair.second)
                } else{
                    break
                }
            }
            bw.write("$min\n")
        }
    }

    bw.flush()
}