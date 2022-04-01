package com.veldan.template.screens.test

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.scenes.scene2d.actions.Actions
import com.badlogic.gdx.scenes.scene2d.ui.Image
import com.badlogic.gdx.utils.viewport.FitViewport
import com.veldan.template.actors.masks.invertedMask.InvertedMask
import com.veldan.template.advanced.AdvancedScreen
import com.veldan.template.advanced.AdvancedStage
import com.veldan.template.layout.setBoundsFigmaY
import com.veldan.template.utils.HEIGHT
import com.veldan.template.utils.WIDTH

class TestScreen: AdvancedScreen() {
    override val viewport   = FitViewport(WIDTH, HEIGHT)
    override val controller = TestScreenController(this)

    val backgroundTexture     = Texture("background.png")
    val maskBackgroundTexture = Texture("mask_background.png")
    val maskTexture           = Texture("mask.png")
    val mask1Texture          = Texture("mask_1.png")

    val invertedMask = InvertedMask(maskBackgroundTexture)
    val maskImage    = Image(maskTexture)
    val maskImage1   = Image(mask1Texture)



    override fun show() {
        super.show()
        background = backgroundTexture

        stage.addActorsOnStage()
    }

    override fun render(delta: Float) {
        super.render(delta)
        if (Gdx.input.justTouched()) {
            maskImage.x += 10f
            maskImage1.y += 10f
        }
    }



    private fun AdvancedStage.addActorsOnStage() {
        addInvertedMask()
    }

    private fun AdvancedStage.addInvertedMask() {
        addActor(invertedMask)
        invertedMask.debug()
        invertedMask.setBoundsFigmaY(130f, 261f, 440f, 877f)

        invertedMask.addActors(maskImage, maskImage1)
        maskImage1.setPosition(100f, 300f)
    }


}