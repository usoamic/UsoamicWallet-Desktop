package io.usoamic.wallet.other

import javafx.beans.property.SimpleObjectProperty

typealias MutableLiveData<T> = SimpleObjectProperty<T>
typealias LiveEvent<T> = MutableLiveData<T>