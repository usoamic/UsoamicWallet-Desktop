package io.usoamic.wallet.ui.main.wallet

import io.usoamic.wallet.customviews.refreshbuttontoolbar
import io.usoamic.wallet.ui.base.BaseView
import io.usoamic.wallet.ui.main.dashboard.DashboardView
import io.usoamic.wallet.ui.main.deposit.DepositView
import io.usoamic.wallet.ui.main.history.HistoryView
import io.usoamic.wallet.ui.main.withdraw.WithdrawView
import javafx.scene.control.TabPane
import javafx.scene.layout.BorderPane
import tornadofx.*

class WalletView : BaseView() {
    private lateinit var tabPane: TabPane

    override val root: BorderPane = borderpane {
        center {
            tabpane {
                tabClosingPolicy = TabPane.TabClosingPolicy.UNAVAILABLE

                tab<DashboardView> {

                }
                tab<DepositView>()
                tab<WithdrawView>()
                tab<HistoryView>()
                tabPane = this
            }
        }
        bottom {
            refreshbuttontoolbar {
                refresh()
            }
        }
    }

    private fun refresh() {
        if(::tabPane.isInitialized) {
            tabPane.onRefresh()
        }
    }
}
