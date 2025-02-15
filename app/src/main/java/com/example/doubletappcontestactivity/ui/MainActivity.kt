package com.example.doubletappcontestactivity.ui

import MainViewModel
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.doubletappcontestactivity.R
import java.io.File
import java.io.IOException

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        logLifecycle("com.example.doubletappcontestactivity.ui.MainActivity: onCreate")

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        if (savedInstanceState == null) {
            viewModel.counter = 0
        } else {
            viewModel.counter++
        }

        updateCounterDisplay()

        findViewById<Button>(R.id.btn_open_second).setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java).apply {
                putExtra("NUMBER", viewModel.counter)
            }
            startActivity(intent)
        }
    }

    private fun updateCounterDisplay() {
        findViewById<TextView>(R.id.tv_counter).text = viewModel.counter.toString()
    }

    override fun onStart() {
        super.onStart()
        logLifecycle("com.example.doubletappcontestactivity.ui.MainActivity: onStart")
    }

    override fun onResume() {
        super.onResume()
        logLifecycle("com.example.doubletappcontestactivity.ui.MainActivity: onResume")
    }

    override fun onPause() {
        super.onPause()
        logLifecycle("com.example.doubletappcontestactivity.ui.MainActivity: onPause")
    }

    override fun onStop() {
        super.onStop()
        logLifecycle("com.example.doubletappcontestactivity.ui.MainActivity: onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        logLifecycle("com.example.doubletappcontestactivity.ui.MainActivity: onDestroy")
    }

    private fun logLifecycle(message: String) {
        try {
            val logFile = File(filesDir, "activity_lifecycle.log")
            logFile.appendText("$message\n")
        } catch (e: IOException) {
            Log.e("LifecycleLog", "Error writing to log file", e)
        }
    }
}