package io.usoamic.wallet.customviews

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView
import javafx.event.EventTarget
import javafx.scene.paint.Color
import tornadofx.attachTo

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