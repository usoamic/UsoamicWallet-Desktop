package io.usoamic.wallet.extensions

import javafx.scene.image.Image
import tornadofx.Component
import tornadofx.UIComponent
import tornadofx.ViewTransition
import tornadofx.seconds

fun Component.image(url: String): Image {
    return resources.image(url)
}

inline fun <reified T : UIComponent> UIComponent.replaceWithSlideLeft(): Boolean {
    return replaceWith(
        T::class,
        ViewTransition.Slide(
            0.3.seconds,
            ViewTransition.Direction.LEFT
        )
    )
}