package io.usoamic.wallet.di.modules

import dagger.Module
import dagger.Provides
import io.usoamic.usoamickt.core.Usoamic
import io.usoamic.usoamickt.enumcls.NetworkType
import io.usoamic.usoamickt.enumcls.NodeProvider
import io.usoamic.usoamickt.util.DirectoryUtils
import io.usoamic.wallet.util.BuildConfig
import javax.inject.Singleton

@Module
class UsoamicModule {
    @Provides
    @Singleton
    fun provideContract(): Usoamic {
        return Usoamic(
            fileName = BuildConfig.ACCOUNT_FILENAME,
            filePath = DirectoryUtils.getDefaultKeyDirectory(),
            networkType = NetworkType.valueOf(BuildConfig.FLAVOR),
            nodeProvider = NodeProvider.valueOf(
                BuildConfig.NODE_PROVIDER,
                BuildConfig.PROJECT_ID
            )
        )
    }
}