package com.example.jokeabout.domain

import com.example.jokeabout.domain.model.UserParams

class SaveCredentialsUseCase(private val userRepo: UserRepository, private val alarm: AlarmBuilder) {

    fun execute(params: UserParams) {
        userRepo.save(params)
        alarm.setAlarm(params.time)
    }
}