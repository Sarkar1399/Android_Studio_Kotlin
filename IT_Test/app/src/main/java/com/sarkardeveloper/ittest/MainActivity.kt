package com.sarkardeveloper.ittest

import android.os.Bundle
import android.os.CountDownTimer
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.sarkardeveloper.test_5.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sliderTimer()
    }

    private fun sliderTimer(): CountDownTimer {

        var imageSlider = findViewById<ImageView>(R.id.imgSlider)
        var imageId = 1
        val sliderTimer = object : CountDownTimer(16000, 4000) {
            override fun onTick(millisUntilFinished: Long) {
                val drawableResource = when(imageId) {
                    1 -> R.drawable.ic_cpp
                    2 -> R.drawable.ic_java
                    3 -> R.drawable.ic_csharp
                    4 -> R.drawable.ic_python
                    else -> R.drawable.ic_cpp
                }
                imageId++
                if(imageSlider !== null) {
                    imageSlider.setImageResource(drawableResource)
                } else {
                    imageSlider = findViewById<ImageView>(R.id.imgSlider)
                }
            }

            override fun onFinish() {
                imageId = 1
                this.start()
            }
        }
        sliderTimer.start()
        return sliderTimer
    }

}