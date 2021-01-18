package io.usoamic.wallet.ui.main.dashboard

import io.usoamic.wallet.commons.extensions.toBeautyString
import io.usoamic.wallet.commons.models.dashboard.DashboardInfo
import io.usoamic.wallet.commons.usecases.DashboardUseCases
import io.usoamic.wallet.extensions.addSchedulers
import io.usoamic.wallet.other.MutableLiveData
import io.usoamic.wallet.ui.base.BaseViewModel
import javax.inject.Inject

class DashboardViewModel @Inject constructor(
    private val mDashboardUseCases: DashboardUseCases
) : BaseViewModel() {
    val ldEthBalance = MutableLiveData<String>()
    val ldUsoBalance = MutableLiveData<String>()
    val ldHeight = MutableLiveData<String>()
    val ldSupply = MutableLiveData<String>()

    init {
        updateInfo()
    }

    private fun updateInfo(force: Boolean = false) {
        mDashboardUseCases.getDashboardInfo(force)
            .addSchedulers()
            .addProgress()
            .subscribe(::onResult, ::throwError)
            .addToDisposable()
    }

    private fun onResult(data: DashboardInfo) {
        ldUsoBalance.value = data.usoBalance.toBeautyString()
        ldEthBalance.value = data.ethBalance.toBeautyString()
        ldHeight.value = data.height.toBeautyString()
        ldSupply.value = data.supply.toBeautyString()
    }

    fun onRefresh() = updateInfo(true)
}