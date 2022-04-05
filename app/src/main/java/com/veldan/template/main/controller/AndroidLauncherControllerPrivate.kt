package com.veldan.template.main.controller

import androidx.navigation.findNavController
import com.veldan.template.R
import com.veldan.template.databinding.ActivityMainBinding
import com.veldan.template.main.AndroidLauncher

class AndroidLauncherControllerPrivate(val activity: AndroidLauncher) {

    fun initialize() {
        with(activity) {
            binding = ActivityMainBinding.inflate(layoutInflater)
            setContentView(binding.root)
            navController = findNavController(R.id.nav_host_fragment)
        }
    }

}