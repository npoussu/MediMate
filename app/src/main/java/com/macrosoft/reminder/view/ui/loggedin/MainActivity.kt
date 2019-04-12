package com.macrosoft.reminder.view.ui.loggedin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.macrosoft.reminder.R

class MainActivity : AppCompatActivity() {

    private val TAG = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
