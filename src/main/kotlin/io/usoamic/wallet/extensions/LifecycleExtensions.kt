package io.usoamic.wallet.extensions

import io.usoamic.wallet.other.MutableLiveData
import tornadofx.onChange

fun <T> observe(ld: MutableLiveData<T>, callback: (T) -> Unit) {
    ld.onChange {
        if(it != null) {
            callback.invoke(it)
        }
    }
}

fun MutableLiveData<Unit>.emit() {
    value = null
    value = Unit
}

fun <T> MutableLiveData<T>.emit(arg: T) {
    value = null
    value = arg
}