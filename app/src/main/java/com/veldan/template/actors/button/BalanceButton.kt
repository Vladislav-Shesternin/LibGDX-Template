package com.veldan.template.actors.button

import com.badlogic.gdx.audio.Sound
import com.veldan.template.actors.label.LabelStyleUtil
import com.veldan.template.actors.label.spinning.SpinningLabel
import com.veldan.template.advanced.AdvancedGroup
import com.veldan.template.manager.assets.util.SoundUtil
import com.veldan.template.utils.disable
import com.veldan.template.utils.transformToBalanceFormat

class BalanceButton : AdvancedGroup() {

    private val button = ButtonClickable(ButtonClickable.Style.balance)
    private val label  = SpinningLabel("", LabelStyleUtil.robotoMono60)



    override fun sizeChanged() {
        if (width > 0 && height > 0) addActorsOnGroup()
    }



    private fun addActorsOnGroup() {
        addAndFillActors(button, label)
        label.disable()
    }



    fun setBalance(balance: Long) {
        label.setText(balance.transformToBalanceFormat())
    }

    fun setOnClickListener(sound: Sound? = SoundUtil.CLICK_BALANCE, block: () -> Unit) {
        button.setOnClickListener(sound, block)
    }

}