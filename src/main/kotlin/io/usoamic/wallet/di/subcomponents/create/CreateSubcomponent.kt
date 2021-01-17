package io.usoamic.wallet.di.subcomponents.create

import dagger.Subcomponent
import io.usoamic.wallet.commons.scopes.AuthScope
import io.usoamic.wallet.ui.auth.create.CreateView

@AuthScope
@Subcomponent
interface CreateSubcomponent {
    fun inject(createView: CreateView)

    @Subcomponent.Factory
    interface Factory {
        fun create(): CreateSubcomponent
    }
}