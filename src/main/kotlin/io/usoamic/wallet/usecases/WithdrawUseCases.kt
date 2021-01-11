package io.usoamic.wallet.usecases

import io.reactivex.Single
import io.usoamic.usoamickt.enumcls.TxSpeed
import io.usoamic.wallet.domain.models.withdraw.WithdrawCoin
import io.usoamic.wallet.domain.models.withdraw.WithdrawData
import io.usoamic.wallet.domain.repositories.EthereumRepository
import io.usoamic.wallet.domain.repositories.TokenRepository
import io.usoamic.wallet.domain.repositories.ValidateRepository
import java.math.BigDecimal
import javax.inject.Inject

class WithdrawUseCases @Inject constructor(
    private val mValidateRepository: ValidateRepository,
    private val mTokenRepository: TokenRepository,
    private val mEthereumRepository: EthereumRepository
) {
    fun withdraw(
        coin: WithdrawCoin,
        password: String,
        to: String,
        value: String,
        txSpeed: String
    ): Single<String> {
        return mValidateRepository.validatePassword(password)
            .andThen(mValidateRepository.validateAddress(to))
            .andThen(mValidateRepository.validateTransferValue(value))
            .andThen(
                Single.defer {
                    val data = WithdrawData(
                        password = password,
                        to = to,
                        value = BigDecimal(value),
                        txSpeed = TxSpeed.parseString(txSpeed)
                    )
                    when (coin) {
                        WithdrawCoin.ETH -> {
                            mEthereumRepository.withdraw(data)
                        }
                        WithdrawCoin.USO -> {
                            mTokenRepository.withdraw(data)
                        }
                    }
                }
            )
    }
}