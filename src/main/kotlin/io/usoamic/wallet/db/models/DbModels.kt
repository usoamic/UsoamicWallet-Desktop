package io.usoamic.wallet.db.models

data class DashboardInfoDb(
    var id: Long = 0,
    var ethBalance: String? = null,
    var usoBalance: String? = null,
    var height: String? = null,
    var supply: String? = null
)

data class TransactionItemDb(
    var txId: Long = 0,
    var type: String? = null,
    var from: String? = null,
    var to: String? = null,
    var value: String? = null,
    var timestamp: Long? = null
)