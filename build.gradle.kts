import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

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
    testImplementation(kotlin("test-junit"))
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "1.8"
}

application {
    mainClassName = "MainKt"
}