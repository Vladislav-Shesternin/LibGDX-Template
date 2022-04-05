package com.veldan.template

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.badlogic.gdx.backends.android.AndroidFragmentApplication
import com.veldan.template.databinding.ActivityMainBinding
import com.veldan.template.utils.log
import kotlin.system.exitProcess

class AndroidLauncher : FragmentActivity(), AndroidFragmentApplication.Callbacks {

    companion object {
        private lateinit var binding: ActivityMainBinding
    }

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