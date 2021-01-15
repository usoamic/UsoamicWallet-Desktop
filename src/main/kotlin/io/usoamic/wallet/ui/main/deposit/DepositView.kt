package io.usoamic.wallet.ui.main.deposit

import io.usoamic.wallet.UsoamicWallet
import io.usoamic.wallet.extensions.progressWhen
import io.usoamic.wallet.ui.base.BaseVmView
import io.usoamic.wallet.values.R
import javafx.scene.layout.StackPane
import tornadofx.hiddenWhen
import tornadofx.stackpane
import tornadofx.vbox

class DepositView : BaseVmView<DepositViewModel>(R.string.TITLE_DEPOSIT_SCREEN) {
    override val root: StackPane = stackpane {
        progressWhen {
            viewModel.ldProgress
        }
        vbox {
            hiddenWhen { viewModel.ldProgress }
        }
    }

    override fun inject() {
        UsoamicWallet.component.depositSubcomponent.create().inject(this)
    }
}