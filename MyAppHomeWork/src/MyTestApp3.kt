fun main(args:Array<String>){
    val num = 10
    var sum = 1.0
    for (i in 1..num){
        val weight= (i*0.1)+1
        sum *= weight
        println(sum)
    }
}
