plugins {
    alias(libs.plugins.kotlin)
    alias(libs.plugins.ktor)
}

group = "io.github.ilyadreamix.gapi"
version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":drive"))
}
