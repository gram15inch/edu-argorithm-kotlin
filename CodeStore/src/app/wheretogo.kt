package app

private fun getLatlngFormUrl(){
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    var str= ""

    val list = mutableListOf<String>()
    while (str!="q") {
        str=br.readLine()
        val regex = Regex("\\b\\d+\\.\\d+, \\d+\\.\\d+\\b")
        list.addAll(regex.findAll(str).map { it.value }.toList())
    }

    val sb = StringBuilder()
    for (str in list) {
        sb.appendLine("LatLng.from($str),")
    }
    bw.write(sb.toString())
    bw.flush()
}