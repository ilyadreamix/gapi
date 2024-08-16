plugins {
    `maven-publish`
    alias(libs.plugins.kotlin)
    alias(libs.plugins.ktor)
}

group = "io.github.ilyadreamix.gapi"
version = "1.0.1"

repositories {
    mavenCentral()
}

dependencies {
    api(project(":drive"))
    api(project(":sheets"))
}

afterEvaluate {
    publishing {
        publications.create<MavenPublication>("release") {
            from(components.findByName("java"))
            groupId = "com.github.ilyadreamix.gapi"
            artifactId = "gapi"
            version = "1.0.1"
        }
    }
}
