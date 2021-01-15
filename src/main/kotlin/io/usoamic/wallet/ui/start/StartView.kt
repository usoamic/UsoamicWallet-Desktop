package io.usoamic.wallet.ui.start

import io.usoamic.wallet.UsoamicWallet
import io.usoamic.wallet.extensions.observe
import io.usoamic.wallet.ui.auth.auth.AuthView
import io.usoamic.wallet.ui.auth.unlock.UnlockView
import io.usoamic.wallet.ui.base.BaseVmView
import io.usoamic.wallet.util.BuildConfig
import io.usoamic.wallet.values.R
import javafx.geometry.Pos
import javafx.scene.layout.StackPane
import tornadofx.*

class StartView : BaseVmView<StartViewModel>() {
    override val root: StackPane = stackpane {
        paddingAll = 50
        vbox {
            vbox {
                spacing = 10.0
                alignment = Pos.CENTER
                imageview(R.image.IC_USOAMIC) {
                    fitHeight = 200.0
                    fitWidth = 200.0
                }
                vbox {
                    alignment = Pos.CENTER
                    label(R.string.APP_NAME)
                    label {
                        text = StringBuilder()
                            .append(BuildConfig.VERSION_NAME)
                            .append(" (")
                            .append(BuildConfig.VERSION_CODE)
                            .append(")")
                            .toString()
                    }
                }
                progressbar {
                    vboxConstraints {
                        marginTop = 10.0
                    }
                }
            }

        }
    }

    override fun inject() {
        UsoamicWallet.component.inject(this)
    }

    override fun initObservers() {
        super.initObservers()
        observe(viewModel.ldHasAccount, ::goToNextView)
    }

    private fun goToNextView(hasAccount: Boolean) {
        if (hasAccount) {
            replaceWith<UnlockView>()
        } else {
            replaceWith<AuthView>()
        }
    }
}