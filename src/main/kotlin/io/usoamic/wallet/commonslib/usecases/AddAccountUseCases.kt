package io.usoamic.wallet.commonslib.usecases

import io.reactivex.Single
import io.usoamic.wallet.commonslib.models.add.AddAccountModel
import io.usoamic.wallet.commonslib.repositories.EthereumRepository
import io.usoamic.wallet.commonslib.repositories.ValidateRepository
import javax.inject.Inject

class AddAccountUseCases @Inject constructor(
    private val mValidateRepository: ValidateRepository,
    private val mEthereumRepository: EthereumRepository
) {
    fun addAccount(
        privateKey: String,
        password: String,
        confirmPassword: String
    ): Single<AddAccountModel> {
        return mValidateRepository.validatePrivateKey(privateKey)
            .andThen(
                mValidateRepository.validatePasswords(password, confirmPassword)
            )
            .andThen(
                mEthereumRepository.addAccount(privateKey, password)
            )
    }
}