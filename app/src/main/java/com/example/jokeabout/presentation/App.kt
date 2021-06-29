package com.example.jokeabout.presentation

import androidx.work.Configuration
import androidx.work.WorkManager
import com.example.jokeabout.data.worker.JokeAboutWorkerFactory
import com.example.jokeabout.di.components.AppComponent
import com.example.jokeabout.di.components.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class App : DaggerApplication() {
    @Inject
    lateinit var factory: JokeAboutWorkerFactory


    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().applicationContext(applicationContext).build()
    }

    override fun onCreate() {
        super.onCreate()
        configureWorkManager()
    }

    private fun configureWorkManager() {
        val config = Configuration.Builder()
            .setWorkerFactory(factory)
            .build()

        WorkManager.initialize(this, config)
    }
}