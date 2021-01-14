package io.usoamic.wallet.other

import javafx.beans.property.SimpleObjectProperty

typealias MutableLiveData<T> = SimpleObjectProperty<T>
typealias LiveData<T> = SimpleObjectProperty<T>
typealias LiveEvent<T> = MutableLiveData<T>

fun <T> liveDataOf(value: T): LiveData<T> {
    return LiveData(value)
}