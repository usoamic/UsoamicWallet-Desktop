package io.usoamic.wallet.commons

import io.usoamic.wallet.commons.api.DateCompat
import java.time.LocalDateTime
import java.time.ZoneOffset
import javax.inject.Inject

class DateCompatImpl @Inject constructor() : DateCompat {
    override val currentTimestamp: Long
        get() = LocalDateTime.now(ZoneOffset.UTC).toEpochSecond(ZoneOffset.UTC)
}