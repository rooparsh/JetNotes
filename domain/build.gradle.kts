plugins {
    id(DependencyConfig.Plugin.ANDROID_LIBRARY_PLUGIN)
    id(DependencyConfig.Plugin.KOTLIN_ANDROID)
    id(DependencyConfig.Plugin.KOTLIN_KAPT)
    id(DependencyConfig.Plugin.ANDROID_HILT)
    id(DependencyConfig.Plugin.KOTLIN_PARCELIZE)
}

android {
    compileSdk = Version.AppConfig.Base.COMPILE_SDK

    defaultConfig {
        minSdk = Version.AppConfig.Base.MIN_SDK
        targetSdk = Version.AppConfig.Base.TARGET_SDK
        testInstrumentationRunner = Version.AppConfig.Base.TEST_RUNNER
    }
}

dependencies {
    api(project(":data"))
    implementation(DependencyManager.domainLibraries)
    kapt(DependencyManager.compilerLibraries)
}