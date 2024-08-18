plugins {
    alias(libs.plugins.kotlin)
    alias(libs.plugins.maven.publish)
}

group = "io.github.ilyadreamix.gapi.core"
version = libs.versions.gapi.get()

repositories {
    mavenCentral()
}

dependencies {
    api(libs.kotlinLogging)
    api(libs.kotlinx.serialization.json)
    api(libs.ktor.client.core)
    api(libs.ktor.client.cio)
    api(libs.ktor.client.contentNegotiation)
    api(libs.ktor.client.json)
    api(libs.ktor.client.logging)
}
