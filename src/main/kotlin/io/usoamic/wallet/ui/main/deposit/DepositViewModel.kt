package io.usoamic.wallet.ui.main.deposit

import com.google.zxing.common.BitMatrix
import io.usoamic.wallet.commons.usecases.DepositUseCases
import io.usoamic.wallet.extensions.addSchedulers
import io.usoamic.wallet.extensions.toImage
import io.usoamic.wallet.other.MutableLiveData
import io.usoamic.wallet.ui.base.BaseViewModel
import javafx.scene.image.Image
import javax.inject.Inject

class DepositViewModel @Inject constructor(
    private val mDepositUseCases: DepositUseCases
) : BaseViewModel() {
    val ldAddress = MutableLiveData<String>()
    val ldImage = MutableLiveData<Image>()

    init {
        getAddress()
    }

    private fun getAddress() {
        val address = mDepositUseCases.getAddress()
        mDepositUseCases.generateQrCode(address)
            .addSchedulers()
            .addProgress()
            .subscribe({
                setContent(address, it)
            }, ::throwError)
            .addToDisposable()
    }

    private fun setContent(address: String, image: BitMatrix) {
        ldAddress.value = address
        ldImage.value = image.toImage()
    }
}