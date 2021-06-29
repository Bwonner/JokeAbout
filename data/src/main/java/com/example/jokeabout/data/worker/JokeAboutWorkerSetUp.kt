package com.example.jokeabout.data.worker

import android.content.Context
import androidx.work.*
import javax.inject.Inject

class JokeAboutWorkerSetUp @Inject constructor(val context: Context) {

    private fun setUpConstraints(): Constraints {
        return Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build()
    }

    private fun getWorkRequest(): WorkRequest {
        return OneTimeWorkRequestBuilder<JokeAboutWorker>()
            .setConstraints(setUpConstraints())
            .build()
    }

    fun doWorkRequest() {
        WorkManager.getInstance(context).enqueue(getWorkRequest())
    }
}