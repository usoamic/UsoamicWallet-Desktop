package io.usoamic.wallet.di.subcomponents.history

import dagger.Subcomponent
import io.usoamic.wallet.commonslib.di.scopes.WalletScope

@WalletScope
@Subcomponent
interface HistorySubcomponent {
   // fun inject(historyFragment: HistoryFragment)

    @Subcomponent.Factory
    interface Factory {
        fun create(): HistorySubcomponent
    }
}