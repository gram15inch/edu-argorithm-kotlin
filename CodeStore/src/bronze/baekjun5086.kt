package bronze

fun baekjun5086(input:String):String{
    val items= input.split(" ")
    val a = items[0].toInt()
    val b = items[1].toInt()

    return when{
        b % a ==0 -> "factor"
        a % b ==0 -> "multiple"
        else-> "neither"
    }
}



