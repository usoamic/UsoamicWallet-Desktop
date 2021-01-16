package io.usoamic.wallet.ui.main.deposit

import io.usoamic.wallet.UsoamicWallet
import io.usoamic.wallet.extensions.copyToClipboardOnClick
import io.usoamic.wallet.extensions.fitToHalfWindow
import io.usoamic.wallet.extensions.progressWhen
import io.usoamic.wallet.extensions.setDefaultPaddings
import io.usoamic.wallet.ui.base.BaseVmView
import io.usoamic.wallet.values.R
import javafx.geometry.Pos
import javafx.scene.layout.StackPane
import javafx.scene.text.TextAlignment
import tornadofx.*

class DepositView : BaseVmView<DepositViewModel>(R.string.TITLE_DEPOSIT_SCREEN) {
    override val root: StackPane = stackpane {
        progressWhen {
            viewModel.ldProgress
        }
        vbox {
            hiddenWhen { viewModel.ldProgress }

            setDefaultPaddings()

            alignment = Pos.CENTER

            pane()

            imageview(viewModel.ldImage) {
                fitToHalfWindow()
            }

            label(viewModel.ldAddress) {
                textAlignment = TextAlignment.CENTER
                paddingTop = R.dimen.DEFAULT_SMALL_INDENT
                isWrapText = true
                copyToClipboardOnClick()
            }
        }
    }

    override fun inject() {
        UsoamicWallet.component.depositSubcomponent.create().inject(this)
    }
}