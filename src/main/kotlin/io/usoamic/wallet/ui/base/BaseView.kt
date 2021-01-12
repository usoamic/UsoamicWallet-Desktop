package io.usoamic.wallet.ui.base

import io.usoamic.wallet.domain.models.base.ErrorArguments
import io.usoamic.wallet.values.R
import javafx.scene.Node
import tornadofx.*

abstract class BaseView(title: String? = R.string.APP_NAME, icon: Node? = null) : View(title, icon) {
    init {
        inject()
    }

    protected open fun showErrorDialog(error: String) = showErrorDialog(error, false)

    protected open fun showErrorDialog(error: String, isFinish: Boolean) {
        TODO()
    }

    protected open fun showErrorDialog(error: ErrorArguments) {
        TODO()
    }

    protected open fun inject() = Unit
}