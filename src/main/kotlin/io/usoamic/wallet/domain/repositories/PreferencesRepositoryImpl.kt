package io.usoamic.wallet.domain.repositories

import io.usoamic.wallet.exceptions.PreferenceKeyNotFoundException
import io.usoamic.wallet.util.PreferenceKey
import java.util.prefs.Preferences
import javax.inject.Inject

class PreferencesRepositoryImpl @Inject constructor() : PreferencesRepository {
    private val preferences: Preferences by lazy {
        Preferences.userNodeForPackage(this::class.java)
    }

    override fun getAddress(): String = getString(PreferenceKey.ADDRESS)

    override fun setAddress(address: String) = setString(PreferenceKey.ADDRESS, address)

    override fun removeAll() {
        preferences.removeNode()
    }

    private fun getString(key: String): String {
        preferences.get(key, null)?.let {
            return it
        } ?: run {
            throw PreferenceKeyNotFoundException(key)
        }
    }

    private fun getLong(key: String): Long {
        val long = preferences.getLong(key, -1L)
        if (long == -1L) {
            throw PreferenceKeyNotFoundException(key)
        }
        return long
    }

    private fun setString(key: String, value: String) {
        preferences.put(key, value)
    }

    private fun setLong(key: String, value: Long) {
        preferences.putLong(key, value)
    }

    override fun remove(key: String) {
        preferences.remove(key)
    }
}