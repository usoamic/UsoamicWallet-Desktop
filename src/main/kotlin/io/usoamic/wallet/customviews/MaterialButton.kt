package io.usoamic.wallet.customviews

import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIcon
import io.usoamic.wallet.util.FontAwesomeFXUtil
import io.usoamic.wallet.values.R
import javafx.event.EventTarget
import javafx.scene.control.Button
import javafx.scene.control.ToolBar
import javafx.scene.paint.Color
import tornadofx.addClass
import tornadofx.button
import tornadofx.style

fun ToolBar.materialbutton(icon: MaterialDesignIcon, op: Button.() -> Unit = {}) = Button().also {
    it.addClass("icon-only")

    it.graphic = FontAwesomeFXUtil.getIconView(
        icon = icon,
        color = R.color.TOOLBAR_BUTTON_COLOR
    )
    it.style {
        backgroundColor += Color.TRANSPARENT
    }

    items += it
    op(it)
}

fun EventTarget.materialbutton(icon: MaterialDesignIcon, op: Button.() -> Unit = {}) = button {
    addClass("icon-only")

    graphic = FontAwesomeFXUtil.getIconView(
        icon = icon,
        color = R.color.TOOLBAR_BUTTON_COLOR
    )
    style {
        backgroundColor += Color.TRANSPARENT
    }
}