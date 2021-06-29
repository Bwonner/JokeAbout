package com.example.jokeabout.domain

import com.example.jokeabout.domain.model.UserParams

interface UserRepository {
    fun save(params: UserParams)
    fun get(): HashMap<String?, String?>
    fun getName(): String?
    fun getLastName(): String?
}