package io.usoamic.wallet.db.mappers

import io.usoamic.usoamickt.util.Coin
import io.usoamic.wallet.commonslib.models.dashboard.DashboardInfo
import io.usoamic.wallet.commonslib.models.history.TransactionItem
import io.usoamic.wallet.commonslib.models.history.TransactionType
import io.usoamic.wallet.db.models.DashboardInfoDb
import io.usoamic.wallet.db.models.TransactionItemDb
import java.math.BigDecimal
import java.math.BigInteger

/*
 * DashboardInfo
 */
fun DashboardInfoDb.toDomain() = DashboardInfo(
    ethBalance = BigDecimal(ethBalance!!),
    usoBalance = BigDecimal(usoBalance!!),
    height = BigInteger(height!!),
    supply = BigDecimal(supply!!)
)

fun DashboardInfo.toRealm() = DashboardInfoDb(
    ethBalance = ethBalance.toPlainString(),
    usoBalance = usoBalance.toPlainString(),
    height = height.toString(),
    supply = supply.toPlainString()
)

/*
 * TransactionItem
 */
fun TransactionItemDb.toDomain(): TransactionItem = TransactionItem(
    type = TransactionType.valueOf(type!!),
    txId = txId,
    from = from!!,
    to = to!!,
    value = Coin.fromCoin(value!!),
    timestamp = timestamp!!.toLong()
)

fun TransactionItem.toRealm(): TransactionItemDb = TransactionItemDb(
    type = type.toString(),
    txId = txId,
    from = from,
    to = to,
    value = value.toBigDecimal().toPlainString(),
    timestamp = timestamp
)