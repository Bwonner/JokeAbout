package com.example.jokeabout.data.worker

import android.content.Context
import androidx.work.ListenableWorker
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.example.jokeabout.data.NotificationBuilder
import com.example.jokeabout.data.network.JokeApiImpl
import com.example.jokeabout.domain.UserRepository
import javax.inject.Inject

class JokeAboutWorker(
    context: Context, workerParams: WorkerParameters, private val jokeApi: JokeApiImpl,
    private val notification: NotificationBuilder, private val userRepository: UserRepository
) : Worker(
    context,
    workerParams
) {

    override fun doWork(): Result {
        return try {
            val joke = jokeApi.getJokeByName(userRepository.getName(), userRepository.getLastName())
            notification.showJoke(joke = joke.joke)
            Result.success()
        } catch (e: Exception) {
            Result.retry()
        }
    }

    class Creator @Inject constructor(
        private val jokeApi: JokeApiImpl, private val notification: NotificationBuilder,
        private val userRepository: UserRepository
    ) :
        WorkerCreator {

        override fun create(appContext: Context, workerParameters: WorkerParameters): ListenableWorker {
            return JokeAboutWorker(
                context = appContext, workerParams = workerParameters, jokeApi = jokeApi, notification = notification,
                userRepository = userRepository
            )
        }
    }
}

