package io.usoamic.wallet.ui.base

import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.usoamic.wallet.commons.models.base.ErrorArguments
import io.usoamic.wallet.other.MutableLiveData
import tornadofx.ViewModel

open class BaseViewModel : ViewModel() {
    private val compositeDisposable = CompositeDisposable()

    val ldProgress = MutableLiveData<Boolean>(false)
    val ldThrowable = MutableLiveData<ErrorArguments>()
    val ldError = MutableLiveData<String>()

    protected open fun throwError(throwable: Throwable) {
        throwable.printStackTrace()
        ldThrowable.value = ErrorArguments.Warning(throwable)
    }

    protected open fun throwErrorAndFinish(throwable: Throwable) {
        throwable.printStackTrace()
        ldThrowable.value = ErrorArguments.Fatal(throwable)
    }

    protected fun <T> Single<T>.addProgress(): Single<T> {
        return doOnSubscribe { ldProgress.value = true }
            .doAfterTerminate { ldProgress.value = false }
    }

    protected fun Disposable.addToDisposable() {
        compositeDisposable.add(this)
    }

    fun onCleared() {
        compositeDisposable.clear()
    }
}