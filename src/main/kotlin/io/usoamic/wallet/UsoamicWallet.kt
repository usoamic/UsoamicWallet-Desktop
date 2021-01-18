package io.usoamic.wallet

import io.usoamic.wallet.di.AppComponent
import io.usoamic.wallet.di.DaggerAppComponent
import io.usoamic.wallet.di.modules.UsoamicModule
import io.usoamic.wallet.other.Styles
import io.usoamic.wallet.ui.start.StartView
import javafx.stage.Stage
import tornadofx.App

class UsoamicWallet : App(StartView::class, Styles::class) {
    override fun start(stage: Stage) {
        component = buildDagger()
        super.start(stage)
    }

    private fun buildDagger(): AppComponent {
        return DaggerAppComponent
            .builder()
            .usoamicModule(UsoamicModule())
            .build()
    }

    companion object {
        lateinit var component: AppComponent
    }
}