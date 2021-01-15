package io.usoamic.wallet.commonslib.util.api

import io.usoamic.wallet.commonslib.models.dashboard.DashboardInfo
import io.usoamic.wallet.commonslib.models.history.TransactionItem

interface DataBaseCompat {
    fun <T> update(data: T)
    fun <T> add(data: T)
    fun <T> getFirst(cls: Class<T>): T?
    fun <T> getAll(cls: Class<T>): List<T>
}