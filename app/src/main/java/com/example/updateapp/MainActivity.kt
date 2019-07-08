package com.example.updateapp

import android.os.AsyncTask
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {
    private var task: MyTask? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        pb.max = 100
        button_download.setOnClickListener { showProgress() }
        button_cancel.setOnClickListener { task?.cancel(true) }

    }

    private fun showProgress() {
        task = MyTask()
        task?.execute()

        //android-arsenal.com
        //cancellation
    }

    inner class MyTask() : AsyncTask<Long, Int, String>() {

        override fun onPreExecute() {
            super.onPreExecute()
            button_download.isEnabled = false
            button_cancel.isEnabled = true

        }

        override fun onCancelled() {
            super.onCancelled()
            pb.progress = 0
            button_download.isEnabled = true
            button_cancel.isEnabled = false
        }

        override fun doInBackground(vararg params: Long?): String {
            (0..100).forEach {
                Thread.sleep(100)
                publishProgress(it)
            }
            return ""
        }

        override fun onProgressUpdate(vararg values: Int?) {
            super.onProgressUpdate(*values)
            val progress = values[0]
            if (progress != null) {
                pb.progress = progress
            }
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            button_download.isEnabled = true
            button_cancel.isEnabled = false
        }

    }
}
