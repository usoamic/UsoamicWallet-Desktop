package io.usoamic.wallet.domain.repositories

interface PreferencesRepository {
    fun getAddress(): String
    fun setAddress(address: String)
    fun remove(key: String)
    fun removeAll()
}