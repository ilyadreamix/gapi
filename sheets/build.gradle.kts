plugins {
    alias(libs.plugins.kotlin)
    alias(libs.plugins.maven.publish)
}

group = "io.github.ilyadreamix.gapi.sheets"
version = libs.versions.gapi.get()

repositories {
    mavenCentral()
}
