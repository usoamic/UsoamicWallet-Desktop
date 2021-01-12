package io.usoamic.wallet.extensions

import javafx.scene.image.Image
import tornadofx.Component

fun Component.image(url: String): Image {
    return resources.image(url)
}