plugins {
    id(DependencyConfig.Plugin.APPLICATION)
}

android {
    signingConfigs {
        getByName("release") {
            keyAlias = "BaseCompose"
            keyPassword = "Password1*"
            storePassword = "Password1*"
            storeFile(file("keystore/release.jks"))
        }
    }
}