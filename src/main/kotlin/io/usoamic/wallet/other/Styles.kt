package io.usoamic.wallet.other

import io.usoamic.wallet.util.ResourcesUtil
import io.usoamic.wallet.values.R
import javafx.scene.text.FontWeight
import tornadofx.*

class Styles : Stylesheet() {
    companion object {
        val heading by cssclass()
    }

    init {
        label and heading {
            padding = box(10.px)
            fontSize = 20.px
            fontWeight = FontWeight.BOLD
        }

        setStageIcon(ResourcesUtil.getImage(R.image.IC_LAUNCHER))
    }
}