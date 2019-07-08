package com.example.updateapp

class DownloadManager {
    fun downloadWithOutProgress() {
        repeat(10) {
            Thread.sleep(1000)
        }
    }

//    fun downloadWithProgress() {
//        (0..30).forEach {
//            Thread.sleep(1000)
//        }
//    }
}