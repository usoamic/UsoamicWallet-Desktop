package io.usoamic.wallet.util

import javafx.scene.image.Image

object ResourcesUtil {
    @JvmStatic
    fun getImage(path: String, backgroundLoading: Boolean = false): Image {
        val url = javaClass.getResource(path)
        return Image(url.toString(), backgroundLoading)
    }
}

