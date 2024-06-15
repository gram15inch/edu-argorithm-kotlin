import java.io.StreamTokenizer


fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    StreamTokenizer(br).apply {
        fun getInt(): Int {
            nextToken()
            return nval.toInt()
        }

        val n = getInt()
        val chess = Array(n) {
            BooleanArray(n){true}
        }
        var count =0

        fun check(x:Int,y:Int,code:Int) {
            if (x > n - 1 || y > n - 1 || x < 0 || y < 0)
                return
            if (chess[y][x])
                chess[y][x] = false
            when (code) {
                0 -> check(x + 1, y, 0)
                1 -> check(x - 1, y, 1)
                2 -> check(x, y + 1, 2)
                3 -> check(x, y - 1, 3)
                4 -> check(x + 1, y + 1, 4)
                5 -> check(x + 1, y - 1, 5)
                6 -> check(x - 1, y - 1, 6)
                7 -> check(x - 1, y + 1, 7)
            }
        }
    //todo 다시돌아올떄 그전에 변경사항 되돌릴지?
        fun dfs(k:Int,x:Int,y:Int){
            if(k>n-1)
                return
            if(k==n) {
                count++
                return
            }
            for (code in 0..7)
                check(x,y,code)

            for(x in 0..<n)
                for(y in 0..<n){
                    if(chess[x][y]) {
                        chess[x][y] = false
                        dfs(k+1,x,y)
                        chess[x][y] = true
                    }
                }
        }
        dfs(0,0,0)
        bw.write(count.toString())

    }

    bw.flush()

}



