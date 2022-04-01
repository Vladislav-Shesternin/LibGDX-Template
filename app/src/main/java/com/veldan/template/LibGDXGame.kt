package com.veldan.template

import com.badlogic.gdx.assets.AssetManager
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.utils.ScreenUtils
import com.veldan.template.advanced.AdvancedGame
import com.veldan.template.manager.NavigationManager
import com.veldan.template.screens.test.TestScreen

lateinit var game        : LibGDXGame   private set
lateinit var assetManager: AssetManager private set

class LibGDXGame : AdvancedGame() {

    private val color = Color.BLACK



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