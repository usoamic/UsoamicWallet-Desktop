package io.usoamic.wallet.di.subcomponents.add

import dagger.Subcomponent
import io.usoamic.wallet.commonslib.di.scopes.AuthScope
import io.usoamic.wallet.ui.auth.add.AddView

//import io.usoamic.wallet.ui.auth.add.AddFragment

@AuthScope
@Subcomponent
interface AddSubcomponent {
    fun inject(addFragment: AddView)

    @Subcomponent.Factory
    interface Factory {
        fun create(): AddSubcomponent
    }
}