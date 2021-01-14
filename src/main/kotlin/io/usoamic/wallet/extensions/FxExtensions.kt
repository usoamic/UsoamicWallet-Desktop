package io.usoamic.wallet.extensions

import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIcon
import io.usoamic.wallet.util.FontAwesomeFXUtil
import io.usoamic.wallet.values.R
import javafx.event.EventTarget
import javafx.geometry.Pos
import javafx.scene.control.Button
import javafx.scene.control.ToolBar
import javafx.scene.layout.BorderPane
import javafx.scene.layout.HBox
import javafx.scene.layout.VBox
import javafx.scene.paint.Color
import tornadofx.*

fun ToolBar.materialbutton(icon: MaterialDesignIcon, op: Button.() -> Unit = {}) = Button().also {
    addClass("icon-only")

    it.graphic = FontAwesomeFXUtil.getIcon(
        icon = icon,
        color = R.color.TOOLBAR_BUTTON_COLOR
    )
    it.style {
        backgroundColor += Color.TRANSPARENT
    }

    items += it
    op(it)
}

fun EventTarget.backbuttontoolbar(backAction: () -> Unit = {}): ToolBar {
    return toolbar {
        addClass("header")
        // Force the container to retain pos center even when it's resized (hack to make ToolBar behave)
        skinProperty().onChange {
            (lookup(".container") as? HBox)?.apply {
                alignment = Pos.CENTER_LEFT
                alignmentProperty().onChange {
                    if (it != Pos.CENTER_LEFT) alignment = Pos.CENTER_LEFT
                }
            }
        }
        materialbutton(MaterialDesignIcon.ARROW_LEFT) {
            action {
                backAction.invoke()
            }
        }
        spacer()
    }
}