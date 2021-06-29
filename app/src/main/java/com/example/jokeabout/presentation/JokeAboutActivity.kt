package com.example.jokeabout.presentation

import android.os.Bundle
import com.example.jokeabout.R
import com.example.jokeabout.databinding.ActivityJokeAboutBinding
import com.example.jokeabout.domain.SaveCredentialsUseCase
import com.example.jokeabout.domain.model.UserParams
import dagger.android.DaggerActivity
import javax.inject.Inject

private const val TIME_30_SEC: Long = 30000
private const val TIME_1_MIN: Long = 60000
private const val TIME_1_HOUR: Long = 3600000

class JokeAboutActivity : DaggerActivity() {
    private lateinit var binding: ActivityJokeAboutBinding
    @Inject lateinit var saveCreds: SaveCredentialsUseCase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_joke_about)

        binding = ActivityJokeAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonMainSave.setOnClickListener {
            saveCreds.execute(UserParams(
                name = binding.editTextMainFirstName.text.toString(),
                lastName = binding.editTextMainLastName.text.toString(),
                time = getAlarmTime()))
        }
    }

    private fun getAlarmTime(): Long {
        var time: Long = 0
        if (binding.radioButtonMain1Hour.isChecked) {
            time = TIME_1_HOUR
        }
        if (binding.radioButtonMain1Min.isChecked) {
            time = TIME_1_MIN
        }
        if (binding.radioButtonMain30Sec.isChecked) {
            time = TIME_30_SEC
        }
        return time
    }
}