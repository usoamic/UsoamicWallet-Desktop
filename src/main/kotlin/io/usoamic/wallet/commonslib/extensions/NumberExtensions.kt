package io.usoamic.wallet.commonslib.extensions

import java.math.BigDecimal
import java.math.BigInteger

fun BigInteger?.orZero() = this ?: BigInteger.ZERO

fun BigDecimal.toBeautyString(): String {
    return stripTrailingZeros().toPlainString()
}

fun BigInteger.toBeautyString(): String {
    return toString()
}