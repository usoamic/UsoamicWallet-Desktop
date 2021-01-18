package io.usoamic.wallet.extensions

import com.google.zxing.common.BitMatrix
import javafx.embed.swing.SwingFXUtils
import javafx.scene.image.Image
import java.awt.Color
import java.awt.image.BufferedImage

fun BitMatrix.toImage(): Image {
    val bitmap = BufferedImage(width, height, BufferedImage.TYPE_USHORT_565_RGB)
    for (x in 0 until width) {
        for (y in 0 until height) {
            bitmap.setRGB(x, y, if (get(x, y)) Color.BLACK.rgb else Color.WHITE.rgb)
        }
    }

    return SwingFXUtils.toFXImage(bitmap, null)
}