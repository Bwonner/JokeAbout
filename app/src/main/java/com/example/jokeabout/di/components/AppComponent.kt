package com.example.jokeabout.di.components

import android.content.Context
import com.example.jokeabout.di.modules.ActivityBuilderModule
import com.example.jokeabout.di.modules.data.DataModule
import com.example.jokeabout.di.modules.data.InterfacesModule
import com.example.jokeabout.di.modules.data.ReceiversBuilderModule
import com.example.jokeabout.di.modules.domain.DomainModule
import com.example.jokeabout.presentation.App
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AndroidSupportInjectionModule::class, ActivityBuilderModule::class, ReceiversBuilderModule::class,
        DataModule::class, InterfacesModule::class, DomainModule::class]
)
interface AppComponent : AndroidInjector<App> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun applicationContext(context: Context): Builder

        fun build(): AppComponent
    }
}