package io.usoamic.wallet.ui.base

import javafx.scene.Node
import javax.inject.Inject

abstract class BaseVmView<T : BaseViewModel>(title: String? = null, icon: Node? = null) : BaseView(title, icon) {
    @Inject
    lateinit var viewModel: T
}