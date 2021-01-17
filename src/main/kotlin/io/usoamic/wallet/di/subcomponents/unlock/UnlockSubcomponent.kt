package io.usoamic.wallet.di.subcomponents.unlock

import dagger.Subcomponent
import io.usoamic.wallet.commons.scopes.AuthScope
import io.usoamic.wallet.ui.auth.unlock.UnlockView

@AuthScope
@Subcomponent
interface UnlockSubcomponent {
    fun inject(unlockView: UnlockView)

    @Subcomponent.Factory
    interface Factory {
        fun create(): UnlockSubcomponent
    }
}