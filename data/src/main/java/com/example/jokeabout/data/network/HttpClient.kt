package com.example.jokeabout.data.network

import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONObject
import javax.inject.Inject

class HttpClient @Inject constructor(
    private var baseUrl: String,
    private val client: OkHttpClient
) {

    fun getJSONObject(params: HashMap<String?, String?>): JSONObject {
        val response = client.newCall(getHttpRequest(params)).execute()
        return JSONObject(response.body!!.string())
    }

    private fun getHttpRequest(params: HashMap<String?, String?>): Request {
        params.forEach { (k, v) -> baseUrl += "$k=&$v" }
        return Request.Builder()
            .url(baseUrl)
            .build()
    }
}