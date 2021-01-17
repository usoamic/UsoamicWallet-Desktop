package io.usoamic.wallet.commons

import io.usoamic.wallet.commons.models.dashboard.DashboardInfo
import io.usoamic.wallet.commons.models.history.TransactionItem
import io.usoamic.wallet.commons.repositories.DbRepository
import io.usoamic.wallet.database.Database
import javax.inject.Inject

class DbRepositoryImpl @Inject constructor(
    private val db: Database
) : DbRepository {
    override fun updateDashboardInfo(data: DashboardInfo) {
        db.databaseQueries.setDashboardInfo(
            ethBalance = data.ethBalance.toPlainString(),
            usoBalance = data.ethBalance.toPlainString(),
            height = data.height.toString(),
            supply = data.supply.toPlainString()
        )
    }

    override fun addTransactionItem(data: TransactionItem) {
        db.databaseQueries.addTransaction(
            txId = data.txId,
            type = data.type.toString(),
            fromAddress = data.from,
            toAddress = data.to,
            value = data.value.toBigDecimal().toPlainString(),
            timestamp = data.timestamp
        )
    }

    override fun getDashboardInfo(): DashboardInfo? {
        return db.databaseQueries.getDashboardInfo().executeAsOneOrNull()?.toDomain()
    }

    override fun getTransactions(): List<TransactionItem> {
        return db.databaseQueries.getTransactions().executeAsList().map {
            it.toDomain()
        }
    }
}