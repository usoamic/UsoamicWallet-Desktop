import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

object Version {
    const val tornadoFx = "1.7.2"
}

plugins {
    kotlin("jvm") version "1.4.10"
    application
}
group = "io.usoamic"
version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {
    // https://edvin.gitbooks.io/tornadofx-guide/content/
    implementation("no.tornado", "tornadofx", Version.tornadoFx)
    testImplementation(kotlin("test-junit"))
    implementation(kotlin("stdlib-jdk8"))
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "1.8"
}

application {
    mainClassName = "MainKt"
}

val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
    jvmTarget = "1.8"
}

val compileTestKotlin: KotlinCompile by tasks
compileTestKotlin.kotlinOptions {
    jvmTarget = "1.8"
}