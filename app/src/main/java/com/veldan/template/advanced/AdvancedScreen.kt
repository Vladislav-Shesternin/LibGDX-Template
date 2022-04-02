package com.veldan.template.advanced

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input
import com.badlogic.gdx.InputMultiplexer
import com.badlogic.gdx.ScreenAdapter
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.scenes.scene2d.ui.Image
import com.badlogic.gdx.utils.Disposable
import com.badlogic.gdx.utils.viewport.ExtendViewport
import com.badlogic.gdx.utils.viewport.FitViewport
import com.veldan.template.manager.NavigationManager
import com.veldan.template.utils.*
import com.veldan.template.utils.controller.ScreenController

abstract class AdvancedScreen : ScreenAdapter(), AdvancedInputProcessor {
    abstract val controller: ScreenController

    private val backViewport by lazy { ExtendViewport(Gdx.graphics.width.toFloat(), Gdx.graphics.height.toFloat()) }
    private val backStage    by lazy { AdvancedStage(backViewport) }

    private val onceAddBackBackground  = Once()
    private val onceAddFrontBackground = Once()

    val viewport by lazy { FitViewport(WIDTH, HEIGHT) }
    val stage    by lazy { AdvancedStage(viewport) }

    val inputMultiplexer = InputMultiplexer()

    var backBackground : Texture? = null
    var background     : Texture? = null



    override fun show() {
        Gdx.input.inputProcessor = inputMultiplexer.apply { addProcessors(this@AdvancedScreen, stage) }
        Gdx.input.setCatchKey(Input.Keys.BACK, true)
    }

    override fun resize(width: Int, height: Int) {
        backViewport.update(width, height, true)
        viewport.update(width, height, true)
    }

    override fun render(delta: Float) {
        backStage.render()
        stage.render()

        addBackBackground()
        addFrontBackground()
    }

    override fun hide() {
        dispose()
    }

    override fun dispose() {
        disposeAll(backStage, stage)
        inputMultiplexer.clear()
        if (controller is Disposable) (controller as Disposable).dispose()
    }

    override fun keyDown(keycode: Int): Boolean {
        if (keycode == Input.Keys.BACK) NavigationManager.back()
        return super.keyDown(keycode)
    }



    private fun addBackBackground() {
        backBackground?.let { img -> onceAddBackBackground.once {
            backStage.addActor(Image(img).apply { setSize(backViewport.worldWidth, backViewport.worldHeight) })
        } }
    }

    private fun addFrontBackground() {
        background?.let { img -> onceAddFrontBackground.once {
            stage.addActor(Image(img).apply { setSize(WIDTH, HEIGHT) })
        } }
    }

}