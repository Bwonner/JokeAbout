package com.example.jokeabout.data.worker

import android.content.Context
import androidx.work.ListenableWorker
import androidx.work.WorkerParameters

interface WorkerCreator {
    fun create(appContext: Context, workerParameters: WorkerParameters): ListenableWorker
}