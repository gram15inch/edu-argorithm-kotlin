package siver

private fun baekjun1213() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val str= br.readLine().toCharArray()
    var left =0
    var right = str.size-1
    var temp =' '
    while (left<right){
        temp =' '
        if(str[left] != str[right]) {
            for (num in right - 1 downTo  left + 1) {
                if(str[left] == str[num]){
                    temp = str[right]
                    str[right]=str[num]
                    str[num]=temp
                    break
                }
            }
            if(temp==' ') {
                for (num in left + 1 .. right - 1) {
                    if(str[right] == str[num]){
                        temp = str[left]
                        str[left]=str[num]
                        str[num]=temp
                        break
                    }
                }
            }
            if(temp==' ') {
                bw.write("I'm Sorry Hansoo")
                bw.flush()
                return
            }
        }
        left++
        right--
    }

    if(str.size%2==0){
        val mid= str.size/2-1
        str.copyOfRange(0,mid+1).apply{
            this.sort()
            for(num in this.indices)
                str[num]=this[num]
        }
        str.copyOfRange(mid+1,str.size).apply(){
            this.sortDescending()
            for(num in this.indices)
                str[num+mid+1]=this[num]
        }
    }else{
        val mid= str.size/2
        str.copyOfRange(0,mid).apply{
            this.sort()
            for(num in this.indices)
                str[num]=this[num]
        }
        str.copyOfRange(mid+1,str.size).apply(){
            this.sortDescending()
            for(num in this.indices)
                str[num+mid+1]=this[num]
        }
    }
    bw.write(str)
    bw.flush()
}