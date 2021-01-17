package io.usoamic.wallet.di.subcomponents.withdraw

import dagger.Subcomponent
import io.usoamic.wallet.commons.di.scopes.WalletScope
import io.usoamic.wallet.ui.main.withdraw.WithdrawView

@WalletScope
@Subcomponent
interface WithdrawSubcomponent {
    fun inject(withdrawView: WithdrawView)

    @Subcomponent.Factory
    interface Factory {
        fun create(): WithdrawSubcomponent
    }
}