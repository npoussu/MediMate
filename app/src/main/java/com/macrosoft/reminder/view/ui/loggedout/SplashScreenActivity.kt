package com.macrosoft.reminder.view.ui.loggedout

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.macrosoft.reminder.R

class SplashScreenActivity : AppCompatActivity() {

    // TODO: Add functions to check if user is logged in, if yes, redirect to StartActivity, if no redirect to LoginFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        val intent = Intent(applicationContext, StartActivity::class.java)
        startActivity(intent)
        finish()
    }
}