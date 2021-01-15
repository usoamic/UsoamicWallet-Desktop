package io.usoamic.wallet.commons.impl

import io.usoamic.wallet.commonslib.util.api.DateCompat
import java.time.LocalDateTime
import java.time.ZoneOffset

class DateCompatImpl : DateCompat {
    override val currentTimestamp: Long
        get() = LocalDateTime.now(ZoneOffset.UTC).toEpochSecond(ZoneOffset.UTC)
}