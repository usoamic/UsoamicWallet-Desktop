package io.usoamic.wallet.ui.auth.add

import io.usoamic.wallet.commons.usecases.AddAccountUseCases
import io.usoamic.wallet.extensions.addSchedulers
import io.usoamic.wallet.extensions.emit
import io.usoamic.wallet.other.LiveEvent
import io.usoamic.wallet.ui.base.BaseViewModel
import javax.inject.Inject

class AddViewModel @Inject constructor(
    private val mModel: AddAccountUseCases
) : BaseViewModel() {
    val leAccountAdd = LiveEvent<Unit>()

    fun onAddClick(privateKey: String, password: String, confirmPassword: String) {
        mModel.addAccount(privateKey, password, confirmPassword)
            .addSchedulers()
            .addProgress()
            .subscribe({
                leAccountAdd.emit()
            }, ::throwError)
            .addToDisposable()
    }
}