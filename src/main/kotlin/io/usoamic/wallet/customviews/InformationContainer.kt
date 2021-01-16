package io.usoamic.wallet.customviews

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon
import io.usoamic.wallet.extensions.fx.copyToClipboardOnClick
import io.usoamic.wallet.other.MutableLiveData
import io.usoamic.wallet.other.liveDataOf
import io.usoamic.wallet.values.R
import javafx.event.EventTarget
import javafx.geometry.Pos
import javafx.scene.layout.StackPane
import javafx.scene.paint.Color
import javafx.scene.text.TextAlignment
import tornadofx.*

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