package io.usoamic.wallet.di.subcomponents.add

import dagger.Subcomponent
import io.usoamic.wallet.commons.scopes.AuthScope
import io.usoamic.wallet.ui.auth.add.AddView

@AuthScope
@Subcomponent
interface AddSubcomponent {
    fun inject(addView: AddView)

    @Subcomponent.Factory
    interface Factory {
        fun create(): AddSubcomponent
    }
}