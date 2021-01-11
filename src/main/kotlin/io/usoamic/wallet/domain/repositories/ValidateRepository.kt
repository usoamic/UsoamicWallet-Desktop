package io.usoamic.wallet.domain.repositories

import io.reactivex.Completable

interface ValidateRepository {
    fun validatePasswords(password: String, confirmPassword: String): Completable
    fun validatePassword(password: String): Completable
    fun validatePrivateKey(privateKey: String): Completable
    fun validateAddress(address: String): Completable
    fun validateTransferValue(value: String): Completable
}