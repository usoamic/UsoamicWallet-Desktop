package io.usoamic.wallet.ui.main.withdraw

import io.usoamic.wallet.UsoamicWallet
import io.usoamic.wallet.commons.models.withdraw.WithdrawCoin
import io.usoamic.wallet.extensions.fx.clear
import io.usoamic.wallet.extensions.fx.progressWhen
import io.usoamic.wallet.extensions.observe
import io.usoamic.wallet.helpers.informationMessage
import io.usoamic.wallet.ui.base.BaseVmView
import io.usoamic.wallet.values.R
import javafx.geometry.Pos
import javafx.scene.layout.StackPane
import tornadofx.*

class WithdrawView : BaseVmView<WithdrawViewModel>(R.string.TITLE_WITHDRAW_SCREEN) {
    private val propPassword = stringProperty("")
    private val propAddress = stringProperty("")
    private val propValue = stringProperty("")
    private val propGasPrice = stringProperty(R.string.GP_AUTO)

    override val root: StackPane = stackpane {
        progressWhen {
            viewModel.ldProgress
        }
        vbox {
            hiddenWhen { viewModel.ldProgress }

            form {
                fieldset {
                    field(R.string.PASSWORD) {
                        passwordfield(propPassword)
                    }
                    field(R.string.ADDRESS) {
                        textfield(propAddress)
                    }
                    field(R.string.VALUE) {
                        textfield(propValue)
                    }
                    field(R.string.GAS_PRICE) {
                        stackpane {
                            alignment = Pos.CENTER_RIGHT
                            choicebox(
                                propGasPrice,
                                observableListOf(
                                    R.string.GP_AUTO,
                                    R.string.GP_20,
                                    R.string.GP_40,
                                    R.string.GP_60,
                                    R.string.GP_80,
                                    R.string.GP_100,
                                    R.string.GP_120
                                )
                            )
                        }
                    }
                }
                vbox(R.dimen.DEFAULT_INDENT) {
                    button(R.string.WITHDRAW_ETH) {
                        fitToParentWidth()
                        action {
                            withdraw(WithdrawCoin.ETH)
                        }
                    }
                    button(R.string.WITHDRAW_USO) {
                        fitToParentWidth()
                        action {
                            withdraw(WithdrawCoin.USO)
                        }
                    }
                }
            }
        }
    }

    override fun initObservers() {
        super.initObservers()
        observe(viewModel.leWithdraw, ::setAsWithdrawn)
    }

    private fun setAsWithdrawn(message: String) {
        propPassword.clear()
        informationMessage(message)
    }

    private fun withdraw(
        coin: WithdrawCoin
    ) {
        viewModel.withdraw(
            coin = coin,
            password = propPassword.value,
            to = propAddress.value,
            value = propValue.value,
            gasPrice = propGasPrice.value
        )

    }

    override fun inject() {
        UsoamicWallet.component.withdrawSubcomponent.create().inject(this)
    }
    
    override fun onTabSelected() {
        super.onTabSelected()
        propPassword.clear()
        propAddress.clear()
        propValue.clear()
        propGasPrice.clear()
    }
}