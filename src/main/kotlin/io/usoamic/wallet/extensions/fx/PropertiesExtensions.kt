package io.usoamic.wallet.extensions.fx

import javafx.beans.property.StringProperty

fun StringProperty.clear() {
    value = ""
}