package com.veldan.template.actors.label

import com.badlogic.gdx.scenes.scene2d.ui.Label
import com.veldan.template.manager.assets.FontTTFManager

object LabelStyleUtil {

    val robotoMono60 get() = Label.LabelStyle(FontTTFManager.EnumFont.ROBOTO_MONO_60.data.font, null)
    val robotoMono30 get() = Label.LabelStyle(FontTTFManager.EnumFont.ROBOTO_MONO_30.data.font, null)

}