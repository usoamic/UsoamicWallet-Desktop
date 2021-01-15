package io.usoamic.wallet.commonslib.usecases

import io.reactivex.Single
import io.usoamic.wallet.commonslib.repositories.UserRepository
import javax.inject.Inject

class StartUseCases @Inject constructor(
    private val mUserRepository: UserRepository
) {
    fun hasAccount(): Single<Boolean> {
        return mUserRepository.hasAccount()
    }
}