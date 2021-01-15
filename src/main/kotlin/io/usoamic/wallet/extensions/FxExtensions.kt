package io.usoamic.wallet.extensions

import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIcon
import io.usoamic.wallet.other.MutableLiveData
import io.usoamic.wallet.other.liveDataOf
import io.usoamic.wallet.util.Clipboard
import io.usoamic.wallet.util.FontAwesomeFXUtil
import io.usoamic.wallet.values.R
import javafx.beans.value.ObservableValue
import javafx.event.EventTarget
import javafx.geometry.Pos
import javafx.scene.control.*
import javafx.scene.layout.HBox
import javafx.scene.layout.StackPane
import javafx.scene.paint.Color
import javafx.scene.text.TextAlignment
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

fun EventTarget.backbuttontoolbar(backAction: () -> Unit = {}): ToolBar = ToolBar().also { toolbar ->
    toolbar.addClass("header")
    // Force the container to retain pos center even when it's resized (hack to make ToolBar behave)
    toolbar.skinProperty().onChange { s ->
        (toolbar.lookup(".container") as? HBox)?.apply {
            alignment = Pos.CENTER_LEFT
            alignmentProperty().onChange {
                if (it != Pos.CENTER_LEFT) alignment = Pos.CENTER_LEFT
            }
        }
    }
    toolbar.materialbutton(MaterialDesignIcon.ARROW_LEFT) {
        action {
            backAction.invoke()
        }
    }
    toolbar.spacer()
    addChildIfPossible(toolbar)
}

fun EventTarget.informationBox(message: String): StackPane = informationBox(
    title = "",
    value = liveDataOf(message),
    isCopyable = false,
    alignment = TextAlignment.CENTER
)

fun EventTarget.informationItem(title: String, message: MutableLiveData<String>, isCopyable: Boolean) = informationBox(
    title = title,
    value = message,
    alignment = TextAlignment.LEFT,
    isCopyable = isCopyable
)

fun EventTarget.informationBox(
    title: String,
    value: MutableLiveData<String>,
    alignment: TextAlignment,
    isCopyable: Boolean
): StackPane = StackPane().also {
    it.stackpane {
        style {
            backgroundColor += Color.WHITE
            borderColor += box(Color.GRAY)
        }
        vbox {
            paddingAll = R.dimen.DEFAULT_SMALL_INDENT
            if (title.isNotEmpty()) {
                label(title)
            }
            label(value) {
                textAlignment = alignment
                isWrapText = true
                if (isCopyable) {
                    copyToClipboardOnClick()
                }
            }
        }

    }
    addChildIfPossible(it)
}

fun Label.copyToClipboardOnClick() {
    setOnMouseClicked {
        if (text != null) {
            Clipboard.copy(text)
        }
    }
}

fun EventTarget.progressWhen(expr: () -> ObservableValue<Boolean>): Control {
    return ProgressBar().attachTo(this).also {
        it.visibleWhen(expr)
    }
}
