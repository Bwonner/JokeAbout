package com.example.jokeabout.data.network

import com.example.jokeabout.data.JSONParser
import com.example.jokeabout.data.model.Joke
import javax.inject.Inject

private const val FIRST_NAME_KEY = "firstName"
private const val LAST_NAME_KEY = "lastName"

class JokeApiImpl @Inject constructor (
    private val client: HttpClient,
    private val parser: JSONParser
) : JokeApi {

    override fun getJokeByName(firstName: String?, lastName: String?): Joke {
        val params: HashMap<String?, String?> = hashMapOf(FIRST_NAME_KEY to firstName, LAST_NAME_KEY to lastName)
        val json = client.getJSONObject(params)
        return Joke(joke = parser.parse(json))
    }
}


