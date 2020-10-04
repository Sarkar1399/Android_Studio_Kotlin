package com.example.myclass


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Articles {
    val myArticles: Array<String> = arrayOf("'Think before you speak. Read before you think.' - Fran Lebowitz", "'Learning is a treasure that will follow its owner everywhere.' - Chinese Proverb",
        "'You can never understand one language until you understand at least two.' - Geoffrey Willans", "'Language is the road map of a culture. It tells you where its people come from and where they are going.' - Rita Mae Brown",
        "'I attribute my success to this: I never gave or took any excuse.' - Florence Nightingale", "'The best time to plant a tree was 20 years ago. The second best time is now.' - Chinese proverb",
        "'When I let go of what I am, I become what I might be.' - Lao Tzu", "'I am not a product of my circumstances. I am a product of my decisions.' - Stephen Covey",
        "'Your time is limited, so don't waste it living someone else's life.' - Steve Jobs", "'Everything you've ever wanted is on the other side of fear.' - George Addair")
    fun randArticle(){
        val random = myArticles.random()
        println(random)
    }
}

val qouta: Articles = Articles()

fun main(){
    qouta.randArticle()
}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
// TODO Создать Kotlin класс со свойством articles (текстовый массив),
//TODO и методом randomArticle, который будет возвращать произвольную статью из articles.
