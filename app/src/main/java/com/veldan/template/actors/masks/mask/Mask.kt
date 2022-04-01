package com.veldan.template.actors.masks.mask

import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Batch
import com.veldan.template.advanced.AbstractAdvancedGroup

class Mask(
    val mask: Texture? = null,
) : AbstractAdvancedGroup() {
    override val controller = MaskController(this)



    override fun draw(batch: Batch?, parentAlpha: Float) {
       controller.draw(batch, parentAlpha)
    }



    fun drawSuper(batch: Batch?, parentAlpha: Float) {
        super.draw(batch, parentAlpha)
    }

}