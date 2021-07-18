dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
        jcenter() // Warning: this repository is going to shut down soon
    }
}
rootProject.name = "JetNotes"
include(":androidApp", ":data", ":domain", ":multimodule")