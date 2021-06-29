package com.example.jokeabout.di.modules.domain

import com.example.jokeabout.domain.AlarmBuilder
import com.example.jokeabout.domain.GetCredentialsUseCase
import com.example.jokeabout.domain.SaveCredentialsUseCase
import com.example.jokeabout.domain.UserRepository
import dagger.Module
import dagger.Provides

@Module
class DomainModule {

    @Provides
    fun provideSaveCredentialsUseCase(userRepository: UserRepository, alarmBuilder: AlarmBuilder): SaveCredentialsUseCase {
        return SaveCredentialsUseCase(userRepository, alarmBuilder)
    }

    @Provides
    fun provideGetCredentialsUseCase(userRepository: UserRepository): GetCredentialsUseCase {
        return GetCredentialsUseCase(userRepository)
    }

    @Provides
    fun provideParams(getCreds: GetCredentialsUseCase): HashMap<String?, String?> {
        return getCreds.execute()
    }
}