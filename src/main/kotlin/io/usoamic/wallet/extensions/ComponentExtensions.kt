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
    return replaceWithSlide<T>(ViewTransition.Direction.LEFT)
}

inline fun <reified T : UIComponent> UIComponent.replaceWithSlideRight(): Boolean {
    return replaceWithSlide<T>(ViewTransition.Direction.RIGHT)
}

inline fun <reified T : UIComponent> UIComponent.replaceWithSlide(direction: ViewTransition.Direction): Boolean {
    return replaceWith(
        T::class,
        ViewTransition.Slide(
            0.3.seconds,
            direction
        )
    )
}