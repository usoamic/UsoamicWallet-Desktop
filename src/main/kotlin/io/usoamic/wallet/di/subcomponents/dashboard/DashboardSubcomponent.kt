package io.usoamic.wallet.di.subcomponents.dashboard

import dagger.Subcomponent
import io.usoamic.wallet.commonslib.di.scopes.WalletScope
//import io.usoamic.wallet.ui.main.dashboard.DashboardFragment

@WalletScope
@Subcomponent
interface DashboardSubcomponent {
    @Subcomponent.Factory
    interface Factory {
        fun create(): DashboardSubcomponent
    }
}