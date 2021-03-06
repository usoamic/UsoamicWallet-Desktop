package io.usoamic.wallet.ui.start

import io.usoamic.wallet.commons.usecases.StartUseCases
import io.usoamic.wallet.extensions.addSchedulers
import io.usoamic.wallet.other.MutableLiveData
import io.usoamic.wallet.ui.base.BaseViewModel
import javax.inject.Inject

class StartViewModel @Inject constructor(
    private val mStartUseCases: StartUseCases
) : BaseViewModel() {
    val ldHasAccount = MutableLiveData<Boolean>()

    init {
        checkAccount()
    }

    private fun checkAccount() {
        mStartUseCases.hasAccount()
            .addSchedulers()
            .subscribe({
                ldHasAccount.value = it
            }, ::throwErrorAndFinish)
            .addToDisposable()
    }
}