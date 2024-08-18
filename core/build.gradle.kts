plugins {
    alias(libs.plugins.kotlin)
    alias(libs.plugins.maven.publish)
}

group = "io.github.ilyadreamix.gapi.core"
version = libs.versions.gapi.get()

repositories {
    mavenCentral()
}
