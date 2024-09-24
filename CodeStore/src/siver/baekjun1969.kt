package siver

import java.io.StreamTokenizer

private fun baekjun1969() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    StreamTokenizer(br).apply {
        fun getInt(): Int {
            nextToken()
            return nval.toInt()
        }

        val n = getInt() // ~1000
        val m = getInt() // ~50
        val arr = Array<CharArray>(n) { br.readLine().toCharArray() }
        val result = CharArray(m)
        var diffCount = 0
        for (char in 0..<m) {
            val map = mutableMapOf<Char, Int>()
            for (row in 0..<n) {
                if (map[arr[row][char]] == null) map[arr[row][char]] = 1
                else map[arr[row][char]] = map[arr[row][char]]!! + 1
            }
            val max = map.maxBy { it.value }
            map.apply {
                val it= this.iterator()
                while (it.hasNext()){
                    val item= it.next()
                    if(item.key!=max.key)
                        diffCount+=item.value
                }
            }.filter { it.value == max.value }
                .minBy { it.key }
                .apply {
                    result[char] = this.key
                }
        }
        bw.write(result)
        bw.write("\n$diffCount")
    }

    bw.flush()
}