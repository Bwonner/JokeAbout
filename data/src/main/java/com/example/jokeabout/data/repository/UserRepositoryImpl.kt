package com.example.jokeabout.data.repository

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import com.example.jokeabout.domain.UserRepository
import com.example.jokeabout.domain.model.UserParams
import javax.inject.Inject
private const val PREFS_TAG = "SharedPreferences"

class UserRepositoryImpl @Inject constructor(private val context: Context) : UserRepository {
    private val nameKey = "name"
    private val lastNameKey = "lastName"
    private val timeKey = "time"
    private val defaultData = "empty"

    lateinit var prefs: SharedPreferences
    lateinit var editor: SharedPreferences.Editor

    override fun save(params: UserParams) {
        prefs = context.getSharedPreferences(PREFS_TAG, MODE_PRIVATE)
        editor = prefs.edit()
        editor.putString(nameKey, params.name)
        editor.putString(lastNameKey, params.lastName)
        editor.putString(timeKey, params.time.toString())
        editor.apply()
    }

    override fun get(): HashMap<String?, String?> {
        return mapOf<String?, String?>(
            nameKey to getValue(nameKey),
            lastNameKey to getValue(lastNameKey),
            timeKey to getValue(timeKey)
            ) as HashMap<String?, String?>
    }

    override fun getName(): String? {
        prefs = context.getSharedPreferences(PREFS_TAG, MODE_PRIVATE)
        return prefs.getString(nameKey, defaultData)
    }

    override fun getLastName(): String? {
        prefs = context.getSharedPreferences(PREFS_TAG, MODE_PRIVATE)
        return prefs.getString(lastNameKey, defaultData)
    }

    private fun getValue(key: String): String? {
        prefs = context.getSharedPreferences(PREFS_TAG, MODE_PRIVATE)
        return prefs.getString(key, defaultData)
    }
}