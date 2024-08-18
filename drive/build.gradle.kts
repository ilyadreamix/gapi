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

afterEvaluate {
    publishing {
        publications.create<MavenPublication>("mavenJava") {
            from(components.findByName("java"))
            groupId = "com.github.ilyadreamix.gapi"
            artifactId = "drive"
            version = libs.versions.gapi.get()
        }
    }
}
