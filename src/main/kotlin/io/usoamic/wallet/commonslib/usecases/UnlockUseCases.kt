package io.usoamic.wallet.commonslib.usecases

import io.reactivex.Single
import io.usoamic.wallet.commonslib.repositories.EthereumRepository
import io.usoamic.wallet.commonslib.repositories.PreferencesRepository
import io.usoamic.wallet.commonslib.repositories.UserRepository
import io.usoamic.wallet.commonslib.repositories.ValidateRepository
import io.usoamic.wallet.commonslib.util.api.DateCompat
import java.time.LocalDateTime
import java.time.ZoneOffset
import javax.inject.Inject

class UnlockUseCases @Inject constructor(
    private val mValidateRepository: ValidateRepository,
    private val mEthereumRepository: EthereumRepository,
    private val mUserRepository: UserRepository,
    private val mPreferencesRepository: PreferencesRepository,
    private val mDateCompat: DateCompat
) {
    fun getAddress(password: String): Single<String> {
        return mValidateRepository.validatePassword(password)
            .andThen(
                mEthereumRepository.getAddress(password)
                    .map {
                        it
                    }
            )
    }

    fun saveData(address: String) {
        mPreferencesRepository.setAddress(address)
        mPreferencesRepository.setUnlockTime(mDateCompat.currentTimestamp)
    }

    fun removePreferences() = mPreferencesRepository.removeAll()

    fun removeAccount() = mUserRepository.removeAccount()
}