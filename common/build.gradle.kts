plugins {
    alias(libs.plugins.kotlin)
    alias(libs.plugins.kotlinx.serialization)
    alias(libs.plugins.maven.publish)
}

group = "io.github.ilyadreamix.gapi.common"
version = libs.versions.gapi.get()

repositories {
    mavenCentral()
}

dependencies {
    api(libs.kotlinx.serialization.json)
    api(libs.ktor.client.core)
}

afterEvaluate {
    publishing {
        publications.create<MavenPublication>("mavenJava") {
            from(components.findByName("java"))
            groupId = "com.github.ilyadreamix.gapi"
            artifactId = "common"
            version = libs.versions.gapi.get()
        }
    }
}
