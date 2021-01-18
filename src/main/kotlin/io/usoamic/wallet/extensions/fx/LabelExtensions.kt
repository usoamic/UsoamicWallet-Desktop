package io.usoamic.wallet.extensions.fx

import io.usoamic.wallet.util.Clipboard
import javafx.scene.control.Label

fun Label.copyToClipboardOnClick() {
    setOnMouseClicked {
        if (text != null) {
            Clipboard.copy(text)
        }
    }
}