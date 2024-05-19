package siver

import java.io.StreamTokenizer

@Suppress("unused")
private fun baekjun2447 (){
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    StreamTokenizer(br).apply {
        fun getInt(): Int {
            nextToken()
            return nval.toInt()
        }


        val num= getInt()
        val arr = Array(num){CharArray(num){'*'} }
        // (0,0,27)
        fun star(x:Int, y:Int,size:Int){
            if(size<3)
                return
            val mid = size / 3
            for(row in 0..<mid)
                for(col in 0..<mid)
                    arr[x+mid+row][y+mid+col]=' '

            star(x,y,mid)
            star(x,y+mid,mid)
            star(x,y+mid*2,mid)

            star(x+mid,y,mid)
            //star(x+mid,y+mid,mid)
            star(x+mid,y+mid*2,mid)

            star(x+mid*2,y,mid)
            star(x+mid*2,y+mid,mid)
            star(x+mid*2,y+mid*2,mid)
        }

        star(0,0,num)

        for(col in arr) {
            bw.write(col)
            bw.write("\n")
        }

    }


    bw.flush()
}