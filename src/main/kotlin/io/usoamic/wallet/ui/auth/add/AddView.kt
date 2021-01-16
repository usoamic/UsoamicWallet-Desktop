package io.usoamic.wallet.ui.auth.add

import io.usoamic.wallet.UsoamicWallet
import io.usoamic.wallet.customviews.backbuttontoolbar
import io.usoamic.wallet.extensions.fx.progressWhen
import io.usoamic.wallet.extensions.fx.replaceWithSlideLeft
import io.usoamic.wallet.extensions.fx.replaceWithSlideRight
import io.usoamic.wallet.extensions.observe
import io.usoamic.wallet.ui.auth.auth.AuthView
import io.usoamic.wallet.ui.auth.unlock.UnlockView
import io.usoamic.wallet.ui.base.BaseVmView
import io.usoamic.wallet.values.R
import javafx.scene.layout.StackPane
import tornadofx.*

class AddView : BaseVmView<AddViewModel>() {
    private val propPrivateKey = stringProperty("")
    private val propPassword = stringProperty("")
    private val propConfirmPassword = stringProperty("")

    override val root: StackPane = stackpane {
        progressWhen {
            viewModel.ldProgress
        }
        vbox {
            hiddenWhen { viewModel.ldProgress }
            backbuttontoolbar {
                replaceWithSlideRight<AuthView>()
            }
            vbox {
                form {
                    fieldset {
                        field(R.string.PRIVATE_KEY) {
                            textfield(propPrivateKey)
                        }
                        field(R.string.PASSWORD) {
                            passwordfield(propPassword)
                        }
                        field(R.string.CONFIRM_PASSWORD) {
                            passwordfield(propConfirmPassword)
                        }
                    }
                    button(R.string.ADD_ACCOUNT) {
                        fitToParentWidth()
                        action {
                            viewModel.onAddClick(propPrivateKey.value, propPassword.value, propConfirmPassword.value)
                        }
                    }
                }
            }
        }
    }

    override fun inject() {
        UsoamicWallet.component.addSubcomponent.create().inject(this)
    }

    override fun initObservers() {
        super.initObservers()
        observe(viewModel.leAccountAdd) {
            goToUnlock()
        }
    }

    private fun goToUnlock() {
        replaceWithSlideLeft<UnlockView>()
    }
}