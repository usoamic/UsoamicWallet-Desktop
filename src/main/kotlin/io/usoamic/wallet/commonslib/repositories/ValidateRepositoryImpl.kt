package io.usoamic.wallet.commonslib.repositories

import io.reactivex.Completable
import io.usoamic.validateutilkt.ValidateUtil
import io.usoamic.wallet.extensions.addDebugDelay
import javax.inject.Inject

class ValidateRepositoryImpl @Inject constructor() : ValidateRepository {
    override fun validatePasswords(password: String, confirmPassword: String): Completable {
        return Completable.fromAction {
            ValidateUtil.validatePasswords(password, confirmPassword)
        }.addDebugDelay()
    }

    override fun validatePassword(password: String): Completable {
        return Completable.fromAction {
            ValidateUtil.validatePassword(password)
        }.addDebugDelay()
    }

    override fun validatePrivateKey(privateKey: String): Completable {
        return Completable.fromAction {
            ValidateUtil.validatePrivateKey(privateKey)
        }.addDebugDelay()
    }

    override fun validateTransferValue(value: String): Completable {
        return Completable.fromAction {
            ValidateUtil.validateTransferValue(value)
        }.addDebugDelay()
    }

    override fun validateAddress(address: String): Completable {
        return Completable.fromAction {
            ValidateUtil.validateAddress(address)
        }.addDebugDelay()
    }
}