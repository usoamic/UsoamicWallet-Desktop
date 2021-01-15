package io.usoamic.wallet.di.modules

import dagger.Binds
import dagger.Module
import io.usoamic.wallet.commons.impl.DataBaseCompatImpl
import io.usoamic.wallet.commons.impl.DateCompatImpl
import io.usoamic.wallet.commons.impl.PreferencesCompatImpl
import io.usoamic.wallet.commonslib.util.api.DataBaseCompat
import io.usoamic.wallet.commonslib.util.api.DateCompat
import io.usoamic.wallet.commonslib.util.api.PreferencesCompat

@Module
abstract class CompatModule {
    @Binds
    abstract fun bindPreferencesCompat(repository: PreferencesCompatImpl): PreferencesCompat

    @Binds
    abstract fun bindDateCompat(repository: DateCompatImpl): DateCompat

    @Binds
    abstract fun bindDataBaseCompat(repository: DataBaseCompatImpl): DataBaseCompat
}