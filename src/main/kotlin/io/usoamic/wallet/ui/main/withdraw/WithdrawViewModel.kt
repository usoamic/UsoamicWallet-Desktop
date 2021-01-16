package io.usoamic.wallet.ui.main.withdraw

import io.usoamic.wallet.commonslib.models.withdraw.WithdrawCoin
import io.usoamic.wallet.commonslib.usecases.WithdrawUseCases
import io.usoamic.wallet.extensions.addSchedulers
import io.usoamic.wallet.other.LiveEvent
import io.usoamic.wallet.ui.base.BaseViewModel
import javax.inject.Inject

class WithdrawViewModel @Inject constructor(
    private val mUseCases: WithdrawUseCases
) : BaseViewModel() {
    val leWithdraw = LiveEvent<String>()

    fun withdraw(
        coin: WithdrawCoin,
        password: String,
        to: String,
        value: String,
        gasPrice: String
    ) {
        mUseCases.withdraw(
            coin,
            password,
            to,
            value,
            gasPrice
        )
            .addSchedulers()
            .addProgress()
            .subscribe(::onWithdrawResult, ::throwError)
            .addToDisposable()
    }

    private fun onWithdrawResult(txHash: String) {
        leWithdraw.value = txHash
    }
}