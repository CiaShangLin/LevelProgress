package com.shang.LevelProgress

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import java.util.*

class MainActivity : AppCompatActivity() {

    private var mLevel = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val levelProgress = findViewById<LevelProgress>(R.id.LevelProgress)
        val downloadProgress = findViewById<DownloadProgress>(R.id.downloadProgress)
        val button = findViewById<Button>(R.id.button)
        val btDownload = findViewById<Button>(R.id.btDownload)

        button.setOnClickListener {
            mLevel++
            mLevel %= 7
            levelProgress.setLevel(mLevel)
        }

        btDownload.setOnClickListener {
            var progress = -1
            val timer = Timer()
            timer.schedule(object : TimerTask() {
                override fun run() {
                    when {
                        progress < 0 -> {
                            downloadProgress.setState(DownloadProgress.State.Pause)
                        }
                        progress in 0..100 -> {
                            downloadProgress.setState(DownloadProgress.State.Progress(progress))
                        }
                        progress > 100 -> {
                            downloadProgress.setState(DownloadProgress.State.Success)
                            timer.cancel()
                        }
                    }
                    progress++
                }
            }, 500,50)

        }
    }
}