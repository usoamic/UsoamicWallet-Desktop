package io.usoamic.wallet.extensions.fx

import io.usoamic.wallet.other.Styles
import io.usoamic.wallet.values.R
import javafx.scene.image.ImageView
import javafx.scene.layout.Region
import tornadofx.paddingLeft
import tornadofx.paddingRight

fun ImageView.fitToHalfWindow() {
    val size = Styles.WIDTH.coerceAtMost(Styles.HEIGHT) / 2

    fitWidth = size
    fitHeight = size
}

fun Region.setDefaultPaddings() {
    paddingLeft = R.dimen.DEFAULT_INDENT
    paddingRight = R.dimen.DEFAULT_INDENT
}