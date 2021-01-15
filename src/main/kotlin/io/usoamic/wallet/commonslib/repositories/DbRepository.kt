package io.usoamic.wallet.commonslib.repositories

import io.usoamic.wallet.commonslib.models.dashboard.DashboardInfo
import io.usoamic.wallet.commonslib.models.history.TransactionItem

interface DbRepository {
    fun updateDashboardInfo(data: DashboardInfo)
    fun addTransactionItem(data: TransactionItem)

    fun getDashboardInfo(): DashboardInfo?
    fun getTransactions(): List<TransactionItem>
}