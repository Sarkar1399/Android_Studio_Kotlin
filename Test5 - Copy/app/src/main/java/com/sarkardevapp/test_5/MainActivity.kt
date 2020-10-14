package com.sarkardevapp.test_5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bannerTimer()
    }

    private fun bannerTimer(): CountDownTimer {

        var banner = findViewById<ImageView>(R.id.imgSlider)
        var photoId = 1
        val bannerTimer = object : CountDownTimer(16000, 4000) {
            override fun onTick(millisUntilFinished: Long) {
                val drawableResource =when(photoId) {
                    1 -> R.drawable.ic_kotlin
                    2 -> R.drawable.ic_java
                    3 -> R.drawable.ic_csharp
                    4 -> R.drawable.ic_python
                    else -> R.drawable.ic_kotlin
                }
                photoId++
                if(banner !== null) {
                    banner.setImageResource(drawableResource)
                } else {
                    banner = findViewById<ImageView>(R.id.imgSlider)
                }
            }

            override fun onFinish() {
                photoId = 1
                this.start()
            }
        }
        bannerTimer.start()
        return bannerTimer
    }

    fun onClickNewTestJava(view: View) {}
}