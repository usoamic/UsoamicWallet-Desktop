package io.usoamic.wallet.ui.start

import io.usoamic.wallet.UsoamicWallet
import io.usoamic.wallet.other.Styles
import io.usoamic.wallet.ui.base.BaseVmView
import javafx.scene.layout.HBox
import tornadofx.*

class StartView : BaseVmView<StartViewModel>("Hello TornadoFX") {
    override val root: HBox = hbox {
        label(viewModel.idProperty) {
            addClass(Styles.heading)
            onLeftClick {
                viewModel.run()
            }
        }
        stackpane {
            visibleWhen { viewModel.ldProgress }
            progressindicator()
        }
    }

    override fun inject() {
        UsoamicWallet.component.inject(this)
    }
}