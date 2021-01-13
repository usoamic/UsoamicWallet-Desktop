package io.usoamic.wallet.util

import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIcon
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIconView
import javafx.scene.paint.Color

object FontAwesomeFXUtil {
    //https://github.com/edvin/tornadofx/issues/609
    fun getIcon(icon: MaterialDesignIcon, color: Color, size: Int = 20): MaterialDesignIconView {
        return MaterialDesignIconView(icon).apply {
            glyphSize = size
            fill = color
        }
    }
}
