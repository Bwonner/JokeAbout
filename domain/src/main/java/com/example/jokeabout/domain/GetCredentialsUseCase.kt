package com.example.jokeabout.domain

class GetCredentialsUseCase(private val userRepo: UserRepository) {

    fun execute(): HashMap<String?, String?> {
        return userRepo.get()
    }
}