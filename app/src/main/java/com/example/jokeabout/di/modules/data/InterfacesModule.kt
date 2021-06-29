package com.example.jokeabout.di.modules.data

import com.example.jokeabout.data.network.JokeApi
import com.example.jokeabout.data.network.JokeApiImpl
import com.example.jokeabout.data.repository.UserRepositoryImpl
import com.example.jokeabout.data.worker.JokeAboutWorker
import com.example.jokeabout.data.worker.WorkerCreator
import com.example.jokeabout.domain.UserRepository
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class InterfacesModule {

    @Binds
    abstract fun bindJokeApi(jokeApi: JokeApiImpl): JokeApi

    @Binds
    abstract fun bindUserRepository(userRepo: UserRepositoryImpl): UserRepository

    @Binds
    @IntoMap
    @WorkerKey(JokeAboutWorker::class)
    abstract fun bindJokeAboutWorker(creator: JokeAboutWorker.Creator): WorkerCreator
}