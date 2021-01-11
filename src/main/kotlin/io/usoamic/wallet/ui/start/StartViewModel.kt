package io.usoamic.wallet.ui.start

import io.usoamic.wallet.domain.repositories.EthereumRepository
import io.usoamic.wallet.extensions.observeOnMain
import io.usoamic.wallet.extensions.subscribeOnIo
import io.usoamic.wallet.other.MutableLiveData
import io.usoamic.wallet.ui.base.BaseViewModel
import io.usoamic.wallet.usecases.StartUseCases
import javax.inject.Inject

class StartViewModel @Inject constructor(
    private val mStartUseCases: StartUseCases,
    private val mEthereumRepository: EthereumRepository
) : BaseViewModel() {
    val idProperty = MutableLiveData<Int>(0)

    fun run() {
        //Fix this, return only old variable
        mEthereumRepository.ethHeight
            .subscribeOnIo()
            .observeOnMain()
            .addProgress()
            .subscribe({
                idProperty.value = it.toInt()
            }, {
                it.printStackTrace()
            })
            .addToDisposable()
    }
}