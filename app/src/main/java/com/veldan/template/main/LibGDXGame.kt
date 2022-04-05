package com.veldan.template.main

import com.badlogic.gdx.assets.AssetManager
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.utils.ScreenUtils
import com.veldan.template.advanced.AdvancedGame
import com.veldan.template.manager.NavigationManager
import com.veldan.template.screens.test.TestScreen

lateinit var game: LibGDXGame private set

class LibGDXGame(val activity: AndroidLauncher) : AdvancedGame() {

    private val color = Color.DARK_GRAY

    lateinit var assetManager: AssetManager private set



    override fun create() {
        game = this
        assetManager = AssetManager()

        NavigationManager.navigate(TestScreen())
    }

    override fun render() {
        ScreenUtils.clear(color)
        super.render()
    }

    override fun dispose() {
        super.dispose()
        assetManager.dispose()
    }

}