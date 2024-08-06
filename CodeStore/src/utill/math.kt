package utill

//최대 공약수
private fun gcd(a:Int, b:Int):Int{
    (a % b).apply {
        return when{
            this == 0-> b
            else-> gcd(b, this)
        }
    }
}

//최소 공배수
private fun lcm(a:Int, b:Int):Int{
    return a*b / gcd(a,b)
}
