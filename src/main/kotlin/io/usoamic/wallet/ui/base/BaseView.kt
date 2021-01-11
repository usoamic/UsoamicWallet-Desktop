package io.usoamic.wallet.ui.base

import io.usoamic.wallet.domain.models.base.ErrorArguments
import javafx.scene.Node
import tornadofx.*

abstract class BaseView(title: String? = null, icon: Node? = null) : View(title, icon) {
    protected open fun showErrorDialog(error: String) = showErrorDialog(error, false)

    protected open fun showErrorDialog(error: String, isFinish: Boolean) {

    }

    protected open fun showErrorDialog(error: ErrorArguments) {

    }
}