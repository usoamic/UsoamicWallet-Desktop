package io.usoamic.wallet.ui.main.wallet

import io.usoamic.wallet.ui.base.BaseView
import io.usoamic.wallet.ui.main.dashboard.DashboardView
import io.usoamic.wallet.ui.main.deposit.DepositView
import io.usoamic.wallet.ui.main.history.HistoryView
import io.usoamic.wallet.ui.main.withdraw.WithdrawView
import javafx.scene.control.TabPane
import tornadofx.tabpane

class WalletView : BaseView() {
    override val root: TabPane = tabpane {
        tabClosingPolicy = TabPane.TabClosingPolicy.UNAVAILABLE
        tab<DashboardView>()
        tab<DepositView>()
        tab<WithdrawView>()
        tab<HistoryView>()
    }
}
