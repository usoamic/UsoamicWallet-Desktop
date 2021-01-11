package io.usoamic.wallet.ui.start

import io.usoamic.wallet.ui.base.BaseViewModel
import io.usoamic.wallet.usecases.StartUseCases
import javax.inject.Inject

class StartViewModel @Inject constructor(
    private val mStartUseCases: StartUseCases
) : BaseViewModel() {
    fun run() {
        println("hasAccount: ${mStartUseCases.hasAccount().blockingGet()}")

    }
}