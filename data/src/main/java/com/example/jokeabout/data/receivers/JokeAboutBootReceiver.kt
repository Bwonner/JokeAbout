package com.example.jokeabout.data.receivers

import android.content.Context
import android.content.Intent
import android.util.Log
import com.example.jokeabout.data.repository.AlarmBuilderImpl
import com.example.jokeabout.data.worker.JokeAboutWorkerSetUp
import com.example.jokeabout.domain.UserRepository
import dagger.android.DaggerBroadcastReceiver
import javax.inject.Inject

class JokeAboutBootReceiver : DaggerBroadcastReceiver() {
    @Inject lateinit var alarmImpl: AlarmBuilderImpl
    @Inject lateinit var workerSetUp: JokeAboutWorkerSetUp
    @Inject lateinit var userRepo: UserRepository

    override fun onReceive(context: Context, intent: Intent) {
        super.onReceive(context, intent)
        if (Intent.ACTION_BOOT_COMPLETED == intent.action) {
            Log.d("BROADCAST_BOOT_RECEIVER", "MESSAGE AFTER BOOT RECEIVED")

            workerSetUp.doWorkRequest()
            alarmImpl.setAlarm(time = userRepo.get()["time"]!!.toLong())
            Log.d("BROADCAST_BOOT_RECEIVER", "onReceive: ALARM STARTED FROM WORKER")
        }
    }
}