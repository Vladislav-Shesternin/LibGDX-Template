package com.veldan.template.screens.test

import com.badlogic.gdx.graphics.Texture
import com.veldan.template.advanced.AdvancedScreen
import com.veldan.template.advanced.AdvancedStage

class TestScreen: AdvancedScreen() {

    override val controller = TestScreenController(this)

    val backgroundTexture = Texture("background.png")
    val imageTexture      = Texture("a.png")



    override fun show() {
        super.show()

        backBackground = backgroundTexture
        background     = imageTexture

        stage.addActorsOnStage()
    }


    private fun AdvancedStage.addActorsOnStage() {

    }


}