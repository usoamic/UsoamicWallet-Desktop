package io.usoamic.wallet.util

import javafx.scene.image.Image

object ResourcesUtil {
    private const val imageSrc = "/images"

    @JvmStatic
    fun getImage(name: String, backgroundLoading: Boolean = false): Image {
        val url = javaClass.getResource("$imageSrc/$name")
        return Image(url.toString(), backgroundLoading)
    }
}

