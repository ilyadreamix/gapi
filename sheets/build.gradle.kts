plugins {
    alias(libs.plugins.kotlin)
    alias(libs.plugins.maven.publish)
}

group = "io.github.ilyadreamix.gapi.sheets"
version = libs.versions.gapi.get()

repositories {
    mavenCentral()
}

afterEvaluate {
    publishing {
        publications.create<MavenPublication>("release") {
            from(components.findByName("release"))
            groupId = "com.github.ilyadreamix.gapi"
            artifactId = "sheets"
            version = libs.versions.gapi.get()
        }
    }
}
