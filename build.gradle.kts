plugins {
    alias(libs.plugins.kotlin)
    alias(libs.plugins.maven.publish)
}

group = "io.github.ilyadreamix.gapi"
version = libs.versions.gapi.get()

repositories {
    mavenCentral()
}

dependencies {
    api(project(":common"))
    api(project(":drive"))
    api(project(":sheets"))
}

afterEvaluate {
    publishing {
        publications.create<MavenPublication>("mavenJava") {
            from(components.findByName("java"))
            groupId = "com.github.ilyadreamix.gapi"
            artifactId = "gapi"
            version = libs.versions.gapi.get()
        }
    }
}
