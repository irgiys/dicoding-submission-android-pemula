package com.irgiys.leaguechampions

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {
    @Suppress("Deprecation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        val r = Runnable {
            startActivity(Intent(this@SplashActivity, MainActivity::class.java))
            finish()
        }
        Handler().postDelayed(r, 1500)
    }
}