package io.usoamic.wallet.di.subcomponents.dashboard

import dagger.Subcomponent
import io.usoamic.wallet.commons.di.scopes.WalletScope
import io.usoamic.wallet.ui.main.dashboard.DashboardView

@WalletScope
@Subcomponent
interface DashboardSubcomponent {
    fun inject(dashboardView: DashboardView)

    @Subcomponent.Factory
    interface Factory {
        fun create(): DashboardSubcomponent
    }
}