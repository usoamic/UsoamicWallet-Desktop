package io.usoamic.wallet.ui.auth.create

import io.usoamic.wallet.UsoamicWallet
import io.usoamic.wallet.extensions.*
import io.usoamic.wallet.ui.auth.add.AddView
import io.usoamic.wallet.ui.auth.auth.AuthView
import io.usoamic.wallet.ui.base.BaseVmView
import io.usoamic.wallet.values.R
import javafx.scene.layout.StackPane
import tornadofx.*

class CreateView : BaseVmView<CreateViewModel>() {
    override val root: StackPane = stackpane {
        progressWhen {
            viewModel.ldProgress
        }
        vbox {
            hiddenWhen { viewModel.ldProgress }

            backbuttontoolbar {
                replaceWithSlideRight<AuthView>()
            }

            vbox(R.dimen.DEFAULT_INDENT) {
                paddingLeft = R.dimen.DEFAULT_INDENT
                paddingRight = R.dimen.DEFAULT_INDENT

                pane()

                informationBox(R.string.NEED_SAVE_PRIVATE_KEY_WARNING)

                vbox(R.dimen.DEFAULT_SMALL_INDENT) {
                    informationItem(
                        title = R.string.ADDRESS,
                        message = viewModel.ldAddress,
                        isCopyable = true
                    )
                    informationItem(
                        title = R.string.PRIVATE_KEY,
                        message = viewModel.ldPrivateKey,
                        isCopyable = true
                    )
                }
                button(R.string.NEXT) {
                    fitToParentWidth()
                    action {
                        replaceWithSlideLeft<AddView>()
                    }
                }
            }
        }
    }

    override fun inject() {
        UsoamicWallet.component.createSubcomponent.create().inject(this)
    }
}