package com.shang.LevelProgress

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private var mLevel = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val levelProgress = findViewById<LevelProgress>(R.id.LevelProgress)
        val button = findViewById<Button>(R.id.button)

        button.setOnClickListener {
            mLevel++
            mLevel %= 7
            levelProgress.setLevel(mLevel)
        }

    }
}