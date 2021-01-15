package io.usoamic.wallet.ui.main.deposit

import java.awt.image.BufferedImage

@Deprecated("Move to separate library")
data class DepositInfo(
    val address: String,
    val qrCode: BufferedImage
)