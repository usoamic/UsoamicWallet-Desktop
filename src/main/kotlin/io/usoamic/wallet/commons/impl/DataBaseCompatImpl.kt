package io.usoamic.wallet.commons.impl

import io.usoamic.wallet.commonslib.util.api.DataBaseCompat
import javax.inject.Inject

class DataBaseCompatImpl @Inject constructor() : DataBaseCompat {
    override fun <T> update(data: T) {
        TODO("Not yet implemented")
    }

    override fun <T> add(data: T) {
        TODO("Not yet implemented")
    }

    override fun <T> getFirst(cls: Class<T>): T? {
        TODO("Not yet implemented")
    }

    override fun <T> getAll(cls: Class<T>): List<T> {
        TODO("Not yet implemented")
    }
}