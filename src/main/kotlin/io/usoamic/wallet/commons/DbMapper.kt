package io.usoamic.wallet.commons

import io.usoamic.usoamickt.util.Coin
import io.usoamic.wallet.commons.models.dashboard.DashboardInfo
import io.usoamic.wallet.commons.models.history.TransactionItem
import io.usoamic.wallet.commons.models.history.TransactionType
import io.usoamic.wallet.database.DashboardInfoEntity
import io.usoamic.wallet.database.TransactionItemEntity
import java.math.BigDecimal
import java.math.BigInteger

fun DashboardInfoEntity.toDomain(): DashboardInfo = DashboardInfo(
    ethBalance = BigDecimal(ethBalance),
    usoBalance = BigDecimal(usoBalance),
    height = BigInteger(height),
    supply = BigDecimal(supply)
)

fun TransactionItemEntity.toDomain(): TransactionItem = TransactionItem(
    type = TransactionType.valueOf(type),
    txId = txId,
    from = fromAddress,
    to = toAddress,
    value = Coin.fromCoin(value),
    timestamp = timestamp.toLong()
)