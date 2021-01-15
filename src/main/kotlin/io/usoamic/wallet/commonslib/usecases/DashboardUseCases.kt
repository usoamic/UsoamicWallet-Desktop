package io.usoamic.wallet.commonslib.usecases

import io.reactivex.Single
import io.reactivex.functions.Function4
import io.usoamic.wallet.commonslib.models.dashboard.DashboardInfo
import io.usoamic.wallet.commonslib.models.dashboard.toRealm
import io.usoamic.wallet.commonslib.repositories.EthereumRepository
import io.usoamic.wallet.commonslib.repositories.DbRepository
import io.usoamic.wallet.commonslib.repositories.TokenRepository
import java.math.BigDecimal
import java.math.BigInteger
import javax.inject.Inject

class DashboardUseCases @Inject constructor(
    private val mTokenRepository: TokenRepository,
    private val mEthereumRepository: EthereumRepository,
    private val mDbRepository: DbRepository
) {
    fun getDashboardInfo(forceUpdate: Boolean): Single<DashboardInfo> {
        return if(forceUpdate) {
            getDashboardInfoFromNetwork()
        }
        else {
            getDashboardInfoFromRealm()
        }
    }

    private fun getDashboardInfoFromRealm(): Single<DashboardInfo> {
        return mDbRepository.getDashboardInfo()?.let {
            Single.just(it)
        } ?: getDashboardInfoFromNetwork()
    }

    private fun getDashboardInfoFromNetwork(): Single<DashboardInfo> {
        return Single.zip(
            mEthereumRepository.ethBalance,
            mTokenRepository.usoBalance,
            mEthereumRepository.ethHeight,
            mTokenRepository.usoSupply,
            Function4 { ethBalance: BigDecimal, usoBalance: BigDecimal, ethHeight: BigInteger, usoSupply: BigDecimal ->
                DashboardInfo(
                    ethBalance,
                    usoBalance,
                    ethHeight,
                    usoSupply
                )
            }
        )
            .map {
                mDbRepository.updateDashboardInfo(it)
                it
            }
    }
}