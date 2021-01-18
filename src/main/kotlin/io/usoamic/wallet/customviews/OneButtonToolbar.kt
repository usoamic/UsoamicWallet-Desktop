package io.usoamic.wallet.customviews

import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIcon
import io.usoamic.wallet.values.R
import javafx.event.EventTarget
import javafx.geometry.Pos
import javafx.scene.control.ToolBar
import javafx.scene.layout.HBox
import tornadofx.*

fun EventTarget.backbuttontoolbar(backAction: () -> Unit = {}): ToolBar {
    return ToolBar().also { toolbar ->
        toolbar.addClass("header")
        toolbar.applySkinProperty(Pos.CENTER_LEFT)
        // Force the container to retain pos center even when it's resized (hack to make ToolBar behave)
        toolbar.materialbutton(MaterialDesignIcon.ARROW_LEFT) {
            action {
                backAction.invoke()
            }
        }
        toolbar.spacer()
        addChildIfPossible(toolbar)
    }
}

fun EventTarget.refreshbuttontoolbar(refreshAction: () -> Unit = {}): ToolBar {
    return ToolBar().also { toolbar ->
        toolbar.addClass("header")
        toolbar.applySkinProperty(Pos.CENTER_RIGHT)
        // Force the container to retain pos center even when it's resized (hack to make ToolBar behave)
        toolbar.materialbutton(MaterialDesignIcon.REFRESH) {
            setPrefSize(
                R.dimen.DEFAULT_LARGE_INDENT,
                R.dimen.DEFAULT_LARGE_INDENT
            )
            action {
                refreshAction.invoke()
            }
        }
        addChildIfPossible(toolbar)
    }
}

private fun ToolBar.applySkinProperty(align: Pos = Pos.CENTER_LEFT): ToolBar = apply {
    skinProperty().onChange { s ->
        (lookup(".container") as? HBox)?.apply {
            alignment = align

            alignmentProperty().onChange {
                if (it != align) alignment = align
            }
        }
    }
}
