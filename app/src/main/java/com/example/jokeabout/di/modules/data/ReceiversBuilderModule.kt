package com.example.jokeabout.di.modules.data

import com.example.jokeabout.data.receivers.JokeAboutBootReceiver
import com.example.jokeabout.data.receivers.JokeAboutReceiver
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ReceiversBuilderModule {

    @ContributesAndroidInjector
    abstract fun contributeBroadcastReceiver(): JokeAboutReceiver

    @ContributesAndroidInjector
    abstract fun contributeBroadcastBootReceiver(): JokeAboutBootReceiver
}