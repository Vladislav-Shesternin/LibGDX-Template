package com.veldan.template.screens.test

import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.NinePatch
import com.badlogic.gdx.graphics.g2d.TextureAtlas
import com.badlogic.gdx.scenes.scene2d.ui.Image
import com.badlogic.gdx.scenes.scene2d.utils.NinePatchDrawable
import com.veldan.template.advanced.AdvancedScreen
import com.veldan.template.advanced.AdvancedStage

class TestScreen: AdvancedScreen() {

    override val controller = TestScreenController(this)

   // val backgroundTexture = Texture("background.png")
   // val imageTexture      = Texture("a.png")

    val nineImage = Image()



    override fun show() {
        super.show()


        //setBackgrounds(backgroundTexture, imageTexture)

        stage.addActorsOnStage()
    }


    private fun AdvancedStage.addActorsOnStage() {
        addNineImage()
    }

    private fun AdvancedStage.addNineImage() {
        addActor(nineImage)
    }


}