package siver

import java.io.StreamTokenizer

private fun baekjun2606() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    StreamTokenizer(br).apply {
        fun getInt(): Int {
            nextToken()
            return nval.toInt()
        }

        val computer = getInt()
        val link = getInt()
        val graph = Array(computer+1){ mutableListOf<Int>()}
        val visit = BooleanArray(computer+1)

        repeat(link){
            val a = getInt()
            val b = getInt()
            graph[a].add(b)
            graph[b].add(a)
        }
        var count = 0
        fun dfs(start:Int){
            visit[start]=true
            for(neighbor in graph[start])
                if(!visit[neighbor]){
                    visit[neighbor] = true
                    count++
                    dfs(neighbor)
                }
        }

        dfs(1)
        bw.write("$count")
    }

    bw.flush()
}