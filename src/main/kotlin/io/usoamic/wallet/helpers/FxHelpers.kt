package io.usoamic.wallet.helpers

import tornadofx.information

fun informationMessage(message: String) = information(
    header = "",
    content = message
)