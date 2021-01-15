package io.usoamic.wallet.commons.impl

import io.usoamic.wallet.commonslib.util.api.DateCompat
import java.time.LocalDateTime
import java.time.ZoneOffset
import javax.inject.Inject

class DateCompatImpl @Inject constructor()  : DateCompat {
    override val currentTimestamp: Long
        get() = LocalDateTime.now(ZoneOffset.UTC).toEpochSecond(ZoneOffset.UTC)
}