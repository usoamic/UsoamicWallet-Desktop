package io.usoamic.wallet.di

import dagger.Component
import io.usoamic.wallet.di.modules.RepositoryModule
import io.usoamic.wallet.di.modules.UsoamicModule
import io.usoamic.wallet.di.scopes.AppScope
import io.usoamic.wallet.di.subcomponents.add.AddSubcomponent
import io.usoamic.wallet.di.subcomponents.auth.AuthSubcomponent
import io.usoamic.wallet.di.subcomponents.create.CreateSubcomponent
import io.usoamic.wallet.di.subcomponents.dashboard.DashboardSubcomponent
import io.usoamic.wallet.di.subcomponents.deposit.DepositSubcomponent
import io.usoamic.wallet.di.subcomponents.history.HistorySubcomponent
import io.usoamic.wallet.di.subcomponents.withdraw.WithdrawSubcomponent
import io.usoamic.wallet.ui.start.StartView
import javax.inject.Singleton

@Singleton
@AppScope
@Component(modules = [UsoamicModule::class, RepositoryModule::class])
interface AppComponent {
    val authSubcomponent: AuthSubcomponent
    val addSubcomponent: AddSubcomponent.Factory

    val createSubcomponent: CreateSubcomponent.Factory
    val dashboardSubcomponent: DashboardSubcomponent.Factory
    val depositSubcomponent: DepositSubcomponent.Factory
    val withdrawSubcomponent: WithdrawSubcomponent.Factory
    val historySubcomponent: HistorySubcomponent.Factory

    fun inject(view: StartView)
}