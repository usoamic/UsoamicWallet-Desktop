package io.usoamic.wallet.other

import io.usoamic.wallet.util.ResourcesUtil
import io.usoamic.wallet.values.R
import javafx.geometry.Pos
import tornadofx.Stylesheet
import tornadofx.px
import tornadofx.setStageIcon

class Styles : Stylesheet() {
    init {
        root {
            prefWidth = WIDTH.px
            prefHeight = HEIGHT.px

            minWidth = 0.px
            minHeight = 0.px

            maxWidth = WIDTH.px
            maxHeight = HEIGHT.px
        }

        tableColumn {
            alignment = Pos.BASELINE_CENTER
        }

        setStageIcon(ResourcesUtil.getImage(R.image.IC_USOAMIC))
    }

    companion object {
        const val WIDTH = 600.0
        const val HEIGHT = 400.0
    }
}