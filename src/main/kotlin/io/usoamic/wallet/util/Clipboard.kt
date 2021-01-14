package io.usoamic.wallet.util

import io.usoamic.wallet.values.R
import javafx.scene.input.ClipboardContent
import tornadofx.information
import javafx.scene.input.Clipboard as FxClipboard


object Clipboard {
    private val clipboardContent = ClipboardContent()

    @JvmStatic
    fun copy(content: String) {
        clipboardContent.putString(content)
        FxClipboard.getSystemClipboard().setContent(clipboardContent)
        information(
            header = "",
            content = R.string.COPIED_TO_CLIPBOARD
        )
    }
}