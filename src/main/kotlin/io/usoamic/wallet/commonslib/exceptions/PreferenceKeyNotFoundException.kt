package io.usoamic.wallet.commonslib.exceptions

import java.lang.Exception

class PreferenceKeyNotFoundException(key: String) : Exception("$key not found")