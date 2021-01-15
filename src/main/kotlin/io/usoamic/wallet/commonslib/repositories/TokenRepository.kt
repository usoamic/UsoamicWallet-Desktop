package io.usoamic.wallet.commonslib.repositories

import io.reactivex.Single
import io.usoamic.usoamickt.model.Transaction
import io.usoamic.wallet.commonslib.models.history.TransactionItem
import io.usoamic.wallet.commonslib.models.withdraw.WithdrawData
import java.math.BigDecimal
import java.math.BigInteger

interface TokenRepository {
    val usoBalance: Single<BigDecimal>
    val usoSupply: Single<BigDecimal>
    val numberOfUserTransactions: Single<BigInteger>
    fun getTransaction(
        txId: BigInteger
    ): Single<Transaction>

    fun getTransactionForAccount(
        txId: BigInteger
    ): Single<TransactionItem>

    fun withdraw(
        data: WithdrawData
    ): Single<String>
}