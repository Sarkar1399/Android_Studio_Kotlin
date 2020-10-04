fun main(){
    // Вызоваем задачку №1
    println(obj1.move())
    println(obj2.talk())
    // Вызоваем задачку №2
    println(studentobj.getScholarship())
    println(variableStudent.getScholarship())
    // Вызоваем задачку №3
    userObjekt1.login = "Sarkar"
    println("Login: " + userObjekt1.login)
    println("Password: " + userObjekt1.password)
}

// Задачка №1
class Person(val fullName: String = "Person", var age: Int = 25) {
    fun move(): String { return "Такой-то " + fullName + " " + age + " говорит" }
    fun talk(): String{ return "Такой-то " + fullName + " " + age + " говорит" }
}
//
val obj1 = Person()
val obj2 = Person("Juraev Sarkar Amirbekovich", 25)

// Задачка №2
open class Student{
    val firstName: String = "Jhon"
    val lastName: String = "Dep"
    val group: String = "Developer"
    val averageMark: Int = 5

    open fun getScholarship(): Int {
        if (averageMark == 5){
            return 100
        }else {
            return 80
        }
    }
}

class Aspirant: Student() {

    override fun getScholarship(): Int {
        if (averageMark == 5){
            return 200
        }else {
            return 180
        }
    }
}

val studentobj: Student = Student()

val aspirantObj: Aspirant = Aspirant()

val variableStudent: Student = aspirantObj

// Задачка №3
class Product{
    var name: String = ""
    var price: Int = 0
    var rating: Int = 0
    init {
        println("Name $name Price $price c Rating $rating")
    }
}

class Cotegory{
    val name = "Телефоны"
    val products: Array<String> = arrayOf("Samsung 10+", "iPhone X", "Huawei P20pro", "Xiaomi A2 Lite", "Nokia lumia")
}

val samsung10: Cotegory = Cotegory()
val iphonX: Cotegory = Cotegory()
val huawieP20pro: Cotegory = Cotegory()
val xiaomiA2Lite: Cotegory = Cotegory()
val nokiaLumia: Cotegory = Cotegory()

class Basket{
    val largeProduct: ArrayList<String> = ArrayList()
}

val basketObj1: Basket = Basket()

class User{
    var login: String = "Sarkar_4ik"
    var password: String = "Sarkar_4ik.tj"
    val userObj = basketObj1
}

val userObjekt1: User = User()