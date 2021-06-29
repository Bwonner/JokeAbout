package com.example.jokeabout.data

import org.json.JSONObject

class JSONParser {
    private val objName = "value"
    private val strName = "joke"

    fun parse(jsonObject: JSONObject): String {
        return jsonObject.getJSONObject(objName).getString(strName)
    }
}