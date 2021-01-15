package io.usoamic.wallet.commonslib.models.ethereum

import io.usoamic.wallet.extensions.privateKey
import org.web3j.crypto.Credentials
@Deprecated("Move to separate library")
data class AccountCredentials(
    val address: String,
    val privateKey: String
)

fun Credentials.toDomain() = AccountCredentials(
    address,
    privateKey
)