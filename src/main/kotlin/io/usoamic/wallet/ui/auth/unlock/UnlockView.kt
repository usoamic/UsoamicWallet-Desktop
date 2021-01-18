package io.usoamic.wallet.ui.auth.unlock

import io.usoamic.wallet.UsoamicWallet
import io.usoamic.wallet.extensions.fx.clear
import io.usoamic.wallet.extensions.fx.progressWhen
import io.usoamic.wallet.extensions.observe
import io.usoamic.wallet.ui.auth.auth.AuthView
import io.usoamic.wallet.ui.base.BaseVmView
import io.usoamic.wallet.ui.main.wallet.WalletView
import io.usoamic.wallet.values.R
import javafx.scene.control.ButtonType
import javafx.scene.layout.StackPane
import tornadofx.*

class UnlockView : BaseVmView<UnlockViewModel>() {
    private val propPassword = stringProperty("")

    override val root: StackPane = stackpane {
        progressWhen {
            viewModel.ldProgress
        }
        vbox {
            hiddenWhen { viewModel.ldProgress }

            vbox {
                form {
                    fieldset {
                        field(R.string.PASSWORD) {
                            passwordfield(propPassword)
                        }
                    }

                    vbox(R.dimen.DEFAULT_INDENT) {
                        button(R.string.NEXT) {
                            fitToParentWidth()
                            action {
                                viewModel.onNextClick(propPassword.value)
                            }
                        }

                        button(R.string.LOGOUT) {
                            fitToParentWidth()
                            action {
                                onLogoutClick()
                            }
                        }
                    }
                }
            }
        }
    }

    override fun inject() {
        UsoamicWallet.component.unlockSubcomponent.create().inject(this)
    }

    override fun initObservers() {
        super.initObservers()
        observe(viewModel.leNext) {
            goToWallet()
        }
        observe(viewModel.leLogout) { isRemoved ->
            if (!isRemoved) {
                showErrorDialog(R.string.REMOVE_WALLET_ERROR)
            }
            goToAuth()
        }
    }

    private fun onLogoutClick() {
        confirmation(
            header = "",
            content = R.string.LOGOUT_MESSAGE,
            title = R.string.APP_NAME,
            actionFn = {
                if (result == ButtonType.OK) {
                    viewModel.onLogoutClick()
                }
            },
            buttons = arrayOf(ButtonType.CANCEL, ButtonType.OK)

        )
    }

    private fun goToWallet() {
        replaceWith<WalletView>()
    }

    private fun goToAuth() {
        replaceWith<AuthView>()
    }

    override fun onUndock() {
        super.onUndock()
        propPassword.clear()
    }
}