package io.usoamic.wallet.commonslib.models.dashboard

import io.usoamic.wallet.db.models.DashboardInfoDb
import java.math.BigDecimal
import java.math.BigInteger

@Deprecated("Move to separate library")
data class DashboardInfo(
    val ethBalance: BigDecimal,
    val usoBalance: BigDecimal,
    val height: BigInteger,
    val supply: BigDecimal
) {
    companion object {
        val DEFAULT = DashboardInfo(
            BigDecimal(111),
            BigDecimal(222),
            BigInteger.valueOf(333),
            BigDecimal(444)
        )
    }
}

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