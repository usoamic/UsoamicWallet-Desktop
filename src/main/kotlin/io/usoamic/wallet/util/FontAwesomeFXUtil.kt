package io.usoamic.wallet.util

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIcon
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIconView
import javafx.scene.paint.Color

object FontAwesomeFXUtil {
    //https://github.com/edvin/tornadofx/issues/609
    fun getIconView(icon: FontAwesomeIcon, color: Color, size: Int = 20): FontAwesomeIconView {
        return FontAwesomeIconView(icon).apply {
            glyphSize = size
            fill = color
        }
    }

    fun getIconView(icon: MaterialDesignIcon, color: Color, size: Int = 20): MaterialDesignIconView {
        return MaterialDesignIconView(icon).apply {
            glyphSize = size
            fill = color
        }
    }
}
