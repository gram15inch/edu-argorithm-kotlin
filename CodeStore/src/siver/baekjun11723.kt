package siver

import java.io.StreamTokenizer
@Suppress("unused")
private fun baekjun11723(){
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    StreamTokenizer(br).apply {
        fun getInt(): Int {
            nextToken()
            return nval.toInt()
        }


        fun getString(): String {
            nextToken()
            return sval
        }

        val m = getInt()
        val zip = hashSetOf<Int>()

        repeat(m){
            val cmd = getString()
            when(cmd){
                "check"-> {
                    getInt().run {
                        bw.write("${if(zip.contains(this))1 else 0}\n")
                    }
                }
                "add"-> {
                    getInt().run {
                        zip.add(this)
                    }
                }
                "remove"-> {
                    getInt().run {
                        zip.remove(this)
                    }
                }
                "toggle"-> {
                    getInt().run {
                        if (zip.contains(this))
                            zip.remove(this)
                        else
                            zip.add(this)
                    }
                }
                "all"-> {
                    zip.addAll(1..20)
                }
                "empty"-> {
                    zip.clear()
                }
            }
        }
    }

    bw.flush()
}