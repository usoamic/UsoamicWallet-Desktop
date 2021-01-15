package io.usoamic.wallet.commonslib.extensions

import java.math.BigInteger

fun BigInteger?.orZero() = this ?: BigInteger.ZERO