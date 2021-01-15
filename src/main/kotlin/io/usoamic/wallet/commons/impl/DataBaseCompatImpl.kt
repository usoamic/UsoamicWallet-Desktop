package io.usoamic.wallet.commons.impl

import io.usoamic.wallet.commonslib.util.api.DataBaseCompat
import javax.inject.Inject

class DataBaseCompatImpl @Inject constructor() : DataBaseCompat {
    override fun <T> update(data: T) = Unit

    override fun <T> add(data: T) = Unit

    override fun <T> getFirst(cls: Class<T>): T? {
        return null
    }

    override fun <T> getAll(cls: Class<T>): List<T> = listOf()
}