package io.usoamic.wallet.ui.base

import io.usoamic.wallet.commons.models.base.ErrorArguments
import io.usoamic.wallet.values.R
import javafx.scene.Node
import javafx.scene.control.Alert
import tornadofx.View
import tornadofx.alert

abstract class BaseView(title: String? = R.string.APP_NAME, icon: Node? = null) : View(title, icon) {
    init {
        inject()
    }

    protected open fun showErrorDialog(error: String) = showErrorDialog(error, false)

    protected open fun showErrorDialog(error: String, isFinish: Boolean) {
        alert(
            type = if (isFinish) {
                Alert.AlertType.ERROR
            } else {
                Alert.AlertType.WARNING
            },
            header = "",
            title = R.string.APP_NAME,
            content = error,
            actionFn = {
                if (isFinish) {
                    currentWindow?.hide()
                }
            }
        )
    }

    protected open fun showErrorDialog(error: ErrorArguments) {
        showErrorDialog(
            error.message ?: R.string.UNKNOWN_ERROR,
            (error is ErrorArguments.Fatal)
        )
    }

    protected open fun inject() = Unit
}