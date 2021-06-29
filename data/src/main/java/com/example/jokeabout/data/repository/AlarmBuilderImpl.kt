package com.example.jokeabout.data.repository

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.jokeabout.data.receivers.JokeAboutReceiver
import com.example.jokeabout.domain.AlarmBuilder
import javax.inject.Inject
private const val ACTION = "com.example.jokeabout.ALARM_SET_UP"

class AlarmBuilderImpl @Inject constructor(private val context: Context) : AlarmBuilder {

    override fun setAlarm(time: Long) {
        val startTime = System.currentTimeMillis()
        val alarmManager: AlarmManager =
            context.getSystemService(AppCompatActivity.ALARM_SERVICE) as AlarmManager
        val alarmIntent = Intent(context, JokeAboutReceiver::class.java)
        alarmIntent.action = ACTION
        val pendingIntent = PendingIntent.getBroadcast(context, 1, alarmIntent, 0)
        alarmManager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, startTime + time, pendingIntent)
        Log.d("ALARM", "start: ALARM STARTED")
    }
}