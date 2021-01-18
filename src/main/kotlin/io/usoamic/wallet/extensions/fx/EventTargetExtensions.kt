package io.usoamic.wallet.extensions.fx

import javafx.beans.value.ObservableValue
import javafx.event.EventTarget
import javafx.scene.control.Control
import javafx.scene.control.ProgressBar
import tornadofx.attachTo
import tornadofx.visibleWhen

fun EventTarget.progressWhen(expr: () -> ObservableValue<Boolean>): Control {
    return ProgressBar().attachTo(this).also {
        it.visibleWhen(expr)
    }
}