package com.veldan.template.advanced

import com.badlogic.gdx.utils.Disposable
import com.veldan.template.utils.controller.GroupController

abstract class AbstractAdvancedGroup: AdvancedGroup() {

    protected abstract val controller: GroupController



    override fun dispose() {
        super.dispose()
        if (controller is Disposable) (controller as Disposable).dispose()
    }

}