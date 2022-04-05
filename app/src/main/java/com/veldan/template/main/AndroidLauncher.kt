package com.veldan.template.main

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.badlogic.gdx.backends.android.AndroidFragmentApplication
import com.veldan.template.R
import com.veldan.template.databinding.ActivityMainBinding
import com.veldan.template.main.controller.AndroidLauncherControllerPrivate
import com.veldan.template.main.controller.AndroidLauncherControllerPublic
import kotlin.system.exitProcess

class AndroidLauncher : FragmentActivity(), AndroidFragmentApplication.Callbacks {

    // Для управления AndroidLauncher
    // Хранит логику AndroidLauncher
    private val privateController by lazy { AndroidLauncherControllerPrivate(this) }

    // Для публичного управления AndroidLauncher
    // Хранит публичную логику AndroidLauncher
    val publicController by lazy { AndroidLauncherControllerPublic(this) }

    lateinit var binding      : ActivityMainBinding
    lateinit var navController: NavController



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setTheme(R.style.Theme_Template)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        navController = findNavController(R.id.nav_host_fragment)
    }

    override fun exit() {
        finish()
        exitProcess(0)
    }

}