package io.usoamic.wallet.extensions

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView
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

fun EventTarget.informationBox(message: String): StackPane = informationContainer(
    title = "",
    value = liveDataOf(message),
    isCopyable = false,
    textAlign = TextAlignment.CENTER
)

fun EventTarget.informationItem(
    icon: FontAwesomeIcon? = null,
    title: String,
    message: MutableLiveData<String>,
    isCopyable: Boolean = false
) = informationContainer(
    icon = icon,
    title = title,
    value = message,
    textAlign = TextAlignment.LEFT,
    isCopyable = isCopyable
)

private fun EventTarget.informationContainer(
    icon: FontAwesomeIcon? = null,
    title: String,
    value: MutableLiveData<String>,
    textAlign: TextAlignment,
    isCopyable: Boolean
): StackPane = StackPane().also {
    it.stackpane {
        style {
            backgroundColor += Color.WHITE
            borderColor += box(Color.GRAY)
        }
        hbox {
            alignment = when (textAlign) {
                TextAlignment.CENTER,
                TextAlignment.JUSTIFY -> Pos.CENTER
                TextAlignment.LEFT -> Pos.CENTER_LEFT
                TextAlignment.RIGHT -> Pos.CENTER_RIGHT
            }

            if (icon != null) {
                stackpane {
                    paddingLeft = R.dimen.DEFAULT_LARGE_INDENT
                    paddingRight = R.dimen.DEFAULT_INDENT

                    alignment = Pos.CENTER

                    fontawesomeiconview(
                        image = icon,
                        color = Color.BLACK
                    )
                }

            }

            vbox {
                paddingAll = R.dimen.DEFAULT_SMALL_INDENT
                if (title.isNotEmpty()) {
                    label(title)
                }
                label(value) {
                    textAlignment = textAlign

                    isWrapText = true
                    if (isCopyable) {
                        copyToClipboardOnClick()
                    }
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

fun EventTarget.fontawesomeiconview(
    image: FontAwesomeIcon,
    color: Color,
    size: Int = 20,
    op: FontAwesomeIconView.() -> Unit = {}
): FontAwesomeIconView {
    return FontAwesomeIconView(image).also {
        it.glyphSize = size
        it.fill = color
        it.attachTo(this, op)
    }
}
