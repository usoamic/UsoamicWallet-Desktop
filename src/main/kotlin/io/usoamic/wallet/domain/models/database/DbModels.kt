package io.usoamic.wallet.domain.models.database


@Deprecated("Make interface for compatibility with Android")
open class DashboardInfoDb(
    var id: Long = 0,
    var ethBalance: String? = null,
    var usoBalance: String? = null,
    var height: String? = null,
    var supply: String? = null
)

@Deprecated("Make interface for compatibility with Android")
open class TransactionItemDb(
    var txId: Long = 0,
    var type: String? = null,
    var from: String? = null,
    var to: String? = null,
    var value: String? = null,
    var timestamp: Long? = null
)