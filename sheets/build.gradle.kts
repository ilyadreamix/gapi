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
        publications.create<MavenPublication>("mavenJava") {
            from(components.findByName("java"))
            groupId = "com.github.ilyadreamix.gapi"
            artifactId = "sheets"
            version = libs.versions.gapi.get()
        }
    }
}
