package io.usoamic.wallet.commonslib.models.base

@Deprecated("Move to separate library")
sealed class ErrorArguments(val throwable: Throwable) {
    val message get() = throwable.message

    data class Warning(private val t: Throwable) : ErrorArguments(t)
    data class Fatal(private val t: Throwable) : ErrorArguments(t)
}