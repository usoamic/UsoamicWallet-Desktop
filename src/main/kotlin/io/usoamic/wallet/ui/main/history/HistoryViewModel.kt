package io.usoamic.wallet.ui.main.history

import io.usoamic.wallet.commons.models.history.TransactionItem
import io.usoamic.wallet.commons.usecases.HistoryUseCases
import io.usoamic.wallet.extensions.addSchedulers
import io.usoamic.wallet.other.MutableLiveData
import io.usoamic.wallet.ui.base.BaseViewModel
import javax.inject.Inject

class HistoryViewModel @Inject constructor(
    private val mUseCases: HistoryUseCases
) : BaseViewModel() {
    val ldData = MutableLiveData<List<TransactionItem>>()

    init {
        updateTransactions()
    }

    fun onRefresh() = updateTransactions(true)

    private fun updateTransactions(force: Boolean = false) {
        mUseCases.getTransactions(force)
            .addSchedulers()
            .addProgress()
            .subscribe(::setHistory, ::throwError)
            .addToDisposable()
    }

    private fun setHistory(list: List<TransactionItem>) {
        ldData.value = list
    }
}