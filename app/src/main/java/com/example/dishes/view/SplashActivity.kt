package com.example.dishes.view

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowInsets
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.example.dishes.R
import com.example.dishes.databinding.ActivitySplashBinding
import com.example.dishes.view.activities.MainActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val splashBinding:ActivitySplashBinding=ActivitySplashBinding.inflate(layoutInflater)
        setContentView(splashBinding.root)
        //splashBinding.tvAppName.text="Hello world"

        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.R){
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        }else{
            @Suppress("DEPRECATION")
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
            )
        }
        val splashAnimation=AnimationUtils.loadAnimation(this, R.anim.anim_splash)
        splashBinding.tvAppName.animation=splashAnimation
        splashAnimation.setAnimationListener(object :Animation.AnimationListener{
            override fun onAnimationEnd(animation: Animation?) {
                Handler(Looper.getMainLooper()).postDelayed({
                    startActivity(Intent(this@SplashActivity, MainActivity::class.java))
                    finish()
                },1000)
            }

            override fun onAnimationRepeat(animation: Animation?) {

            }

            override fun onAnimationStart(animation: Animation?) {

            }
        })

    }
}