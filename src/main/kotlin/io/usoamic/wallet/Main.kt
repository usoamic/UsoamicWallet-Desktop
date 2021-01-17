package io.usoamic.wallet

import io.usoamic.wallet.commons.Config
import io.usoamic.wallet.util.BuildConfig
import tornadofx.launch

object Main {
    @JvmStatic
    fun main(args: Array<String>) {
        Config.DEBUG = BuildConfig.DEBUG
        launch<UsoamicWallet>(args)
    }
}