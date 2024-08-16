plugins {
    alias(libs.plugins.kotlin)
    alias(libs.plugins.kotlinx.serialization)
    alias(libs.plugins.ktor)
}

group = "io.github.ilyadreamix.gapi.common"
version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {
    api(libs.kotlinx.serialization.json)
    api(libs.ktor.client.core)
    api(libs.ktor.client.cio)
    api(libs.ktor.client.contentNegotiation)
    api(libs.ktor.client.json)
    api(libs.ktor.client.logging)
    api(libs.kotlinLogging)
}
