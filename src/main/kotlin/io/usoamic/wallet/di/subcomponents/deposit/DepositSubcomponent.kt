package io.usoamic.wallet.di.subcomponents.deposit

import dagger.Subcomponent
import io.usoamic.wallet.commonslib.di.scopes.WalletScope

@WalletScope
@Subcomponent
interface DepositSubcomponent {
   // fun inject(depositFragment: DepositFragment)

    @Subcomponent.Factory
    interface Factory {
        fun create(): DepositSubcomponent
    }
}