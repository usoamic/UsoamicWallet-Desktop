package io.usoamic.wallet.commonslib.repositories

import io.usoamic.wallet.commonslib.models.dashboard.DashboardInfo
import io.usoamic.wallet.commonslib.models.history.TransactionItem
import io.usoamic.wallet.commonslib.util.api.DataBaseCompat
import javax.inject.Inject


class DbRepositoryImpl @Inject constructor(
    private val mDbCompat: DataBaseCompat
) : DbRepository {
    override fun updateDashboardInfo(data: DashboardInfo) {
        mDbCompat.update(data)
    }

    override fun addTransactionItem(data: TransactionItem) {
        mDbCompat.add(data)
    }

    override fun getDashboardInfo(): DashboardInfo? {
        return mDbCompat.getFirst(DashboardInfo::class.java)
    }

    override fun getTransactions(): List<TransactionItem> {
        return mDbCompat.getAll(TransactionItem::class.java)
    }
}