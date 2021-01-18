package io.usoamic.wallet.extensions

import io.reactivex.Single
import io.reactivex.rxjavafx.schedulers.JavaFxScheduler
import io.usoamic.wallet.commons.extensions.subscribeOnIo


fun <T> Single<T>.observeOnMain(): Single<T> = observeOn(JavaFxScheduler.platform())


fun <T> Single<T>.addSchedulers(): Single<T> = subscribeOnIo().observeOnMain()
