plugins {
    alias(libs.plugins.kotlin)
    alias(libs.plugins.kotlinx.serialization)
    alias(libs.plugins.maven.publish)
}

group = "io.github.ilyadreamix.gapi.drive"
version = libs.versions.gapi.get()

repositories {
    mavenCentral()
}

dependencies {
    implementation(libs.kotlin.reflection)
    implementation(project(":core"))
    api(project(":common"))
}
