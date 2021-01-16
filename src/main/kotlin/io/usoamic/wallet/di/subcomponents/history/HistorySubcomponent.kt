package io.usoamic.wallet.di.subcomponents.history

import dagger.Subcomponent
import io.usoamic.wallet.commonslib.di.scopes.WalletScope
import io.usoamic.wallet.ui.main.history.HistoryView

@WalletScope
@Subcomponent
interface HistorySubcomponent {
    fun inject(historyView: HistoryView)

    @Subcomponent.Factory
    interface Factory {
        fun create(): HistorySubcomponent
    }
}