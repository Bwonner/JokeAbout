package com.example.jokeabout.data.network

import com.example.jokeabout.data.model.Joke

interface JokeApi {
    fun getJokeByName(firstName: String?, lastName: String?): Joke
}