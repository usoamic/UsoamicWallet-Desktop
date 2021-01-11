package io.usoamic.wallet.ui.start

import io.usoamic.wallet.UsoamicWallet
import io.usoamic.wallet.other.Styles
import io.usoamic.wallet.ui.base.BaseVmView
import tornadofx.addClass
import tornadofx.hbox
import tornadofx.label

class StartView : BaseVmView<StartViewModel>("Hello TornadoFX") {
    override val root = hbox {
        label(title) {
            addClass(Styles.heading)
        }
    }

    init {
        UsoamicWallet.component.inject(this)
        viewModel.run()
    }
}