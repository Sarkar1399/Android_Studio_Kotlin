package com.sarkardeveloper.ittest

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.view.MenuItem
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.sarkardeveloper.test_5.R
import com.sarkardeveloper.test_5.databinding.ActivityMainBinding
import kotlin.system.exitProcess

@Suppress("UNREACHABLE_CODE")
class MainActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_nav)

        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        drawerLayout = binding.drawerLayout

        val navController = this.findNavController(R.id.myNavFragment)

        NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout)

        NavigationUI.setupWithNavController(binding.navView, navController)

        sliderTimer()
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.myNavFragment)
        return NavigationUI.navigateUp(navController, drawerLayout)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.exit -> {
                exitToApp()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun exitToApp() {
        exitProcess(-1)
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