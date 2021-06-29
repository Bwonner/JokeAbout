package com.example.jokeabout.di.modules

import com.example.jokeabout.di.modules.domain.DomainModule
import com.example.jokeabout.presentation.JokeAboutActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector(modules = [DomainModule::class])
    abstract fun contributeJokeAboutActivity(): JokeAboutActivity
}