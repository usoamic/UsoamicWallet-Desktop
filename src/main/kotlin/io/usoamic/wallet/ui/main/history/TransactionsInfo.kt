package io.usoamic.wallet.ui.main.history

import io.usoamic.wallet.commonslib.extensions.toBeautyString
import io.usoamic.wallet.commonslib.models.history.TransactionItem
import io.usoamic.wallet.commonslib.models.history.TransactionType
import io.usoamic.wallet.values.R
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter

data class TransactionsInfo(
    val id: String,
    val type: String,
    val address: String,
    val amount: String,
    val date: String
)

fun TransactionItem.toInfo(id: Int, formatter: DateTimeFormatter): TransactionsInfo {
    return TransactionsInfo(
        id = id.toString(),
        type = type.toString().toLowerCase().capitalize(),
        address = when (type) {
            TransactionType.DEPOSIT -> from
            TransactionType.WITHDRAW -> to
        },
        amount = value.toBeautyString(R.string.TICKER),
        date = formatter.format(
            LocalDateTime.ofInstant(
                Instant.ofEpochMilli(timestamp * 1000L),
                ZoneId.systemDefault()
            )
        )
    )
}