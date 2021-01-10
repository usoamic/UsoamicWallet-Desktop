import org.jetbrains.compose.compose
import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin(Deps.JetBrains.Kotlin.PLATFORM) version Versions.JetBrains.KOTLIN
    kotlin(Deps.JetBrains.Kotlin.KAPT) version Versions.JetBrains.KOTLIN
    id(Deps.JetBrains.Compose.ID) version Versions.JetBrains.COMPOSE
    id(Deps.Squareup.SQLDelight.ID) version Versions.Squareup.SQL_DELIGHT
}

sqldelight {
    database("Database") {
        packageName = "io.usoamic.wallet.database"
    }
}

allprojects {
    group = "io.usoamic"
    version = "1.0.0"
}

repositories {
    jcenter()
    mavenCentral()
    maven { url = uri("https://maven.pkg.jetbrains.space/public/p/compose/dev") }
    maven("https://dl.bintray.com/kotlin/kotlin-eap")
    maven("https://jitpack.io")
}

dependencies {
    testImplementation(kotlin("test-junit"))
    implementation(Deps.Squareup.SQLDelight.SQLITE_DRIVER)
    implementation(Deps.ArkIvanov.Decompose.DECOMPOSE)
    implementation(Deps.ArkIvanov.Decompose.EXTENSIONS_COMPOSE)

    implementation(Deps.Google.GSON)

    implementation(Deps.Web3j.CORE)

    implementation(Deps.ReactiveX.Rx.JAVA)

    implementation(Deps.ReactiveX.Rx.KOTLIN)

    implementation(Deps.Google.Dagger.RUNTIME)
    kapt(Deps.Google.Dagger.COMPILER)


    implementation(Deps.JakeWharton.THREE_TEN_ABP)
    implementation(Deps.Usoamic.KT)
    implementation(Deps.Usoamic.VALIDATE_UTIL_KT)

    implementation(compose.desktop.currentOs)
    implementation(kotlin("stdlib-jdk8"))
}

tasks.test {
    useJUnit()
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "1.8"
}

compose.desktop {
    application {
        mainClass = "MainKt"
        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "io.usoamic.wallet"
        }
    }
}

val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
    jvmTarget = "1.8"
}

val compileTestKotlin: KotlinCompile by tasks
compileTestKotlin.kotlinOptions {
    jvmTarget = "1.8"
}