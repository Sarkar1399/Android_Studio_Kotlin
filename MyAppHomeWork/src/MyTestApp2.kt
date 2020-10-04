fun main(arg:Array<String>){
    val appleKg = 20
    for (i in 1..10){
        var weight = i*0.1
        var result = weight*appleKg
        println("Цена за $weight = $result")
    }
}
