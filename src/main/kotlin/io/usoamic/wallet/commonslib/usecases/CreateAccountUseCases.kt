package io.usoamic.wallet.commonslib.usecases

import io.reactivex.Single
import io.usoamic.wallet.commonslib.models.ethereum.AccountCredentials
import io.usoamic.wallet.commonslib.repositories.EthereumRepository
import javax.inject.Inject

class CreateAccountUseCases @Inject constructor(
    private val mEthereumRepository: EthereumRepository
) {
    fun createCredentials(): Single<AccountCredentials> = mEthereumRepository.createCredentials()
}