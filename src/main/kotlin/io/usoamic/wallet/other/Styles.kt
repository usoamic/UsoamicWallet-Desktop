package io.usoamic.wallet.other

import io.usoamic.wallet.util.ResourcesUtil
import io.usoamic.wallet.values.R
import tornadofx.*

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

        setStageIcon(ResourcesUtil.getImage(R.image.IC_LAUNCHER))
    }

    companion object {
        const val WIDTH = 400.0
        const val HEIGHT = 400.0
    }
}