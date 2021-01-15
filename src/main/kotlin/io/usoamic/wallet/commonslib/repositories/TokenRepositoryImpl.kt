package io.usoamic.wallet.commonslib.repositories

import io.reactivex.Single
import io.usoamic.usoamickt.core.Usoamic
import io.usoamic.usoamickt.model.Transaction
import io.usoamic.usoamickt.util.Coin
import io.usoamic.wallet.commonslib.models.history.TransactionItem
import io.usoamic.wallet.commonslib.models.history.toDomain
import io.usoamic.wallet.commonslib.models.withdraw.WithdrawData
import io.usoamic.wallet.exceptions.ContractNullException
import io.usoamic.wallet.exceptions.orZero
import io.usoamic.wallet.extensions.addDebugDelay
import java.math.BigDecimal
import java.math.BigInteger
import javax.inject.Inject

class TokenRepositoryImpl @Inject constructor(
    private val usoamic: Usoamic
) : TokenRepository {
    private val address = usoamic.address

    override val usoBalance: Single<BigDecimal>
        get() {
            return Single.fromCallable {
                usoamic.getUsoBalance().toCoin()
            }
                .addDebugDelay()
        }

    override val usoSupply: Single<BigDecimal>
        get() {
            return Single.fromCallable {
                usoamic.getSupply().toCoin()
            }
                .addDebugDelay()
        }

    override val numberOfUserTransactions: Single<BigInteger>
        get() {
            return Single.fromCallable {
                usoamic.getNumberOfTransactionsByAddress(usoamic.address).orZero()
            }.addDebugDelay()
        }

    override fun getTransaction(txId: BigInteger): Single<Transaction> {
        return Single.fromCallable {
            usoamic.getTransaction(txId)
        }.addDebugDelay()
    }

    override fun getTransactionForAccount(txId: BigInteger): Single<TransactionItem> {
        return Single.fromCallable {
            usoamic.getTransactionByAddress(usoamic.address, txId)
        }.map {
            it.toDomain(address)
        }
        // .addDebugDelay()
    }

    override fun withdraw(data: WithdrawData): Single<String> {
        return Single.fromCallable {
            val value = Coin.fromCoin(data.value).toSat()
            usoamic.transferUso(
                password = data.password,
                to = data.to,
                value = value,
                txSpeed = data.txSpeed
            )
        }
            .addDebugDelay()
    }

    private fun BigInteger?.toCoin(): BigDecimal {
        return this?.let {
            Coin.fromSat(it).toBigDecimal()
        } ?: throw ContractNullException("mapToCoin()")
    }
}