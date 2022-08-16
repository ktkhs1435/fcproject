package com.example.fcproject

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class InstaSplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insta_splash)

        val sharedPreferences = getSharedPreferences("user_info", Context.MODE_PRIVATE)
        val token = sharedPreferences.getString("token","empty")
        when(token) {
            "empty" -> {
                startActivity(Intent(this,InstaLoginActivity::class.java))
            }
            else -> {
                startActivity(Intent(this,InstaMainActivity::class.java))
            }
        }

    }

}