package siver

import java.io.StreamTokenizer
import java.util.*

private fun baekjun1260() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    StreamTokenizer(br).apply {
        fun getInt(): Int {
            nextToken()
            return nval.toInt()
        }

        val n = getInt() // ~1000 정점의 개수
        val m = getInt() // ~10000 간선의 개수
        val v = getInt() // ~n 시작번호

        val links = Array<MutableList<Int>>(n + 1) { mutableListOf() }
        val visit = BooleanArray(n + 1)

        repeat(m) {
            val a = getInt()
            val b = getInt()
            links[a].add(b)
            links[b].add(a)
        }

        for (idx in links.indices) {
            links[idx].sort()
        }

        //dfs
        fun dfs(next: Int) {
            visit[next] = true
            bw.write("$next ")
            links[next].forEach {
                if (!visit[it]) {
                    dfs(it)
                }
            }
        }

        //bfs
        fun bfs(next: Int) {
            val jobs: Queue<Pair<Int, MutableList<Int>>> = LinkedList<Pair<Int, MutableList<Int>>>()
                .apply { push(Pair(next, links[next])) }
            var visitCount = 0
            while (true) {
                val subJob = jobs.poll() ?: break
                if(!visit[subJob.first])
                    continue
                visit[subJob.first] = false // 배열을 그대로 쓰기위해 반대로
                visitCount++

                bw.write("${subJob.first} ")

                for (toNode in subJob.second) {
                    if (visit[toNode])// 배열을 그대로 쓰기위해 반대로
                        jobs.add(Pair(toNode, links[toNode]))
                }
            }
        }


        dfs(v)
        bw.write("\n")
        bfs(v)
    }

    bw.flush()
}