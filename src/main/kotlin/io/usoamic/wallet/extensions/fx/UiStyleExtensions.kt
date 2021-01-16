package io.usoamic.wallet.extensions.fx

import io.usoamic.wallet.other.Styles
import io.usoamic.wallet.values.R
import javafx.scene.image.ImageView
import javafx.scene.layout.Region
import tornadofx.paddingLeft
import tornadofx.paddingRight

fun ImageView.fitToHalfWindow() {
    fitWidth = Styles.WIDTH /2
    fitHeight = Styles.HEIGHT /2
}

fun Region.setDefaultPaddings() {
    paddingLeft = R.dimen.DEFAULT_INDENT
    paddingRight = R.dimen.DEFAULT_INDENT
}