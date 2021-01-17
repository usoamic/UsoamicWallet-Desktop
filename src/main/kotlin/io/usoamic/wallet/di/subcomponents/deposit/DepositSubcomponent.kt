package io.usoamic.wallet.di.subcomponents.deposit

import dagger.Subcomponent
import io.usoamic.wallet.commons.di.scopes.WalletScope
import io.usoamic.wallet.ui.main.deposit.DepositView

@WalletScope
@Subcomponent
interface DepositSubcomponent {
   fun inject(depositView: DepositView)

    @Subcomponent.Factory
    interface Factory {
        fun create(): DepositSubcomponent
    }
}