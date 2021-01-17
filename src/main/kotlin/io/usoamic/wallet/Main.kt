package io.usoamic.wallet

import tornadofx.launch

object Main {
    @JvmStatic
    fun main(args: Array<String>) {
        launch<UsoamicWallet>(args)
    }
}