package io.usoamic.wallet.domain.repositories

import io.usoamic.wallet.domain.models.database.DashboardInfoDb
import io.usoamic.wallet.domain.models.database.TransactionItemDb

interface RealmRepository {
    fun updateDashboardInfo(data: DashboardInfoDb)
    fun addTransactionItem(data: TransactionItemDb)

    fun getDashboardInfo(): DashboardInfoDb?
    fun getTransactions(): List<TransactionItemDb>
}