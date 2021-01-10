object Deps {
    object Usoamic {
        const val KT = "com.github.usoamic:usoamickt:v${Versions.Usoamic.KT}"
        const val VALIDATE_UTIL_KT = "com.github.usoamic:validateutil:v${Versions.Usoamic.VALIDATE_UTIL_KT}"
    }

    object JakeWharton {
        const val THREE_TEN_ABP = "com.jakewharton.threetenabp:threetenabp:${Versions.JakeWharton.THREE_TEN_ABP}"
    }

    object ReactiveX {
        object Rx {
            const val JAVA = "io.reactivex.rxjava2:rxjava:${Versions.ReactiveX.Rx.JAVA}"
            const val KOTLIN = "io.reactivex.rxjava2:rxkotlin:${Versions.ReactiveX.Rx.KOTLIN}"
        }
    }

    object Google {
        object Dagger {
            const val RUNTIME = "com.google.dagger:dagger:${Versions.Google.DAGGER}"
            const val COMPILER = "com.google.dagger:dagger-compiler:${Versions.Google.DAGGER}"
        }

        const val GSON = "com.google.code.gson:gson:${Versions.Google.GSON}"
    }

    object Web3j {
        const val CORE = "org.web3j:core:${Versions.Web3j.CORE}"
    }

    object JetBrains {
        object Kotlin {
            const val PLATFORM = "jvm"
            const val KAPT = "kapt"
            const val GRADLE_PLUGIN = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.JetBrains.KOTLIN}"
            const val TEST_COMMON = "org.jetbrains.kotlin:kotlin-test-common:${Versions.JetBrains.KOTLIN}"
            const val TEST_JUNIT = "org.jetbrains.kotlin:kotlin-test-junit:${Versions.JetBrains.KOTLIN}"
            const val TEST_ANNOTATIONS_COMMON = "org.jetbrains.kotlin:kotlin-test-annotations-common:${Versions.JetBrains.KOTLIN}"
        }

        object Compose {
            const val ID = "org.jetbrains.compose"
        }
    }

    object ArkIvanov {
        object Decompose {
            const val DECOMPOSE = "com.arkivanov.decompose:decompose:${Versions.ArkIvanov.DECOMPOSE}"
            const val EXTENSIONS_COMPOSE = "com.arkivanov.decompose:extensions-compose-jetbrains:${Versions.ArkIvanov.DECOMPOSE}"
        }
    }

    object Squareup {
        object SQLDelight {
            const val ID = "com.squareup.sqldelight"
            const val GRADLE_PLUGIN = "com.squareup.sqldelight:gradle-plugin:${Versions.Squareup.SQL_DELIGHT}"
            const val SQLITE_DRIVER = "com.squareup.sqldelight:sqlite-driver:${Versions.Squareup.SQL_DELIGHT}"
        }
    }
}
