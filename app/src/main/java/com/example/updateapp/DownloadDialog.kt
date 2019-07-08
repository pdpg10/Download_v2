package com.example.updateapp

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ProgressBar
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager

class DownloadDialog : DialogFragment() {
    private var pb: ProgressBar? = null

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val v = LayoutInflater.from(context).inflate(R.layout.dialog_download, null, false)
        pb = v as ProgressBar
        return AlertDialog.Builder(context!!)
            .setTitle("Downloading...")
            .setView(v)
            .setCancelable(false)
            .create()
    }

    override fun show(manager: FragmentManager?, tag: String?) {
        super.show(manager, tag)
        MyThread().start()

    }

    inner class MyThread : Thread() {
        private val downloadManager = DownloadManager()

        override fun run() {
            super.run()
            downloadManager.downloadWithOutProgress()
            dismiss()
        }
    }
}