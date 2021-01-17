package io.usoamic.wallet.ui.auth.create

import io.usoamic.wallet.commons.models.ethereum.AccountCredentials
import io.usoamic.wallet.commons.usecases.CreateAccountUseCases
import io.usoamic.wallet.extensions.addSchedulers
import io.usoamic.wallet.other.MutableLiveData
import io.usoamic.wallet.ui.base.BaseViewModel
import javax.inject.Inject

class CreateViewModel @Inject constructor(
    mModel: CreateAccountUseCases
) : BaseViewModel() {
    val ldAddress = MutableLiveData<String>()
    val ldPrivateKey = MutableLiveData<String>()

    init {
        mModel.createCredentials()
            .addSchedulers()
            .addProgress()
            .subscribe(::setContent, ::throwErrorAndFinish)
            .addToDisposable()
    }

    private fun setContent(credentials: AccountCredentials) {
        ldAddress.value = credentials.address
        ldPrivateKey.value = credentials.privateKey
    }
}