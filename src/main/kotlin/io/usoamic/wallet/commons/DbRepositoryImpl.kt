package io.usoamic.wallet.commons

import io.usoamic.wallet.commons.models.dashboard.DashboardInfo
import io.usoamic.wallet.commons.models.history.TransactionItem
import io.usoamic.wallet.commons.repositories.DbRepository
import io.usoamic.wallet.database.Database
import javax.inject.Inject

class DbRepositoryImpl @Inject constructor(
    private val db: Database
) : DbRepository {
    private val dbQueries get() = db.databaseQueries

    override fun updateDashboardInfo(data: DashboardInfo) {
        dbQueries.setDashboardInfo(
            ethBalance = data.ethBalance.toPlainString(),
            usoBalance = data.usoBalance.toPlainString(),
            height = data.height.toString(),
            supply = data.supply.toPlainString()
        )
    }

    override fun addTransactionItem(data: TransactionItem) = with(dbQueries) {
        val txId = data.txId
        val transaction = getTransaction(txId).executeAsOneOrNull()

        if(transaction == null) {
            addTransaction(
                txId = txId,
                type = data.type.toString(),
                fromAddress = data.from,
                toAddress = data.to,
                value = data.value.toBigDecimal().toPlainString(),
                timestamp = data.timestamp
            )
        }
    }

    override fun getDashboardInfo(): DashboardInfo? {
        return dbQueries.getDashboardInfo().executeAsOneOrNull()?.toDomain()
    }

    override fun getTransactions(): List<TransactionItem> {
        return dbQueries.getTransactions().executeAsList().map {
            it.toDomain()
        }
    }
}