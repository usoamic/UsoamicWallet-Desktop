package io.usoamic.wallet.ui.main.dashboard

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon
import io.usoamic.wallet.UsoamicWallet
import io.usoamic.wallet.extensions.informationItem
import io.usoamic.wallet.extensions.progressWhen
import io.usoamic.wallet.ui.base.BaseVmView
import io.usoamic.wallet.ui.helpers.RefreshableView
import io.usoamic.wallet.values.R
import javafx.scene.layout.StackPane
import tornadofx.*

class DashboardView : BaseVmView<DashboardViewModel>(R.string.TITLE_DASHBOARD_SCREEN), RefreshableView {
    override val root: StackPane = stackpane {
        progressWhen {
            viewModel.ldProgress
        }
        vbox(R.dimen.DEFAULT_INDENT) {
            hiddenWhen { viewModel.ldProgress }

            paddingLeft = R.dimen.DEFAULT_INDENT
            paddingRight = R.dimen.DEFAULT_INDENT
            pane()

            informationItem(
                icon = FontAwesomeIcon.ASTERISK,
                title = R.string.TITLE_DASHBOARD_USO_BALANCE,
                message = viewModel.ldUsoBalance
            )

            informationItem(
                icon = FontAwesomeIcon.MODX,
                title = R.string.TITLE_DASHBOARD_ETH_BALANCE,
                message = viewModel.ldEthBalance
            )

            informationItem(
                icon = FontAwesomeIcon.CUBES,
                title = R.string.TITLE_DASHBOARD_HEIGHT,
                message = viewModel.ldHeight
            )

            informationItem(
                icon = FontAwesomeIcon.REFRESH,
                title = R.string.TITLE_DASHBOARD_SUPPLY,
                message = viewModel.ldSupply
            )
        }
    }

    override fun inject() {
        UsoamicWallet.component.dashboardSubcomponent.create().inject(this)
    }

    override fun onRefresh() {
        viewModel.onRefresh()
    }
}