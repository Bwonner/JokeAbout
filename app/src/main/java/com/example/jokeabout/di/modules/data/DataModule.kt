package com.example.jokeabout.di.modules.data

import android.content.Context
import com.example.jokeabout.data.JSONParser
import com.example.jokeabout.data.NotificationBuilder
import com.example.jokeabout.data.network.HttpClient
import com.example.jokeabout.data.repository.AlarmBuilderImpl
import com.example.jokeabout.data.worker.JokeAboutWorkerSetUp
import com.example.jokeabout.domain.AlarmBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient

@Module
class DataModule {
    private val baseUrl = com.example.jokeabout.BuildConfig.BASE_URL

    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient()
    }

    @Provides
    fun provideHttpClient(client: OkHttpClient): HttpClient {
        return HttpClient(baseUrl = baseUrl, client = client)
    }

    @Provides
    fun provideParser(): JSONParser {
        return JSONParser()
    }

    @Provides
    fun provideNotificationBuilder(context: Context): NotificationBuilder {
        return NotificationBuilder(context)
    }

    @Provides
    fun provideWorkManager(context: Context): JokeAboutWorkerSetUp {
        return JokeAboutWorkerSetUp(context)
    }

    @Provides
    fun provideAlarmBuilder(context: Context): AlarmBuilder {
        return AlarmBuilderImpl(context)
    }
}