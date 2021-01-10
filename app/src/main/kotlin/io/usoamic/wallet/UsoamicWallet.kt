package io.usoamic.wallet

import androidx.compose.desktop.Window
import androidx.compose.material.MaterialTheme
import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.sqlite.driver.JdbcSqliteDriver

object UsoamicWallet {
    @JvmStatic
    fun main(args: Array<String>) {
        Window {
            MaterialTheme {
                val driver: SqlDriver = JdbcSqliteDriver(JdbcSqliteDriver.IN_MEMORY)
//                io.usoamic.wallet.database.Data

            }
        }
    }
}

