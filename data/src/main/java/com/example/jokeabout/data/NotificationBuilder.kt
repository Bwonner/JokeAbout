package com.example.jokeabout.data

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.core.app.NotificationCompat
import javax.inject.Inject

class NotificationBuilder @Inject constructor(private val context: Context) {
    private val channelID: String = "Notification Channel"
    private val channelName: String = "Catch a joke"
    private val manager: NotificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

    fun showJoke(joke: String) {
        createNotificationChannel()
        val notification = NotificationCompat.Builder(context, channelID)
            //.setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle(channelName)
            .setContentText(joke)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .build()

        manager.notify(1, notification)
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val jokeChannel = NotificationChannel(
                channelID,
                channelName,
                NotificationManager.IMPORTANCE_DEFAULT
            )

            manager.createNotificationChannel(jokeChannel)
        }
    }
}