package io.usoamic.wallet.commonslib.usecases

import com.google.zxing.BarcodeFormat
import com.google.zxing.qrcode.QRCodeWriter
import io.reactivex.Single
import io.usoamic.wallet.commonslib.repositories.PreferencesRepository
import io.usoamic.wallet.extensions.addDebugDelay
import java.awt.Color
import java.awt.image.BufferedImage
import javax.inject.Inject

class DepositUseCases @Inject constructor(
    private val mPreferencesRepository: PreferencesRepository
) {
    fun getAddress(): String {
        return mPreferencesRepository.getAddress()
    }

    fun generateQrCode(content: String): Single<BufferedImage> {
        return Single.fromCallable {
            val writer = QRCodeWriter()
            val bitMatrix = writer.encode(content, BarcodeFormat.QR_CODE, 512, 512)
            val width = bitMatrix.width
            val height = bitMatrix.height

            val bitmap = BufferedImage(width, height, BufferedImage.TYPE_USHORT_565_RGB)
            for (x in 0 until width) {
                for (y in 0 until height) {
                    bitmap.setRGB(x, y, if (bitMatrix.get(x, y)) Color.BLACK.rgb else Color.WHITE.rgb)
                }
            }
            bitmap
        }
            .addDebugDelay()
    }
}