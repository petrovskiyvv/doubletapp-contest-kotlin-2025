package com.example.doubletappcontestactivity.ui

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import FileLogger
import android.os.Build
import androidx.annotation.RequiresApi
import com.example.doubletappcontestactivity.R

class SecondActivity : AppCompatActivity() {
    private var squareValue: Int = 0

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        FileLogger.log(this, "com.example.doubletappcontestactivity.ui.SecondActivity: onCreate")

        val number = intent.getIntExtra("NUMBER", 0)
        squareValue = number * number

        if (savedInstanceState != null) {
            squareValue = savedInstanceState.getInt("SQUARE", squareValue)
        }

        findViewById<TextView>(R.id.tv_square).text = squareValue.toString()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("SQUARE", squareValue)
        FileLogger.log(this, "com.example.doubletappcontestactivity.ui.SecondActivity: onSaveInstanceState")
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        squareValue = savedInstanceState.getInt("SQUARE")
        findViewById<TextView>(R.id.tv_square).text = squareValue.toString()
        FileLogger.log(this, "com.example.doubletappcontestactivity.ui.SecondActivity: onRestoreInstanceState")
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onStart() {
        super.onStart()
        FileLogger.log(this, "com.example.doubletappcontestactivity.ui.SecondActivity: onStart")
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onResume() {
        super.onResume()
        FileLogger.log(this, "com.example.doubletappcontestactivity.ui.SecondActivity: onResume")
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onPause() {
        super.onPause()
        FileLogger.log(this, "com.example.doubletappcontestactivity.ui.SecondActivity: onPause")
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onStop() {
        super.onStop()
        FileLogger.log(this, "com.example.doubletappcontestactivity.ui.SecondActivity: onStop")
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onDestroy() {
        super.onDestroy()
        FileLogger.log(this, "com.example.doubletappcontestactivity.ui.SecondActivity: onDestroy")
    }
}