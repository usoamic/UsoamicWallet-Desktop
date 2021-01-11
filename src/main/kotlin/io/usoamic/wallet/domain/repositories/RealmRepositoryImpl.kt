package io.usoamic.wallet.domain.repositories

import io.usoamic.wallet.domain.models.database.DashboardInfoDb
import io.usoamic.wallet.domain.models.database.TransactionItemDb
import javax.inject.Inject


class RealmRepositoryImpl @Inject constructor() : RealmRepository {
    override fun updateDashboardInfo(data: DashboardInfoDb) = Unit

    override fun addTransactionItem(data: TransactionItemDb) = Unit

    override fun getDashboardInfo(): DashboardInfoDb? = null

    override fun getTransactions(): List<TransactionItemDb> = listOf()
}