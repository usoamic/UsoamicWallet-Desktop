package io.usoamic.wallet.commonslib.models.deposit

import javafx.scene.image.Image

@Deprecated("Move to separate library")
data class DepositInfo(
    val address: String,
    val qrCode: Image
)