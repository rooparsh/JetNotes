plugins {
    id(DependencyConfig.Plugin.APPLICATION)
}

subprojects {
    apply {
        from("signing.gradle.kts")
    }
}

android {
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}