package io.usoamic.wallet.di.modules

import dagger.Binds
import dagger.Module
import io.usoamic.wallet.commons.DateCompatImpl
import io.usoamic.wallet.commons.PreferencesCompatImpl
import io.usoamic.wallet.commons.api.DateCompat
import io.usoamic.wallet.commons.api.PreferencesCompat

@Module
abstract class CompatModule {
    @Binds
    abstract fun bindPreferencesCompat(repository: PreferencesCompatImpl): PreferencesCompat

    @Binds
    abstract fun bindDateCompat(repository: DateCompatImpl): DateCompat
}