import java.util.Scanner

fun main(arg:Array<String>){
    weekDay()
}

fun weekDay(){
    print("Enter a number week day: ")
    val day = Scanner(System.`in`)
    val wday = day.nextInt()
    when(wday){
        1 -> println("Панедельник")
        2 -> println("Вторник")
        3 -> println("Среда")
        4 -> println("Четверг")
        5 -> println("Пятница")
        6 -> println("Субта")
        7 -> println("Воскрисение")
    }
}
